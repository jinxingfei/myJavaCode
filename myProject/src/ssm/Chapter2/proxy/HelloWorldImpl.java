package ssm.Chapter2.proxy;

// 实现接口
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld(){
        System.out.println("哈哈哈哈哈");
    }
    @Override
    public void showInfo(int a){
        System.out.println("showinfo 方法"+a);
    }
}
