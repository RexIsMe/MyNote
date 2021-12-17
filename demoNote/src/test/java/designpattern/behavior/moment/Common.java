package designpattern.behavior.moment;

/**
 * 【备忘录模式】当对象的部分属性需要保存，以备后来可能恢复时使用；这部分保存的状态独立保存，且对象可以设置恢复这部分属性
 *
 *  和原型模式区别，原型模式使用clone()方法copy出完整对象，有些情况下是没有必要的
 *
 * @Author li zhiqang
 * @create 2021/12/9
 */
public class Common {

    public static void main(String[] args){

        //初始状态
        Orignitor orignitor = new Orignitor();
        orignitor.setGender("男");
        orignitor.setName("rex");
        orignitor.setAge(28);
        orignitor.setHeight(177.5);
        System.out.println("初始状态");
        System.out.println(orignitor);

        //备份
        MomentManager momentManager = new MomentManager();
        Moment moment = orignitor.momentCurrent();
        momentManager.add(moment);

        //经历
        change(orignitor);
        System.out.println("时光流逝");
        System.out.println(orignitor);

        //穿越回去
        orignitor.setMoment(momentManager.getMoment());
        System.out.println("回到过去");
        System.out.println(orignitor);

    }

    /**
     * 使对象状态变化的活动
     */
    public static void change(Orignitor orignitor){
        orignitor.setGender("男");
        orignitor.setName("rex");
        orignitor.setAge(32);
        orignitor.setHeight(179.5);
    }

}
