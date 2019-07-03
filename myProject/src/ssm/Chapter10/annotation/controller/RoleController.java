package ssm.Chapter10.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ssm.Chapter10.annotation.pojo.Role;
import ssm.Chapter10.annotation.service.RoleService;

@Component
public class RoleController {

    @Autowired
    @Qualifier("roleService3")  // 和 roleServiceImpl3 的 component（）名字一致
    private RoleService roleService = null;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleService getRoleService() {
        return roleService;
    }
    // roleService 是一个RoleService 接口类型

    public void printRole(Role role){
        System.out.println("--- 这里是 RoleController ---");
        roleService.printRoleInfo(role);
    }
}
