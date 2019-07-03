package ssm.Chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

public class JdkProxyExample implements InvocationHandler {

    // invoke 方法 提供接口数组用于下挂代理对象、

    private Object target = null;

    // 建立代理关系 target是真实对象 return 代理对象
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        // 3个参数    类加载器  生成的动态代理对象挂在哪些接口下  实现方法逻辑的代理类 此处是当前对象
    }

    // 代理方法逻辑
    /**
     * 代理方法逻辑
     * @param proxy    --代理对象 bind 生成的对象
     * @param method   --当前调度方法
     * @param args --当前方法参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable{

        System.out.println("代理逻辑方法"+ method);
        System.out.println("调度真实对象之前的服务");
        Object obj = method.invoke(target, args);  // sayHelloWorld
        System.out.println("调度真实对象之后的服务");
        return obj;
    }
}
