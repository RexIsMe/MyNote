package designpattern.structure.proxy;

/**
 * 静态代理
 * 只针对StudentService的代理
 *
 * @Author li zhiqang
 * @create 2021/1/22
 */
public class StudentServiceProxy implements IStudentService {

    IStudentService studentService;

    public StudentServiceProxy(IStudentService studentService){
        this.studentService = studentService;
    }

    @Override
    public void insertStudent() {
        System.out.println("准备添加学生");
        studentService.insertStudent();
        System.out.println("添加学生成功");
    }

    @Override
    public void deleteStudent() {
        System.out.println("准备删除学生");
        studentService.deleteStudent();
        System.out.println("删除学生成功");
    }
}
