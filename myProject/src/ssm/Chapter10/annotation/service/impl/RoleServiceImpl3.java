package ssm.Chapter10.annotation.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ssm.Chapter10.annotation.pojo.Role;
import ssm.Chapter10.annotation.service.RoleService;

@Component("roleService3")

@Primary  // 该注解告诉 Ioc 容器 优先注入该实例

public class RoleServiceImpl3 implements RoleService {

    @Override
    public void printRoleInfo(Role role){
        System.out.println("-----Impl3  这里是 @Primary ------");
        System.out.println("id= "+role.getId());
        System.out.println("roleName ="+ role.getRoleName());
        System.out.println("note = " + role.getNote());
    }
}
