package com.example.demo.module.nlp;

import edu.stanford.nlp.simple.*;

import java.util.List;

/**
 * @Author li zhiqang
 * @create 2022/3/23
 */
public class SimpleAPITest {

    public static void main(String[] args){
//        Sentence sent = new Sentence("Lucy is in the sky with diamonds.");
        Sentence sent = new Sentence("我也很开心.");
        List<String> nerTags = sent.nerTags();  // [PERSON, O, O, O, O, O, O, O]
        for (int i = 0; i < nerTags.size(); i++) {
            System.out.println(nerTags.get(i));
        }
        String firstPOSTag = sent.posTag(0);   // NNP
        System.out.println(firstPOSTag);
    }


}
