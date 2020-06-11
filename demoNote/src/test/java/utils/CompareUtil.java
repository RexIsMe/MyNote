package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Rex
 * @title: CompareUtil
 * @projectName demoNote
 * @description: 各种“比较”的工具类
 * @date 2020/5/710:14
 */
public class CompareUtil {

    public static void main(String[] args) throws Exception {

        List list1 = txt2List("C:\\Users\\99686\\Desktop\\tyche\\dingding_download\\data_20200508_082443.txt");
        readList(list1);
//        List list2 = txt2List("C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\lock.txt");
//
//        List diffrent4 = getDiffrent4(list1, list2);
//        sortList(diffrent4);
//        readList(diffrent4);

//        list2TXT(diffrent4, "C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\result.txt");


        zip2List();
        System.out.println(codeString("C:\\Users\\99686\\Desktop\\tyche\\dingding_download\\data_20200508_082443.txt"));
    }

    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<String> getFiles(String path) {
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                //文件名，不包含路径
                //String fileName = tempList[i].getName();
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return files;
    }

    /**
     * 获得文件编码
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        bin.close();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }

    /**
     * 读取压缩文件下的所有文件
     * @throws Exception
     */
    public static void zip2List() throws Exception {
        //获取文件输入流
        FileInputStream input = new FileInputStream("C:\\Users\\99686\\Desktop\\tyche\\dingding_download\\data_20200508_082443.zip");

        //获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException: MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(input), Charset.forName("GBK"));

        //定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;

        //循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {

            System.out.println("文件名：" + ze.getName() + " 文件大小：" + ze.getSize() + " bytes");
            System.out.println("文件内容：");

            //读取
            BufferedReader br = new BufferedReader(new InputStreamReader(zipInputStream,Charset.forName("GBK")));

            String line;

            //内容不为空，输出
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                break;
            }
        }

        //一定记得关闭流
        zipInputStream.closeEntry();
        input.close();
    }

    /**
     * 读取文本中的每一行作为一个元素封装为list返回
     */
    public static List txt2List(String filePath) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                String trim = s.trim();
                list.add(trim);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 取出两个List中的不同元素，并返回
     * @param list1
     * @param list2
     * @return
     */
    private static List<String> getDiffrent4(List<String> list1, List<String> list2) {
        long st = System.nanoTime();
        Map<String,Integer> map = new HashMap<String,Integer>(list1.size()+list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        System.out.println("getDiffrent4 total times "+(System.nanoTime()-st));
        return diff;

    }

    /**
     * 遍历list并打印到控制台
     * @param list
     */
    public static void readList(List list){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    /**
     * 将list按照一个元素一行写出到txt
     * @param list
     * @param filePath
     * @throws Exception
     */
    public static void list2TXT (List list, String filePath) throws Exception{
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(filePath));//构造一个BufferedReader类来读取文件
            String s = null;
            for (Object o : list) {
                br.write(o.toString() + "\r\n");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 对list排序
     * @param list
     */
    public static void sortList(List list){
        Collections.sort(list);
        Collections.reverse(list);
    }
}
