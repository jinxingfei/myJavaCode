package ssm.Chapter2.interceptor;
import java.lang.reflect.Method;

// 拦截器接口
public interface Interceptor {
/*
* proxy 代理对象
* target 真实对象
* method 方法
* args 方法参数
* */
    public boolean before(Object proxy, Object target, Method method, Object []args);
    // 真实对象前调用  返回true时，反射真实对象的方法；  返回false时，调用around方法

    public void around(Object proxy, Object target, Method method, Object []args);
    public void after(Object proxy, Object target, Method method, Object []args);
}
