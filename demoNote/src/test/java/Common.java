import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.file.FileUtil;
import org.junit.Test;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Rex
 * @title: Common
 * @projectName demoNote
 * @description: TODO
 * @date 2020/4/1213:50
 */
public class Common {

    @org.junit.Test
    public void test6(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        System.out.println(integers);

        List dest = Arrays.asList(new Integer[integers.size()]);
        Collections.copy(dest, integers);

        System.out.println(dest);
//        dest.remove(1);
//        System.out.println(dest);

        List dsf = dest;
        dsf.remove(1);
        System.out.println(dsf);

    }



    @org.junit.Test
    public void testx(){
        String[] sshInfo = new String[]{"47.92.135.203","root","FeTest@#Tyche.com1!"};
        String date = "2020_0513_1535";
        String[] commands = new String[]{
                "cd /usr/local/rabbitmq3.7/var/log/rabbitmq/tcp; tcpdump -nn -X -i eth0 -r 2020_0515_1304_16.pcap"
        };
        exeCommand(sshInfo, commands, "datat");
    }

    @org.junit.Test
    public void testz(){
        String[] sshInfo = new String[]{"47.92.135.203","root","FeTest@#Tyche.com1!"};
        String date = "2020_0513_1535";
        String[] commands = new String[]{
                "cd /usr/local/rabbitmq3.7/var/log/rabbitmq/tcp; tcpdump -nn -X -i eth0 -r 2020_0515_0952_06.pcap"
        };
        exeCommand(sshInfo, commands, "data2");
    }




    /**
     *实现下载服务器上的文件到本地指定目录
     * @param conn SSH连接信息
     * @param fileName 服务器上的文件地址/opt/scf2/log/loanorder/all.log
     * @param localPath 本地路径：D:\
     * @throws IOException
     */

    public static void getFile(Connection conn, String fileName, String localPath) throws IOException{

        SCPClient scpClient=conn.createSCPClient();
        //String logPath="cd /opt/scf2/log/loanorder";
        //Session session = conn.openSession();
        //session.execCommand(logPath);//执行shell命令
        scpClient.get(fileName,localPath);

    }

