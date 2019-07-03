package ssm.Chapter2.interceptor;
import java.lang.reflect.Method;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{
    @Override
    public boolean before(Object proxy, Object target, Method method, Object []args){
        System.err.println("反射方法前逻辑");
        return false;
    }
    // 真实对象前调用  返回true时，反射真实对象的方法；  返回false时，调用around方法
    @Override
    public void around(Object proxy, Object target, Method method, Object []args){
        System.err.println("取代被代理对象的方法");
    }
    @Override
    public void after(Object proxy, Object target, Method method, Object []args){
        System.err.println("反射方法后逻辑");
    }

}
