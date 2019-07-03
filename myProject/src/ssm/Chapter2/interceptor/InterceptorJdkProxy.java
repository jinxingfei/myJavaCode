package ssm.Chapter2.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;


public class InterceptorJdkProxy implements InvocationHandler {

    // 类比于 jdkproxyexample
    private Object target; //真实对象
    private String interceptorClass = null;   //拦截器全限定名

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个【代理占位】
     *
     * @return 代理对象【占位】
     * @param----target 真实对象
     */

    public static Object bind(Object target, String interceptorClass) {
        InterceptorJdkProxy object_this = new InterceptorJdkProxy(target, interceptorClass);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                object_this);
    }

    @Override
    /**
     * 通过代理对象调用方法，首先进入这个方法.
     *
     * @param proxy --代理对象
     * @param method --方法，被调用方法
     * @param args -- 方法的参数
     */
    public Object invoke(Object proxy, Method method, Object [] args) throws Throwable{
        if (interceptorClass == null){
            // 没有设置拦截器 直接反射原有方法
            return method.invoke(target, args);

        }

        Object result = null;
        // 反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        // 调用before
        if (interceptor.before(proxy, target, method, args)){
            // 反射原有方法   这个 before 返回的是false
            result = method.invoke(target,args);
        }else{
            // 返回false执行 around方法
            interceptor.around(proxy,target,method,args);
        }
        // 调用后置方法
        interceptor.after(proxy, target, method, args);
        return result;














    }



}
