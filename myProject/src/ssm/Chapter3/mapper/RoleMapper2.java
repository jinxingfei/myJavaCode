package ssm.Chapter3.mapper;

import org.apache.ibatis.annotations.Select;
import ssm.Chapter3.pojo.Role;

public interface RoleMapper2 {
    @Select("select id, role_name as roleName, note from t_role where id=#{id}")
    public Role getRole(Long id);
}
