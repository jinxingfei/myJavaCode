package ssm.Chapter9.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssm.Chapter9.pojo.JuiceMaker2;
import ssm.Chapter9.pojo.Source;

public class Chapter9Main {

    public static void main(String [] args){

        testIoc();
    }

    public static void testIoc(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ssm/Chapter9/spring-cfg.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
//        Source s = (Source) ctx.getBean("source");
//        s.showInfo();
        System.out.println(juiceMaker2.makeJuice());
        ctx.close();
    }
}
