package ssm.Chapter2.observe;

import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {
    @Override
    public void update(Observable o, Object product){
        String newProduct = (String) product;
        System.err.println("observer2 更新了新产品"+newProduct);
    }
}