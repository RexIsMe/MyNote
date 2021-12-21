package designpattern.behavior.observer.entrust;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * java中实现“委托”
 * 委托实现基础类
 *
 * @Author li zhiqang
 * @create 2021/12/3
 */
@Data
public class Event {
    //要执行方法对象
    private Object object;
    //要执行的方法名
    private String methodName;
    //参数数组
    private Object[] params;
    //参数的参数类型
    private Class[] paramTypes;

    //根据传入参数获取参数类型
    private void contractParamTypes(Object[] params){
        this.paramTypes = new Class[params.length];
        for(int i = 0; i < params.length; i++){
            this.paramTypes[i] = params[i].getClass();
        }
    }

    public Event(Object object, String methodName, Object... args){
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        contractParamTypes(this.params);
    }

    //利用java反射机制调用指定方法
    public void invoke() throws Exception{
        Method method = this.object.getClass().getMethod(this.methodName, this.paramTypes);
        if(method == null){
            return;
        }
        System.out.println("调用类" + object.getClass().getName() + "的方法" + methodName);
        method.invoke(this.getObject(), this.getParams());
    }
}

