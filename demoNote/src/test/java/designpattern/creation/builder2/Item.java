package designpattern.creation.builder2;

/**
 * 【建造者模式】
 * 解决创建一些复杂对象时，元素固定，组合变化的场景
 *
 * @author Cytang
 * @title: Item
 * @projectName demoNote
 * @description: TODO
 * @date 2020/7/109:17
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
