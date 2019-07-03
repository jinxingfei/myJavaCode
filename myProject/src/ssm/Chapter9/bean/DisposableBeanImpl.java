package ssm.Chapter9.bean;

import org.springframework.beans.factory.DisposableBean;


public class DisposableBeanImpl implements DisposableBean {

    // 用于 Spring Ioc 容器销毁
    @Override
    public void destroy() throws Exception{
        System.out.println("调用接口的 DisposableBean 的 destory 方法");
    }
}
