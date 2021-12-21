package designpattern.structure.facade;

/**
 * @Author li zhiqang
 * @create 2021/12/8
 */
public class Facade {

    private SubSystem1 subSystem1;
    private SubSystem2 subSystem2;
    private SubSystem3 subSystem3;

    public Facade() {
        this.subSystem1 = new SubSystem1();
        this.subSystem2 = new SubSystem2();
        this.subSystem3 = new SubSystem3();
    }

    public void work1(){
        subSystem1.work();
    }
    public void work2(){
        subSystem2.work();
    }
    public void work3(){
        subSystem3.work();
    }


}
