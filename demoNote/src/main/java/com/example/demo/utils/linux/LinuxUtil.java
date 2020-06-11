package com.example.demo.utils.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.example.demo.utils.file.FileUtil;

/**
 * @author Rex
 * @title: LinuxUtil
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/1316:26
 */
public class LinuxUtil {


    public static void main(String[] args) throws IOException {

        String[] sshInfo = new String[]{"47.92.135.203","root","FeTest@#Tyche.com1!"};
        String date = "2020_0513_1535";
//        String[] commands = new String[]{"cd /usr/local/rabbitmq/var/log/rabbitmq;  tcpdump -nn -X -i eth0 -r " + date + "*.pc            ap"};
        String[] commands = new String[]{
                "cd /usr/local/rabbitmq3.7/var/log/rabbitmq/tcp; tcpdump -nn -X -i eth0 -r 2020_0519_0804_17.pcap",
                "cd /usr/local/rabbitmq3.7/var/log/rabbitmq/tcp; tcpdump -nn -X -i eth0 -r 2020_0519_0904_17.pcap"
        };

        exeCommand(sshInfo, commands);


//        getFile(getConnect(sshInfo), "/usr/local/rabbitmq/var/log/rabbitmq/2020_0513_1535_19.pcap",
//                "C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\qcap\\");




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
    public static boolean exeCommand(String[] sshInfo,String[] commands){

        Session sess = null;
        Connection conn = null;
        boolean result=false;
        try {
            conn = getConnect(sshInfo);

            for (int i = 0; i < commands.length; i++) {
                System.out.println("开始执行第【" + i + "】个命令：" + commands[i]);
                sess = conn.openSession();
                sess.execCommand(commands[i]);
                result = getResult(sess);
//                if (!result) {
//                    return false;
//                }
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
    private static boolean getResult(Session sess) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        BufferedReader stderrReader = null;
        BufferedReader stdoutReader = null;
        try {
            InputStream stdout = new StreamGobbler(sess.getStdout());
            InputStream stderr = new StreamGobbler(sess.getStderr());
            stdoutReader = new BufferedReader(new InputStreamReader(stdout, "UTF-8"));
            stderrReader = new BufferedReader(new InputStreamReader(stderr, "UTF-8"));
            char[] arr = new char[1024 * 1024];//1M
            int read;
            StringBuilder outmsg = new StringBuilder();
            int count = 0;
            while (true) {
                count++;
                if (count % 100 == 0) {
                    System.out.println(new Date() + "读取进度：" + count);
                }

                read = stdoutReader.read(arr, 0, arr.length);
                if (read < 0) {
                    break;
                }
                outmsg.append(new String(arr, 0, read));


                String fileName = "data" + sdf.format(new Date()) + ".txt";
                if(count % 15000 == 0){
                    FileUtil.writeTxt("C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\data_log\\0519\\" + fileName, outmsg.toString());
                    System.out.println("导出文件：" + fileName);
                    outmsg.delete(0, outmsg.length());
                }

            }

            String fileName = "data" + sdf.format(new Date()) + ".txt";
            FileUtil.writeTxt("C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\data_log\\0519\\" + fileName, outmsg.toString());
            System.out.println("导出文件：" + fileName);
            outmsg.delete(0, outmsg.length());


            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                read = stderrReader.read(arr, 0, arr.length);
                if (read < 0) {
                    break;
                }
                stringBuilder.append(new String(arr, 0, read));
            }
            System.err.println("错误信息：" + stringBuilder);
            if (stringBuilder.length() > 0) {
                return false;
            } else {
                return true;
            }



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

}
