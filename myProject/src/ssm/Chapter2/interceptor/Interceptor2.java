package ssm.Chapter2.interceptor;

import java.lang.reflect.Method;

public class Interceptor2 implements Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object []args){
        System.out.println("拦截器 2 before 返回 true");
        return true;
    }
    // 真实对象前调用  返回true时，反射真实对象的方法；  返回false时，调用around方法

    public void around(Object proxy, Object target, Method method, Object []args){

    }
    public void after(Object proxy, Object target, Method method, Object []args){
        System.out.println("拦截器 2 after 方法 ");
    }
}
