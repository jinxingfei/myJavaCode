package ssm.Chapter2.proxy;
import ssm.Chapter2.reflect.ReflectServiceImpl;
public class ProxyTest {
    public static void main(String[] args) {
		//testJdkProxy();
        tesCGLIBProxy();
    }

    public static void testJdkProxy() {

        JdkProxyExample jdk = new JdkProxyExample();

        // 绑定关系，因为挂在接口HelloWorld下，所以声明代理对象HelloWorld proxy
        // new HelloWorldImpl() 才是真正的对象
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        // 注意，此时HelloWorld  对象 proxy 已经是一个代理对象，它会进入代理的逻辑方法invoke里，而不是直接去调用sayHelloWorld
        proxy.sayHelloWorld();
        proxy.showInfo(1);
    }

    public static void tesCGLIBProxy() {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl)cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }
}
