//package com.example.demo.utils.akka;
//
//import akka.actor.AbstractActor;
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import akka.actor.Props;
//import com.alibaba.fastjson.JSON;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * akka的简单使用示例
// *
// * @Author li zhiqang
// * @create 2021/5/31
// */
//public class SendActor extends AbstractActor {
//    @Override
//    public Receive createReceive() {
//        return receiveBuilder()
//                //匹配字符串类型消息
//                .match(String.class, msg -> {
//                    System.out.println("==================str==============" + msg);
//                //匹配任意消息类型
//                }).matchAny(msg -> {
//                    System.out.println("==================any==============" + msg);
//                }).build();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        ActorSystem actorSystem = ActorSystem.create();
//        ActorRef sender = actorSystem.actorOf(Props.create(SendActor.class), "sender");
//        sender.tell("fighting!!! rex", sender);
//        Thread.sleep(1000L);
//        Map map = new HashMap<String, String>();
//        map.put("加油", "rex");
//        sender.tell(JSON.toJSON(map), sender);
//        actorSystem.terminate();
//    }
//}
