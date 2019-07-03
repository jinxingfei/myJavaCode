package ssm.Chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectTest {
    public static void main(String []args){
        //ReflectServiceImpl r = getInstance();
        Object o1 = reflect();
//        Object o = reflectMethod(); // 调用它和调用 方法对象 method一样
//        Object o2 = getInstance();
//        ((ReflectServiceImpl) o2).sayHello("jjj");
    }

    // 反射配置信息构建对象
    public static ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;

        try {
            object = (ReflectServiceImpl) Class.forName("ssm.Chapter2.reflect.ReflectServiceImpl").newInstance();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();
        }
        return object;
    }
    //  获取方法对象
    public static Object reflectMethod(){
        Object returnobj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();

        try{
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            //Method method = Class.forName("ReflectServiceImpl").getMethod("sayHello",String.class);
            //returnobj = method.invoke("jjxxff");
            returnobj = method.invoke(target, "jjxxff");
        }catch (NoSuchMethodException | SecurityException
                |  IllegalAccessException
                | IllegalArgumentException | InvocationTargetException ex){
            ex.printStackTrace();
        }
        return returnobj;
    }
    // 反射生成对象和反射调度方法
    public static Object reflect(){
        ReflectServiceImpl object = null;

        try{
            // object 获取方法
            object = (ReflectServiceImpl) Class.forName("ssm.Chapter2.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class); //int.class
            ((Method) method).invoke(object, "jxf");
        }catch ( NoSuchMethodException | SecurityException
                |ClassNotFoundException |  IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                | InstantiationException ex){
            ex.printStackTrace();
        }
        return object;
    }
}
