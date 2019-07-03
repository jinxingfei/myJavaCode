package ssm.Chapter10.annotation.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "role")
// Component 表明这个类会被扫描成Bean 实例
// value 属性代表 Bean 的 id 可以不写
public class Role {
    @Value("1")  // 值的注入
    private Long id;

    @Value("role_name_1")
    private String roleName;

    @Value("role_note_1")
    private  String note;

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
