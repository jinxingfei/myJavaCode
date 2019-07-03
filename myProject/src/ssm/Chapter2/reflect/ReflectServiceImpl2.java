package ssm.Chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name){
        this.name = name;

    }
    public void sayHello(String name){
        System.err.println("hello" + name);

    }
//  带参的反射构造
    public  ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;

        try {
            object = (ReflectServiceImpl2) Class.forName("ssm.Chapter2.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("晋兴飞");
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException| NoSuchMethodException | SecurityException
                                        | IllegalArgumentException | InvocationTargetException ex){
            ex.printStackTrace();
        }
        return object;
    }

}
