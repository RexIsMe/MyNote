package jdk.reactor;

import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.UnicastProcessor;

/**
 * @author Rex
 * @title: Common
 * @projectName demoNote
 * @description: TODO
 * @date 2020/5/2114:28
 */
public class Common {


    public static void main(String[] args) {

        FluxProcessor<Integer, Integer> publisher = UnicastProcessor.create();
        publisher.doOnNext(event -> System.out.println("receive event: " + event)).subscribe();

        publisher.onNext(1); // print 'receive event: 1'
        publisher.onNext(2);

    }


}
