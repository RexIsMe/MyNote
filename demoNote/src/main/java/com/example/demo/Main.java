package com.example.demo;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] ints = {2,2,3,3,4,4,5,6,6,7,7};

        Arrays.sort(ints);
        LinkedList<Integer> list = new LinkedList<>();
        list.push(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            if(list.size() == 0){
                list.push(ints[i]);
                continue;
            }
            if (list.getFirst() != ints[i]) {
                list.push(ints[i]);
            } else {
                list.removeFirst();
            }
        }

        System.out.println(list.poll());
//        return ints;
    }


}