package ssm.Chapter3.mapper;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;  // 记得导入 Param
import ssm.Chapter3.pojo.*;

public interface RoleMapper {
    // 接口 + XML(描述以下功能)
    public int insertRole(Role role);
    public int deleteRole(Long id);
    public int updateRole(Role role);
    public Role getRole(Long id);

    public Role getRoleByMap(Map<String, Object> parameterMap);
    // 多条件查询  第二种方法 使用注解
    public Role getRoleByAnnotation(@Param("roleName") String roleName, @Param("note") String note);
    public Role getRoleByBean(RoleParams roleParam);

    public List<Role> findRoles(String roleName);
}
