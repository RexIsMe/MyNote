package com.example.demo.generator;

import com.google.common.base.CaseFormat;
import com.example.demo.utils.PropertiesUtil;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @author zhangcan
 */
public class Generator {
	/** 模块名称 */
	public static final String MODULE_NAME = "system";
	/** xml mapper 文件生成路径 */
	public static final String XML_MAPPER_URL = "src/main/resources/mapper/manage/";
	/** 模块文件生成路径 */
	public static final String MODULE_PATH_URL = "src/main/java/com/tyche/icms/module/";
	/** entity文件生成路径 */
	public static final String ENTITY_PATH_URL = "src/main/java/com/tyche/icms/entity";

	public static void main(String[] args) throws Exception {
		String generatorName = "zhangcan";
		String[] table = new String[]{"ic_white_member"};
		Generator generator = new Generator();
        generator.entity(table, generatorName);
        generator.dto(table, generatorName);
        generator.mapper(table, generatorName);
        generator.service(table, generatorName);
		generator.pageparam(table, generatorName);
		generator.controller(table, generatorName);
	}

	private Configuration config;

	private Generator() throws IOException {
		this.config = new Configuration(Configuration.VERSION_2_3_28);
		this.config.setDirectoryForTemplateLoading(new File(this.getTemplatePath()));
	}

