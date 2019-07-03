package ssm.Chapter10.annotation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//import ssm.Chapter10.annotation.condition.DataSourceCondition;
import ssm.Chapter10.annotation.pojo.Role;
import ssm.Chapter10.annotation.service.impl.RoleServiceImpl;
import ssm.Chapter9.pojo.JuiceMaker2;
import ssm.Chapter9.pojo.Source;


// 指定生成对应的 Bean包  下面这些都可以  包和子包进行扫描装配对应配置的Bean

@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class })


//@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class },
 //       excludeFilters = {@Filter(type = FilterType.REGEX, pattern="com.ssm.chapter10.annotation.config.AutowiredConfig")})

// @ComponentScan(basePackages = {"ssm.Chapter10.annotation.pojo",
// "ssm.Chapter10.annotation.service"})

// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"},
// basePackageClasses = {Role.class, RoleServiceImpl.class})

public class ApplicationConfig {


    @Bean(name="juiceMaker2", initMethod="init", destroyMethod="myDestroy")
    public JuiceMaker2 initJuiceMaker2() {
        JuiceMaker2 juiceMaker2 = new JuiceMaker2();
        juiceMaker2.setBeverageShop("贡茶");
        Source source = new Source();

        source.setFruit("橙子");
        source.setSize("大杯");
        source.setSugar("少糖");
        juiceMaker2.setSource(source);
        return juiceMaker2;
    }
}
