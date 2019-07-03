package ssm.Chapter3.utils;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import ssm.Chapter3.mapper.RoleMapper;
import ssm.Chapter3.mapper.RoleMapper2;
import ssm.Chapter3.pojo.Role;

public class SqlSessionFactoryUtils{

    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    private static SqlSessionFactory SqlSessionFactory = null;

    private SqlSessionFactoryUtils() {

    }
    // 使得其他代码不能 new 它
    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            // 防止多线程中多次实例化SqlSessionFactory
            if (SqlSessionFactory != null){
                return SqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try{
                inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                // 由SqlSessionFactoryBuilder 来创建 SqlSessionFactory

            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
            return SqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession(){
        if (SqlSessionFactory == null){
            getSqlSessionFactory();  // 如果还没有创建 则创建 SqlSessionFactory
        }
        return SqlSessionFactory.openSession();
        //
    }

    //代码生成SqlSessionFactory
    public static SqlSessionFactory getSqlSessionFactory2() {
        synchronized (LOCK) {
            //数据库连接池信息
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver("com.mysql.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setUrl("jdbc:mysql://localhost:3306/chapter3");
            dataSource.setDefaultAutoCommit(false);
            //采用MyBatis的JDBC事务方式
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            //创建Configuration对象
            Configuration configuration = new Configuration(environment);
            //注册一个MyBatis上下文别名
            configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
            //加入一个映射器
            configuration.addMapper(RoleMapper.class);
            configuration.addMapper(RoleMapper2.class);
            //使用SqlSessionFactoryBuilder构建SqlSessionFactory
            SqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
            return SqlSessionFactory;
        }
    }

}
























