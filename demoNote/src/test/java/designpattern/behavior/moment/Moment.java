package designpattern.behavior.moment;

import lombok.Data;

/**
 * 包含Originator对象部分属性的对象
 *
 * @Author li zhiqang
 * @create 2021/12/9
 */
@Data
public class Moment {

    private String gender;
    private String name;
    private Integer age;

    public Moment() {
    }

    public Moment(String gender, String name, Integer age) {
        this.gender = gender;
        this.name = name;
        this.age = age;
    }
}
