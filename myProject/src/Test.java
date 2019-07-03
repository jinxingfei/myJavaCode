import java.util.*;

public class Test {

    public static void main(String[] args){
//        String strs = "1234";
//        strs.toCharArray();
        char[] c = {'i','o'};
        String str1 = new String(c,0,1);
        System.out.println(str1);
        String ss = "sos";

        byte[] b = {1,2,3};

        List l = new ArrayList();
        l.add(1);
        l.add("2");
        for (Object o: l){
            System.out.print(o);
        }
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.print(wordPattern(pattern, str));
    }

    public static boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");

        Map map = new HashMap();
        //System.out.print(p.length+s.length);
        if(p.length != s.length)
            return false;
        for(int i=0;i<pattern.length();i++)
        {
            if(map.containsKey(p[i])){
                System.out.print(map.get(p[i]).getClass() +" "+s[i]);
                System.out.print(map.get(p[i]) != s[i]);
                if (map.get(p[i]) != s[i])
                    return false;
            }
            else{// 不在其中
                if (map.containsValue(s[i]))
                    return false;
                else
                    map.put(p[i], s[i]);
            }
            //System.out.print(map.keySet());
        }
        return true;
    }
}