	/**
	 * 获取数据库连接
	 *
	 * @return
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception {
		String url = PropertiesUtil.getDevProperty("spring.datasource.druid.url");
		String username = PropertiesUtil.getDevProperty("spring.datasource.druid.username");
		String password = PropertiesUtil.getDevProperty("spring.datasource.druid.password");
		Class.forName(PropertiesUtil.getCommonProperty("spring.datasource.druid.driver-class-name"));
		return DriverManager.getConnection(url, username, password);
	}

	private String getResourcePath() {
		return System.getProperty("os.name").toLowerCase().startsWith("win")
				? Generator.class.getResource(".").getPath().substring(1)
				: Generator.class.getResource(".").getPath();
	}

	private String getTemplatePath() {
		String resourcePath = getResourcePath();
		return (resourcePath.substring(0, resourcePath.indexOf("target")))
				+ "src/main/java/com/tyche/icms/generator/template";
	}

	private String getPath() {
		String resourcePath = getResourcePath();
		return (resourcePath.substring(0, resourcePath.indexOf("target"))) + MODULE_PATH_URL;
	}

	private String getMapperPath() {
		String resourcePath = getResourcePath();
		return (resourcePath.substring(0, resourcePath.indexOf("target"))) + XML_MAPPER_URL;
	}

	private HashMap<String, Object> getParam(String tableName, String generatorName) throws Exception {
		try (Connection conn = this.getConnection();
			 PreparedStatement cps = conn.prepareStatement("SHOW FULL COLUMNS FROM " + tableName);
			 ResultSet crs = cps.executeQuery();
			 PreparedStatement tps = conn.prepareStatement("SHOW CREATE TABLE " + tableName);
			 ResultSet trs = tps.executeQuery();) {
			tableName = tableName.toLowerCase();
			// String moduleName = tableName.substring(0, tableName.indexOf("_"));

			String moduleName = MODULE_NAME;
			String entityName = this.getEntityName(tableName);
			String packageName = entityName.toLowerCase().charAt(0) + entityName.substring(1);
			List<ColumnVO> columns = new ArrayList<ColumnVO>();
			while (crs.next()) {
				ColumnVO vo = new ColumnVO();
				vo.setName(crs.getString("Field"));
				vo.setComment(crs.getString("Comment"));
				vo.setType(crs.getString("Type"));
				columns.add(vo);
			}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("tableName", tableName);
			map.put("moduleName", moduleName);
			map.put("entityName", entityName);
			map.put("columns", columns);
			map.put("packageName", packageName);
			map.put("generatorName", generatorName);
			map.put("prefixUrl", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, packageName).replaceAll("_", "/"));
			while (trs.next()) {
				String createDDL = trs.getString(2);
				map.put("tableComment", getComment(createDDL));
			}
			return map;
		} catch (Exception e) {
			throw e;
		}
	}

	private String getComment(String ddl) {
		int index = ddl.indexOf("COMMENT='");
		if (index < 0) {
			return "";
		}
		String comment = ddl.substring(index + 9);
		comment = comment.substring(0, comment.length() - 1);
		return comment;
	}

	@SuppressWarnings("unchecked")
	private void entity(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate Entity start...");
		String resourcePath = getResourcePath();
		String generatePath = (getResourcePath().substring(0, resourcePath.indexOf("target"))) + ENTITY_PATH_URL;
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			System.out.println(
					"=====================> " + generatePath + "/" + map.get("entityName") + " writing!");
			this.generateEntity(generatePath, tableName, (String) map.get("moduleName"), (String) map.get("entityName"),
					(List<ColumnVO>) map.get("columns"), generatorName, (String) map.get("tableComment"));
		}
		System.out.println("=====================> generate Entity done!");
	}

	@SuppressWarnings("unchecked")
	private void pageparam(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate Entity start...");
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			String generatePath = getPath() + map.get("moduleName") + "/param";
			System.out.println(
					"=====================> " + generatePath + "/" + map.get("entityName") + " writing!");
			this.generatePageParam(generatePath, tableName, (String) map.get("moduleName"), (String) map.get("entityName"),
					(List<ColumnVO>) map.get("columns"), generatorName, (String) map.get("tableComment"));
		}
		System.out.println("=====================> generate Entity done!");
	}

	private void generatePageParam(String generatePath, String tableName, String moduleName, String entityName,
								   List<ColumnVO> columns, String generatorName, String tableComment) throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		StringBuilder imports = new StringBuilder();
		StringBuilder efields = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			String columnName = columns.get(i).getName();
			if (!columnName.equals("create_time") && !columnName.equals("update_time")
					&& !columnName.equals("update_user") && !columnName.equals("create_user")) {
				String fieldName = this.getFieldName(columnName);
				String javaType = this.getJavaType(columns.get(i).getType());
				// imports
				if (javaType.equals("BigDecimal")) {
					imports.append("import java.math.BigDecimal;\r\n");
				}
				if (javaType.equals("Date")) {
					imports.append("import java.util.Date;\r\n");
				}
				efields.append("@Comment(\"" + columns.get(i).getComment() + "\")\r\n\t");
				// fields
				efields.append("private " + javaType + " " + fieldName + ";\r\n\t");
			}
		}
		params.put("imports", imports.toString());
		params.put("efields", efields.toString());

		this.config.getTemplate("pageparam.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(generatePath + "/" + entityName + "PageParam.java"))));
	}

	private void dto(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate DTO start...");
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			String generatePath = getPath() + map.get("moduleName") + "/dto";
			System.out.println(
					"=====================> " + generatePath + "/" + (String) map.get("entityName") + "DTO writing!");
			this.generateDto(generatePath, tableName, (String) map.get("moduleName"), (String) map.get("entityName"),
					(String) map.get("packageName"), generatorName, (String) map.get("tableComment"));
		}
		System.out.println("=====================> generate DTO done!");
	}

	@SuppressWarnings("unchecked")
	private void mapper(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate Mapper start...");
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			this.generateMapper(getPath() + map.get("moduleName") + "/mapper",
					getMapperPath() + map.get("moduleName"), tableName, (String) map.get("moduleName"),
					(String) map.get("entityName"), (String) map.get("packageName"), generatorName,
					(String) map.get("tableComment"), (List<ColumnVO>) map.get("columns"));
		}
		System.out.println("=====================> generate Mapper done!");
	}

	private void service(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate Service start...");
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			this.generateService(getPath() + map.get("moduleName") + "/service",
					getPath() + map.get("moduleName") + "/service/impl", tableName,
					(String) map.get("moduleName"), (String) map.get("entityName"), (String) map.get("packageName"),
					generatorName, (String) map.get("tableComment"));
		}
		System.out.println("=====================> generate Service done!");
	}

	private void controller(String[] table, String generatorName) throws Exception {
		System.out.println("=====================> generate Controller start...");
		for (int i = 0; i < table.length; i++) {
			String tableName = table[i];
			HashMap<String, Object> map = getParam(tableName, generatorName);
			this.generateController(getPath() + map.get("moduleName") + "/controller", tableName,
					(String) map.get("moduleName"), (String) map.get("entityName"), (String) map.get("packageName"),
					generatorName, (String) map.get("tableComment"), (String) map.get("prefixUrl"));
		}
		System.out.println("=====================> generate Controller done!");
	}

	private void generateEntity(String generatePath, String tableName, String moduleName, String entityName,
								List<ColumnVO> columns, String generatorName, String tableComment) throws
			IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		StringBuilder imports = new StringBuilder();
		StringBuilder efields = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			String columnName = columns.get(i).getName();
			if (!columnName.equals("create_time")
					&& !columnName.equals("update_time")
					&& !columnName.equals("update_user")
					&& !columnName.equals("create_user")
					&& !columnName.equals("update_user_id")
					&& !columnName.equals("update_user_real_name")
					&& !columnName.equals("create_user_id")
					&& !columnName.equals("create_user_real_name")

			) {
				String fieldName = this.getFieldName(columnName);
				String javaType = this.getJavaType(columns.get(i).getType());
				// imports
				if (javaType.equals("BigDecimal")) {
					imports.append("import java.math.BigDecimal;\r\n");
				}
				if (javaType.equals("Date")) {
					imports.append("import java.util.Date;\r\n");
				}
				if (columnName.equals("id")) {
					imports.append("import javax.persistence.Id;\r\n");
					imports.append("import javax.persistence.Column;\r\n");
					imports.append("import javax.persistence.GeneratedValue;\r\n");
					imports.append("import javax.persistence.GenerationType;\r\n");
					efields.append("@Id\r\n\t");
					efields.append("@Column(name = \"id\")\r\n\t");
					efields.append("@GeneratedValue(strategy = GenerationType.IDENTITY)\r\n\t");
				}
				efields.append("@Comment(\"" + columns.get(i).getComment() + "\")\r\n\t");
				// fields
				efields.append("private " + javaType + " " + fieldName + ";\r\n\t");
			}
		}
		params.put("imports", imports.toString());
		params.put("efields", efields.toString());

		this.config.getTemplate("entity.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(generatePath + "/" + entityName + ".java"))));
	}

	private void generateDto(String generatePath, String tableName, String moduleName, String entityName,
							 String packageName, String generatorName, String tableComment) throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("packageName", packageName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		this.config.getTemplate("dto.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(generatePath + "/" + entityName + "DTO.java"))));
	}

	private void generateMapper(String daoPath, String mapperPath, String tableName, String moduleName,
								String entityName, String packageName, String generatorName, String
										tableComment, List<ColumnVO> columns)
			throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("packageName", packageName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		StringBuilder results = new StringBuilder();
		StringBuilder wheres = new StringBuilder();
		List<String> columnList = new ArrayList<String>();
		for (int i = 0; i < columns.size(); i++) {
			String columnName = columns.get(i).getName();
			String columnType = this.getMapperType(columns.get(i).getType());
			String fieldName = this.getFieldName(columnName);
			if (columnName.equals("id")) {
				results.append("<id column=\"id\" property=\"id\" jdbcType=\"BIGINT\" />");
			} else {
				results.append("<result column=\"" + columnName + "\" property=\"" + fieldName + "\" jdbcType=\""
						+ columnType + "\" />");
			}
			if (i != columns.size() - 1) {
				results.append("\r\n\t\t");
			}

			columnList.add(columnName);
			if(!columnName.equals("create_time")
					&&!columnName.equals("update_time")
					&&!columnName.equals("create_user")
					&&!columnName.equals("update_user")){
				if (columnType.equalsIgnoreCase("varchar") || columnType.equalsIgnoreCase("char")) {
					wheres.append("<if test=\"@org.apache.commons.lang3.StringUtils@isNotBlank(param." + fieldName
							+ ")\">\r\n\t\t\t\t\t");
					wheres.append(" and " + columnName + " like concat('%',#{param." + fieldName + "},'%') \r\n\t\t\t\t");
					wheres.append("</if>\r\n\t\t\t\t");
				} else {
					wheres.append("<if test=\"param." + this.getFieldName(columnName) + "!=null\">\r\n\t\t\t\t\t");
					wheres.append(" and " + columnName + " = #{param." + fieldName + "} \r\n\t\t\t\t");
					wheres.append("</if>\r\n\t\t\t\t");
				}

			}
		}
		params.put("wheres", wheres.toString());
		params.put("results", results.toString());
		params.put("columns", StringUtils.join(columnList, ","));
		System.out.println("=====================> " + daoPath + "/" + entityName + "Mapper.java writing!");
		this.config.getTemplate("dao.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(daoPath + "/" + entityName + "Mapper.java"))));
		System.out.println("=====================> " + mapperPath + "/" + entityName + "Mapper.xml writing!");
		this.config.getTemplate("mapper.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(mapperPath + "/" + entityName + "Mapper.xml"))));
	}

	private void generateService(String servicePath, String implPath, String tableName, String moduleName,
								 String entityName, String packageName, String generatorName, String tableComment)
			throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("packageName", packageName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println("=====================> " + servicePath + "/" + entityName + "Service.java writing!");
		this.config.getTemplate("service.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(servicePath + "/" + entityName + "Service.java"))));
		System.out.println("=====================> " + implPath + "/" + entityName + "ServiceImpl.java writing!");
		this.config.getTemplate("serviceImpl.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(implPath + "/" + entityName + "ServiceImpl.java"))));
	}

	private void generateController(String path, String tableName, String moduleName, String entityName,
									String packageName, String generatorName, String tableComment, String prefixUrl) throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("packageName", packageName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("prefixUrl", prefixUrl);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println("=====================> " + path + "/" + entityName + "Controller.java writing!");
		this.config.getTemplate("controller.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(path + "/" + entityName + "Controller.java"))));
	}

	private void generateParam(String generatePath, String tableName, String moduleName, String entityName,
							   String packageName, String generatorName, String tableComment) throws IOException, TemplateException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("moduleName", moduleName);
		params.put("tableName", tableName);
		params.put("entityName", entityName);
		params.put("packageName", packageName);
		params.put("generatorName", generatorName);
		params.put("tableComment", tableComment);
		params.put("currentDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		this.config.getTemplate("param.ftl").process(params, new OutputStreamWriter(
				FileUtils.openOutputStream(new File(generatePath + "/" + entityName + "Param.java"))));
	}


	private String getEntityName(String tableName) {
		String[] splits = tableName.substring(tableName.indexOf("_") + 1).split("_");
		StringBuilder sb = new StringBuilder();
		for (String str : splits)
			sb.append(str.toUpperCase().charAt(0) + str.toLowerCase().substring(1));
		return sb.toString();
	}

	private String getFieldName(String columnName) {
		String[] splits = columnName.split("_");
		StringBuilder sb = new StringBuilder();
		for (String str : splits)
			sb.append(str.toUpperCase().charAt(0) + str.toLowerCase().substring(1));
		String name = sb.toString();
		return name.toLowerCase().charAt(0) + name.substring(1);
	}

	private String getJavaType(String columnType) {
		switch (columnType) {
			case "double":
				return "Double";
			case "longtext":
				return "String";
			case "text":
				return "String";
			case "date":
				return "Date";
			case "datetime":
				return "Date";
			default:
				switch (columnType.substring(0, columnType.indexOf("("))) {
					case "varchar":
						return "String";
					case "double":
						return "Double";
					case "int":
						return "Integer";
					case "tinyint":
						return "Integer";
					case "smallint":
						return "Integer";
					case "bigint":
						return "Long";
					case "bit":
						return "Boolean";
					case "decimal":
						return "BigDecimal";
					case "char":
						return "String";
					default:
						return "NOT_FOUND";
				}
		}
	}

	private String getMapperType(String columnType) {
		switch (columnType) {
			case "double":
				return "DOUBLE";
			case "longtext":
				return "VARCHAR";
			case "text":
				return "VARCHAR";
			case "datetime":
				return "TIMESTAMP";
			case "date":
				return "DATE";
			default:
				switch (columnType.substring(0, columnType.indexOf("("))) {
					case "varchar":
						return "VARCHAR";
					case "double":
						return "DOUBLE";
					case "int":
						return "INTEGER";
					case "tinyint":
						return "INTEGER";
					case "smallint":
						return "INTEGER";
					case "bigint":
						return "BIGINT";
					case "bit":
						return "BIT";
					case "decimal":
						return "DECIMAL";
					case "char":
						return "CHAR";
					default:
						return "NOT_FOUND";
				}
		}
	}

	private class ColumnVO {

		private String comment;
		private String name;
		private String type;

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

}
