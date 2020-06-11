package github_java.others.diyioc;

import org.junit.Test;

/**
 * @author Rex
 * @title: SimpleIOCTest
 * @projectName demoNote
 * @description: TODO
 * @date 2020/2/1418:57
 */
public class SimpleIOCTest {
    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("spring-test.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car.getName());
    }
}
