package designpattern.structure.proxy;

/**
 * @Author li zhiqang
 * @create 2021/1/22
 */
public class StudentService implements IStudentService {
    public void insertStudent(){
        System.out.println("新增学生...");
    }

    public void deleteStudent(){
        System.out.println("删除学生...");
    }
}
