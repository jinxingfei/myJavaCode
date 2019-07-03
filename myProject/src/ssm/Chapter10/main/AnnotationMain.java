package ssm.Chapter10.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ssm.Chapter10.annotation.controller.RoleController;
import ssm.Chapter10.annotation.pojo.PojoConfig;
import ssm.Chapter10.annotation.pojo.*; // 导入的 是 annotation 中的pojo

import ssm.Chapter10.annotation.config.ApplicationConfig;
import ssm.Chapter10.annotation.service.RoleService;

/*
* 生成Ioc 容器
* */
public class AnnotationMain {

    public static void main(String [] args){
        //test1();
        test2();

    }

    /*ComponentScan 扫描Bean实例 value */
    public static void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        // AnnotationConfigApplicationContext 初始化 Spring Ioc
        // 上一章是 用的 ClassPathXmlApplicationContext
        Role role = context.getBean(Role.class);
        System.out.println(role.getId());
    }

    /* ApplicationConfig ComponentScan 中的  CompabasePackages 和 basePackageClasses*/
    public static void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role = context.getBean(Role.class);
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo(role);
        context.close();
    }

    public static void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RoleController.class);
        Role role = context.getBean(Role.class);
        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo(role);
        context.close();

    }
}
