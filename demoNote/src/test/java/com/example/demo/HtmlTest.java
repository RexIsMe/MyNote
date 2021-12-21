package com.example.demo;

import org.springframework.web.util.HtmlUtils;

/**
 * @author Rex
 * @title: HtmlTest
 * @projectName demoNote
 * @description: 网页html转string
 * @date 2020/6/2118:26
 */
public class HtmlTest {

    public static void main(String[] args) {
        String html = "<p><b>1、什么是Vue?</b></p><p>vue真的太好用了，是前后段分离必不可少的开发框架之一……</p><p><br></p><p><i><u>2、Vue能干什么？</u></i></p><p>模拟数据</p><p><br></p>"; // 前端传过来的富文本内容
        String temp = HtmlUtils.htmlEscapeHex(html);
        System.err.println("存数据库=\r\n" + temp);

        String returnHtml = HtmlUtils.htmlUnescape(temp);
        System.out.println("回调===\r\n" + returnHtml);

    }

}
