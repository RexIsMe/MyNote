package designpattern.behavior.moment;

import lombok.Data;

/**
 * 发起者（需要保存部分属性的对象）
 *
 * @Author li zhiqang
 * @create 2021/12/9
 */
@Data
public class Orignitor {

    private String gender;
    private String name;
    private Integer age;
    private Double height;

    public Moment momentCurrent(){
        return new Moment(gender, name, age);
    }

    public void setMoment(Moment moment){
        this.gender = moment.getGender();
        this.name = moment.getName();
        this.age = moment.getAge();
    }

    @Override
    public String toString() {
        return "Orignitor{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
