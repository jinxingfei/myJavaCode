package ssm.Chapter10.annotation.service.impl;

import org.springframework.stereotype.Component;
import ssm.Chapter10.annotation.pojo.Role;
import ssm.Chapter10.annotation.service.RoleService;

// 使用 component 表明这是一个 Spring 所需要的 Bean
@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRoleInfo(Role role){
        System.out.println("-----impl  这里是 component------");
        System.out.println("id= "+role.getId());
        System.out.println("roleName ="+ role.getRoleName());
        System.out.println("note = " + role.getNote());

    }
}
