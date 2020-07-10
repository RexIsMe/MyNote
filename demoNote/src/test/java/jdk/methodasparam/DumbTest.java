package jdk.methodasparam;

import org.springframework.core.MethodParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Cytang
 * @title: DumbTets
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/211:40
 */
public class DumbTest {
    public class Stuff {
        public String getA() {
            return "a";
        }
        public String getB() {
            return "b";
        }
    }

    public String methodToPassA(Stuff stuff) {
        return stuff.getA();
    }

    public String methodToPassB(Stuff stuff) {
        return stuff.getB();
    }

    //MethodParameter is purely used to be comprehensive,nothing else...
//    public void operateListWith(List<Stuff> listStuff, MethodParameter method) {
//        for (Stuff stuff : listStuff) {
//            method(stuff);
//            System.out.println();
//        }
//    }

    public DumbTest() {
        List<Stuff> listStuff = new ArrayList<>();
        listStuff.add(new Stuff());
        listStuff.add(new Stuff());

//        operateListWith(listStuff,methodToPassB);
        operateListWith(listStuff,this::methodToPassA);
        operateListWith(listStuff,Stuff::getB);
    }

    public static void main(String[] args) {
        DumbTest l = new DumbTest();

    }


    public void operateListWith(List<Stuff> listStuff, Function<Stuff,String> method) {
        for (Stuff stuff : listStuff) {
            System.out.println(method.apply(stuff));
        }
    }

}
