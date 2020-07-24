package com.example.demo.module.getvideocover.javacv;


import org.apache.commons.lang3.StringUtils;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cytang
 * @title: VideoUtil
 * @projectName demoNote
 * @description: 获取视频的详细信息和封面
 * @date 2020/7/229:51
 */
public class VideoUtil {


    /**
     * 获取视频封面图
     * @param filePath 视频地址
     * @param mod 开始帧数
     * @return map
     * @throws Exception
     */
    public static Map<String, Object> getScreenshot(String filePath,int mod) throws Exception{
        filePath = filePath.replaceAll("\\\\","/");
        System.out.println("截取视频截图开始："+ System.currentTimeMillis());
        Map<String, Object> result = new HashMap<>();
        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(filePath);

        // 第一帧图片存储位置
        String targerFilePath = filePath.substring(0, filePath.lastIndexOf("/"));
        // 视频文件名
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        // 图片名称
        String targetFileName = fileName.substring(0, fileName.lastIndexOf("."));


        grabber.start();
        //设置视频截取帧（建议从5帧开始，防止全是黑屏）
        Frame frame = null;
        for (int j = 0; j < mod; j++) {
            frame =  grabber.grabImage();
        }
        //视频旋转度
        String rotate = grabber.getVideoMetadata("rotate");
        Java2DFrameConverter converter = new Java2DFrameConverter();
        //绘制图片
        BufferedImage bi = converter.getBufferedImage(frame);
        if (rotate != null) {
            // 旋转图片
            bi = rotate(bi, Integer.parseInt(rotate));
        }
        //图片的类型
        String imageMat = "jpg";
        //图片的完整路径
//        String imagePath = targerFilePath + File.separator + targetFileName + "." + imageMat;
        String imagePath = "C:\\Users\\Cytang\\Desktop\\" + targetFileName + "." + imageMat;
        //创建文件
        File output = new File(imagePath);
        ImageIO.write(bi, imageMat, output);

        //拼接Map信息
        result.put("videoWide", bi.getWidth());
        result.put("videoHigh", bi.getHeight());
        long duration = grabber.getLengthInTime() / (1000 * 1000);
        result.put("rotate", StringUtils.isEmpty(rotate)? "0" : rotate);
        result.put("format", grabber.getFormat());
        result.put("imgPath", output.getPath());
        System.out.println("视频的宽:" + bi.getWidth());
        System.out.println("视频的高:" + bi.getHeight());
        System.out.println("视频的旋转度：" + rotate);
        System.out.println("视频的格式：" + grabber.getFormat());
        System.out.println("此视频时长（s/秒）：" + duration);
        grabber.stop();
        System.out.println("截取视频截图结束："+ System.currentTimeMillis());
        return result;
    }


    /**
     * @Description: 根据视频旋转度来调整图片
     * @param src
     * @param angel 视频旋转度
     * @return  BufferedImage
     */
    public static BufferedImage rotate(BufferedImage src, int angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        int type = src.getColorModel().getTransparency();
        Rectangle rect_des = calcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angel);
        BufferedImage bi = new BufferedImage(rect_des.width, rect_des.height, type);
        Graphics2D g2 = bi.createGraphics();
        g2.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);
        g2.drawImage(src, 0, 0, null);
        g2.dispose();
        return bi;
    }


    /**
     * @Description: 计算图片旋转大小
     * @param src
     * @param angel
     * @return  Rectangle
     */
    public static Rectangle calcRotatedSize(Rectangle src, int angel) {
        if (angel >= 90) {
            if (angel / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);
        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new java.awt.Rectangle(new Dimension(des_width, des_height));
    }



    public static void main(String[] args) throws IOException {
        String clientTime ="2020-02-20",startTime="2020-04-03 00:00:00";
        System.out.println(clientTime.length());
        System.out.println(startTime.length());
   /*int s1= DateUtil.compareTo(clientTime,startTime,DateUtil.NORM_DATETIME_PATTERN);
    System.out.println(s1);*/

        String filePath="http://tyche-app-image.oss-cn-zhangjiakou.aliyuncs.com/common/member/2020/07/22/mZglisAm_住院老人预防跌倒坠床健康宣教.mp4";

        try {
            Map<String, Object> map = VideoUtil.getScreenshot(filePath,25);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
