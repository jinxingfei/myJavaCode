package ssm.Chapter10.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssm.Chapter10.annotation.pojo.Role;
import ssm.Chapter10.annotation.service.RoleService2;

@Component("RoleService2")  // 起名


// 自动配置
public class RoleServiceImpl2 implements RoleService2{

    @Autowired
    private Role role = null;

    public Role getRole() {
        return role;
    }

    @Autowired
    public void setRole(Role role){
        this.role = role;
    }

    @Override
    public void printRoleInfo(){
        System.out.println("-----impl2 这里是 @Autowired------");
        System.out.println("id= "+role.getId());
        System.out.println("roleName ="+ role.getRoleName());
        System.out.println("note = " + role.getNote());
    }



}
