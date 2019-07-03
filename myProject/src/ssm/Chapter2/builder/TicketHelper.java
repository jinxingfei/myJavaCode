package ssm.Chapter2.builder;

public class TicketHelper {
    public String infos = "";
    public void buildAdult(String info){
        System.err.println("构建成年人票"+info);
        infos += info;
    }

    public void buildChildrenForSeat(String info){
        System.err.println("构建有座儿童票"+info);
        infos += info;
    }

    public void buildChildrenNoSeat(String info){
        System.err.println("构建无座儿童票"+info);
        infos += info;
    }

    public void buildElderly(String info){
        System.err.println("构建老年人票"+info);
        infos += info;
    }

    public void buildSoldier(String info){
        System.err.println("构建军人及家属票"+info);
        infos += info;
    }
}
