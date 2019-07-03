package ssm.Chapter2.builder;

public class TicketBuilder {

    public static Object builder(TicketHelper helper){
        System.out.println("通过TicketHelper G构建套票信息");
        System.out.println(helper.infos);
        return null;
    }
}