    /**
     * 执行函数
     * @param commands 执行命令
     * @param sshInfo 远程连接信息 包括远程地址用户名密码
     * @return
     */
    public static boolean exeCommand(String[] sshInfo,String[] commands, String prefixName){

        Session sess = null;
        Connection conn = null;
        boolean result=false;
        try {
            conn = getConnect(sshInfo);

            for (int i = 0; i < commands.length; i++) {
                System.out.println("开始读取第【" + i + "】个文件");
                sess = conn.openSession();
                sess.execCommand(commands[i]);
                result = getResult(sess, prefixName);
                if (!result) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (sess != null) {
                sess.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return true;
    }


    public static Connection getConnect(String[] sshInfo){
        String sshPort="22";//ssh远程连接的默认端口是22
        String hostIp=sshInfo[0];
        String hostName=sshInfo[1];
        String hostPassword=sshInfo[2];
        Connection conn = null;
        try {
            conn = new Connection(hostIp, Integer.valueOf(sshPort));
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(hostName, hostPassword);

            if (isAuthenticated == false) {
                throw new IOException("Authentication failed. name= " + hostIp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 获取Linux执行以后的信息进行判断
     * @param sess
     * @return
     * @throws IOException
     */
    private static boolean getResult(Session sess, String prefixName) throws IOException{
        StringBuffer stringBuffer=new StringBuffer();
        BufferedReader stderrReader = null;
        BufferedReader stdoutReader = null;
        try {
            InputStream stdout = new StreamGobbler(sess.getStdout());
//            InputStream stderr = new StreamGobbler(sess.getStderr());
//            stderrReader = new BufferedReader(new InputStreamReader(stderr, "UTF-8"));
            stdoutReader = new BufferedReader(new InputStreamReader(stdout, "UTF-8"));
            char[] arr = new char[1024 * 1024 * 1024 * 5];//1M
            int read;
            StringBuilder outmsg = new StringBuilder();
            int count = 0;
            while (true) {
                count++;
                if(count%10000 == 0){
                    System.out.println(new Date() + "读取进度：" + count);
                }

                String s = stdoutReader.readLine();

//                read = stdoutReader.read(arr, 0, arr.length);
//                if (read < 0) {
//                    break;
//                }
//                String s = new String(arr, 0, read);


                outmsg.append(s);


                if(count%1000000 == 0){
                    SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");
                    String fileName = prefixName + sdf.format(new Date()) +".txt";
                    FileUtil.writeTxt("C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\data_log\\0515\\"+ fileName, outmsg.toString());
                    System.out.println("导出文件：" + fileName);
                    outmsg.delete( 0, outmsg.length() );
                }

            }
//            System.out.println(outmsg);


//            while (true) {
//                read = stderrReader.read(arr, 0, arr.length);
//                if (read < 0) {
//                    break;
//                }
//                stringBuffer.append(new String(arr, 0, read));
//            }
//            System.err.println("错误信息：" + stringBuffer);
//            if(stringBuffer.length()>0){
//                return false;
//            }else{
//                return true;
//            }

        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            if (stderrReader != null) {
                stderrReader.close();
            }
            if (stdoutReader != null) {
                stdoutReader.close();
            }
        }
    }










    @org.junit.Test
    public  void  test3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMdd_HH");
        System.out.println(sdf.format(new Date()));
    }



    @org.junit.Test
    public void test()  throws  Exception{
        String str1 =  "{\"__source__\":\"172.20.3.2\",\"__tag__:__hostname__\":\"logtail-ds-bfvpm\",\"__tag__:__pack_id__\":\"8279D653B09C2253-C9C62\",\"__tag__:_node_ip_\":\"172.26.55.131\",\"__tag__:_node_name_\":\"cn-zhangjiakou.i-8vbf8v6v9kslk2armih8\",\"__time__\":\"1588923002\",\"__topic__\":\"\",\"_container_ip_\":\"172.20.3.42\",\"_container_name_\":\"rabbitmq-mqtt\",\"_image_name_\":\"registry.cn-zhangjiakou.aliyuncs.com/tyche/rabbitmq-mqtt:20200503045041\",\"_namespace_\":\"default\",\"_pod_name_\":\"rabbitmq-mqtt-7c9bc9df8d-stmmr\",\"_pod_uid_\":\"ba6be80e-8cf9-11ea-ba6b-00163e032c1c\",\"_source_\":\"stdout\",\"_time_\":\"2020-05-08T07:30:01.78640303Z\",\"content\":\"2020-05-08 15:30:01.786  INFO 1 --- [0888-thread-200] c.t.r.r.r.RabbitmqttImpl                 : 组装的报文数据:[TK*10600101719051500343*20200508153001*0000*UNLC*0000]\"}\n";
//        getUnlcData(str1);

        String str2 = "{\"__source__\":\"172.20.2.130\",\"__tag__:__hostname__\":\"logtail-ds-vr7dq\",\"__tag__:__pack_id__\":\"25E3204B911A1CD1-139567\",\"__tag__:_node_ip_\":\"172.26.55.130\",\"__tag__:_node_name_\":\"cn-zhangjiakou.i-8vbib37rf0nqnx2mcpla\",\"__time__\":\"1588922638\",\"__topic__\":\"\",\"_container_ip_\":\"172.20.2.234\",\"_container_name_\":\"rabbitmq-mqtt\",\"_image_name_\":\"registry.cn-zhangjiakou.aliyuncs.com/tyche/rabbitmq-mqtt:20200503045041\",\"_namespace_\":\"default\",\"_pod_name_\":\"rabbitmq-mqtt-7c9bc9df8d-nbmj7\",\"_pod_uid_\":\"f2328bc6-8cf9-11ea-ba6b-00163e032c1c\",\"_source_\":\"stdout\",\"_time_\":\"2020-05-08T07:23:58.602967628Z\",\"content\":\"2020-05-08 15:23:58.601  INFO 1 --- [Call: mqtt_7fc2] c.t.r.r.m.MqttHandler                    : 原始Link数据:{teaKey=87837D3229D8E02A, numId=1092, bytes=[B@49f3bfd1, vendor=TK, instruction=LINK, topic=/TK/IC01/device/10600101719051500257, message=100,0, deviceId=10600101719051500257, timestamp=20200508152357, status=true},当前时间点位:2020-05-08 15:23:58\"}";
//        getlinkData(str2);

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println(list.subList(1, 4));
//        System.out.println(list.toString());


//        calc();


        String str = "2020/05/10-17:12 [DubboServerHandler-172.26.55.109:20889-thread-200] INFO  com.tyche.rabbitmq.rabbitmqamq.rpc.RabbitamqServiceImpl- 开始写入amq,交换机名字为:topicExchange,主题为:TK.IC01,发送的消息为:{\"lockStatus\":0,\"lockNum\":\"10600101720031500541\",\"signal\":100}\n";
//        newReadAmqLogFun(str);




        String strx = "2020-05-12 07:01:37.811  INFO 16232 --- [MQTT Call: mqtt_localhost1238e8b] c.t.r.r.m.MqttHandler                    : 原始Link数据:{teaKey=BBC71976A9C36B0E, numId=0275, bytes=[B@20f21e00, vendor=TK, instruction=LINK, topic=/TK/IC01/device/10600101719121600430, message=100,0, deviceId=10600101719121600430, timestamp=20200512070135, status=true},当前时间点位:2020-05-12 07:01:37";
//        anlyStrx(strx);

        String unlc = "2020-05-12 14:43:50.679  INFO 29311 --- [DubboServerHandler-172.26.55.116:20888-thread-2] c.t.r.r.r.RabbitmqttImpl                 : 组装的报文数据:[TK*10600101719121600198*20200512144350*0000*UNLC*0000]\n";
        stringToUnlc2(unlc);
    }


    /**
     * 解析json封装成 unlc对象
     * @param str
     * @return
     * @throws ParseException
     */
    public void stringToUnlc2(String str) throws ParseException{

        int i2 = str.indexOf("组装的报文数据:");
        String substring = str.substring(i2 + 8);
        String[] split = substring.split("\\*");

        String time = split[2];

        //时间戳
        SimpleDateFormat  sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat  sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parseTime = sdf2.parse(time);
        System.out.println(sdf1.format(parseTime));

        //lock_num
        String lock_num = split[1];
        System.out.println(lock_num);
    }




    @org.junit.Test
    public void test2() throws FileNotFoundException {
        System.out.println(txt2List("C:\\Users\\99686\\Desktop\\11.txt").toString());
    }



    /**
     *
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public List txt2List(String filePath) throws FileNotFoundException {
        List<Test> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));//构造一个BufferedReader类来读取文件
            String s = null;
            String nextLine = null;
            while(true){
                String trim = null;
                if(nextLine != null && nextLine.contains("IP")){
                    trim = nextLine;
                } else {
                    if((s = br.readLine())!=null){
                        trim = s.trim();
                    } else {
                        break;
                    }
                }

                String firstLine;
                if(trim.contains("IP")){
                    firstLine = trim;

                    String ss = null;
                    List<String> subStrList = new ArrayList<>();
                    while(true){
                        if((ss = br.readLine())!=null){
                            String trim1 = ss.trim();
                            if(trim1.startsWith("0x00")){
                                subStrList.add(trim1);
                            } else {
                                nextLine = trim1;
                                break;
                            }
                        } else {
                            nextLine = null;
                            break;
                        }
                    }

                    if(subStrList.size() < 6){
                        continue;
                    }

                    Test test = new Test();
                    String lockNum = getLockNum(subStrList);
                    test.setLockNum(lockNum);
                    getIP(firstLine, test);

                    list.add(test);
                }


            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void getIP(String str, Test test){
        int ip = str.indexOf("IP");
        int flags = str.indexOf("Flags");
        String substring = str.substring(ip + 2, flags);
        String[] split = substring.split(">");
        String from = split[0].trim();
        int i1 = from.lastIndexOf(".");
        String to = split[1].trim();
        int i2 = to.lastIndexOf(".");

        test.setFromIP(from.substring(0,i1));
        test.setToIP(to.substring(0,i2));
    }

    public String getLockNum(List<String> list){
        String s4 = list.get(4);
        String s5 = list.get(5);

        String splitStr = "/[*";
        if(s4.contains("device")){
            splitStr = "[*";
        }

        String[] split4 = s4.split(" ");
        String[] split5 = s5.split(" ");
        String s = split4[split4.length - 1] + split5[split5.length - 1];

        int i1 = s.lastIndexOf("/");
        int i2 = s.indexOf(splitStr);

        return s.substring(i1 + 1, i2);
    }

class Test{
        private String lockNum;
        private String fromIP;
        private String toIP;

    public String getLockNum() {
        return lockNum;
    }

    public void setLockNum(String lockNum) {
        this.lockNum = lockNum;
    }

    public String getFromIP() {
        return fromIP;
    }

    public void setFromIP(String fromIP) {
        this.fromIP = fromIP;
    }

    public String getToIP() {
        return toIP;
    }

    public void setToIP(String toIP) {
        this.toIP = toIP;
    }

    @Override
    public String toString() {
        return "Test{" +
                "lockNum='" + lockNum + '\'' +
                ", fromIP='" + fromIP + '\'' +
                ", toIP='" + toIP + '\'' +
                '}';
    }
}







    public void anlyStrx(String str){
        String[] strArr = str.split(" ");


        String s1 = strArr[30];
        int i1 = s1.indexOf("原始Link数据:");
        int i2 = s1.indexOf(",");
        String teaKey = s1.substring(i1 + 17, i2);
        System.out.println("teaKey:" +teaKey);

        String s2 = strArr[35];
        int i3 = s2.indexOf("topic");
        int i4 = s2.indexOf(",");
        String topic = s2.substring(i3 + 6, i4);
        System.out.println("topic:" +topic);

        String s3 = strArr[36];
        int i5 = s3.indexOf("message");
        int i6 = s3.lastIndexOf(",");
        String message = s3.substring(i5 + 8, i6);
        String[] split = message.split(",");
        String signal_intensity = split[0];
        String lock_status = split[1];
        System.out.println("signal_intensity:" +signal_intensity);
        System.out.println("lock_status:" +lock_status);

        String s4 = strArr[37];
        int i7 = s4.indexOf("deviceId");
        int i8 = s4.indexOf(",");
        String lockNum = s4.substring(i7 + 9, i8);
        System.out.println("lockNum:" +lockNum);

        String s5 = strArr[39];
        int i9 = s5.indexOf("status");
        int i10 = s5.indexOf("}");
        String status = s5.substring(i9 + 7, i10);
        System.out.println("status:" +status);

        int i = str.indexOf("当前时间点位:");
        String time = str.substring(i + 7);
        System.out.println(time);

    }


    public void newReadAmqLogFun(String str) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] s = str.split(" ");
        String format = sdf2.format(sdf1.parse(s[0]));
        System.out.println(format);

        int i = str.indexOf("发送的消息为:");
        String parStr = str.substring(i + 7);
        JSONObject jsonObject = JSONObject.parseObject(parStr);
        String lockStatus = jsonObject.getString("lockStatus");
        System.out.println(lockStatus);
        String lockNum = jsonObject.getString("lockNum");
        System.out.println(lockNum);
        String signal = jsonObject.getString("signal");
        System.out.println(signal);
    }



    public void calc(){
        int diliverNum=3;//举例子的变量
        int queryMailNum=9;//举例子的变量
// 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
// 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)diliverNum/(float)queryMailNum*100);
        System.out.println("diliverNum和queryMailNum的百分比为:" + result + "%");
    }


    /**
     * 获取json中的指定数据
     */
    public void getUnlcData(String str) throws ParseException {
        JSONObject jsonObject = JSONObject.parseObject(str);
        String contentStr = jsonObject.getString("content");
        String[] s = contentStr.split(" ");

        //时间戳
        String time = s[0] + " " + s[1];
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date parse = sdf.parse(time);
        System.out.println(parse.toString());


        String lastPart = s[s.length - 1];
        int i1 = lastPart.indexOf("TK*");
        String substring = lastPart.substring(i1 + 3, i1 + 23);
        System.out.println(substring);
    }


    /**
     * 获取json中的指定数据
     */
    public void getlinkData(String str) throws ParseException {
        JSONObject jsonObject = JSONObject.parseObject(str);
        String contentStr = jsonObject.getString("content");
        String[] strArr = contentStr.split(" ");

//        for (int i = 0; i < s.length; i++) {
//            System.out.println(i + ":" + s[i]);
//        }

        //时间戳
        String time = strArr[0] + " " + strArr[1];
        SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date parse = sdf.parse(time);
        System.out.println(parse.toString());

        //teaKey
        int i1 = strArr[29].indexOf("=");
        int i2 = strArr[29].indexOf(",");
        String teaKey = strArr[29].substring(i1 + 1, i2);
        System.out.println(teaKey);

        //topic
        int i3 = strArr[34].indexOf("=");
        int i4 = strArr[34].indexOf(",");
        String topic = strArr[34].substring(i3 + 1, i4);
        System.out.println(topic);

        //信号强度signal_intensity和锁状态lock_status
        int i5 = strArr[35].indexOf("=");
        int i6 = strArr[35].indexOf(",");
        String signal_intensity = strArr[35].substring(i5 + 1, i6);
        String lock_status = strArr[35].substring(i6 + 1, i6 + 2);
        System.out.println(signal_intensity);
        System.out.println(lock_status);

        //lock_num
        int i7 = strArr[36].indexOf("=");
        int i8 = strArr[36].indexOf(",");
        String lock_num = strArr[36].substring(i7 + 1, i8);
        System.out.println(lock_num);

        //status
        int i9 = strArr[38].indexOf("=");
        int i10 = strArr[38].indexOf("}");
        String status = strArr[38].substring(i9 + 1, i10);
        int statusInt = 0;
        if("true".equalsIgnoreCase(status)){
            statusInt = 1;
        }
        System.out.println(statusInt);

    }

}
