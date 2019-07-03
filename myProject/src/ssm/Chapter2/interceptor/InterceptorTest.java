package ssm.Chapter2.interceptor;

import ssm.Chapter2.proxy.HelloWorld;
import ssm.Chapter2.proxy.HelloWorldImpl;

public class InterceptorTest {

    public static void main(String[] args){

       testInterceptor();
       //testInterceptors();  // 责任链

    }
    public static void testInterceptors(){
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "ssm.Chapter2.interceptor.Interceptor1");
         //  第一个参数 替换成了 proxy1
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,"ssm.Chapter2.interceptor.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,"ssm.Chapter2.interceptor.Interceptor3");

        proxy3.sayHelloWorld();
    }
    public static void testInterceptor() {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "ssm.Chapter2.interceptor.MyInterceptor");
        proxy.sayHelloWorld();
        //proxy.showInfo(100);
    }
}
