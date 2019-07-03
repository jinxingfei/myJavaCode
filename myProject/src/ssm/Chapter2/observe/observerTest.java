package ssm.Chapter2.observe;

public class observerTest {
    public static void main(String []args){
        ProductList observable = ProductList.getInstance();

        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();

        observable.addObserver(o1);  // 注册观察者
        observable.addObserver(o2);  // 是个栈  先注册的 后 更新

        observable.addProduct("华为荣耀");
    }
}
