package ssm.Chapter2.builder;

public class BuilderTest {
    public static void main(String []args) throws InterruptedException{
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("*成人票");
        helper.buildChildrenForSeat("*有座儿童票");
        helper.buildChildrenNoSeat("*无座儿童票");
        helper.buildElderly("*老人票");
        helper.buildSoldier("*军人票");
        Thread.sleep(1000);
        Object ticket = TicketBuilder.builder(helper);
    }
}
