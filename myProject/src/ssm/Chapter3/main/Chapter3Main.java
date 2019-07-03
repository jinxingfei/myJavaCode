package ssm.Chapter3.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.data.repository.query.Param;
import  ssm.Chapter3.mapper.RoleMapper;
import  ssm.Chapter3.pojo.Role;
import ssm.Chapter3.pojo.RoleParams;
import  ssm.Chapter3.utils.SqlSessionFactoryUtils;

import java.util.HashMap;
import java.util.Map;

public class Chapter3Main {

    public static void main(String []args){
        Logger log = Logger.getLogger(Chapter3Main.class);
        SqlSession sqlSession = null;

        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
            log.info("再次调用 getRole");
            Role rolee = roleMapper.getRole(1L);
            log.info("--------一级缓存 只调用一次------------");
            // 传递多个参数 时 用 map对象
//                Map<String, Object> parameterMap = new HashMap<String, Object>();
//                parameterMap.put("roleName", "1");
//                parameterMap.put("note", "1");
//                Role role2 = roleMapper.getRoleByMap(parameterMap);
//                log.info(role2.getRoleName());

//            Role role3 = roleMapper.getRoleByAnnotation("1", "1");  //
//            log.info("多条件注解查询   "+role3.getRoleName());
//
//            // 使用 javaBean
//            RoleParams roleParams = new RoleParams();
//            roleParams.setRoleName("xing");
//            roleParams.setNote("c");
//            Role role4 = roleMapper.getRoleByBean(roleParams);
//            log.info("多条件Bean查询   "+role4.getRoleName());

            //sqlSession.commit();
        }finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }

    }
}
