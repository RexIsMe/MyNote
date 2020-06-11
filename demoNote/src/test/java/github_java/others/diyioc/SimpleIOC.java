package github_java.others.diyioc;

/**
 * @author Rex
 * @title: DiyIOC
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1418:53
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BaoZi
 * @create 2019-07-19-8:54
 */
public class SimpleIOC {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + name);
        }

        return bean;
    }

    private void loadBeans(String location) throws Exception {
        // 加载 xml 配置文件
        //把要解析的 XML 文档转化为输入流对象，以便 DOM 解析器解析它
        InputStream inputStream = new FileInputStream(location);
        /**
         * javax.xml.parsers 包中的DocumentBuilderFactory用于创建DOM模式的解析器对象 ，
         * DocumentBuilderFactory是一个抽象工厂类，它不能直接实例化，但该类提供了一个newInstance方法 ，
         * 这个方法会根据本地平台默认安装的解析器，自动创建一个工厂的对象并返回。
         */
        //调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂。
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //调用工厂对象的 newDocumentBuilder方法得到 DOM 解析器对象。
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        //调用 DOM 解析器对象的 parse() 方法解析 XML 文档，得到代表整个文档的 Document 对象，
        // 进行可以利用DOM特性对整个XML文档进行操作了。
        Document doc = docBuilder.parse(inputStream);
        //得到 XML 文档的根节点
        Element root = doc.getDocumentElement();
        //得到节点的子节点
        NodeList nodes = root.getChildNodes();

        // 遍历 <bean> 标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                // 加载 beanClass
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }

                // 创建 bean
                Object bean = beanClass.newInstance();

                // 遍历 <property> 标签
                //使用Document对象的getElementsByTagName()方 法，我们可以得到一个NodeList对象，
                // 一个Node对象代表了一个XML文档中的一个标签元素，而NodeList对象，观其名而知其意，
                // 所代表的是一个Node对象的列表：
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                        // 利用反射将 bean 相关字段访问权限设为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            // 将属性值填充到相关字段中
                            declaredField.set(bean, value);
                        } else {
                            //这里是Bean对象属性中循环引用问题（先不做处理）
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }

                            // 将引用填充到相关字段中
                            declaredField.set(bean, getBean(ref));
                        }

                        // 将 bean 注册到 bean 容器中
                        registerBean(id, bean);
                    }
                }
            }
        }
    }
    //这里模仿Bean对象注入IOC容器中的过程
    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }
}
