package Test;
import java.util.*;
public class myDemo {
    public static void main(String []args) {
        // 向量
        Vector<String> dayNames = new Vector<String>();

        Vector v = new Vector();
        v.addElement(new Integer(10));
        v.addElement(new String("aa"));
        v.addElement(1);
        Vector v2;
        v2 = (Vector) v.clone();
        System.out.println(v.toString());
        System.out.println(v2.toString());


        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");


        System.out.println(dayNames.toString());
        System.out.println(dayNames.size());
        System.out.println(dayNames.capacity());
        System.out.println(dayNames.contains("Friday"));
        System.out.println(dayNames.get(4));
        System.out.println(dayNames.remove(0));
        System.out.println(dayNames.toString());
        System.out.println("-------------Vector---------------------");

        // 栈
        Stack s = new Stack();
        Stack s2 = (Stack) s.clone();
        s.push(new Integer(1));
        s.push('a');

        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.toString());
        System.out.println(s.peek());
        System.out.println(s.toString()+"1111111");
        System.out.println(s2.toString());
        System.out.println("---------------Stack-------------------");


        //  HashMap
        Map<String, String> m = new HashMap<String, String>();

        m.put("1", "1");
        m.put("2", "two");
        m.put("3", "3");
        m.put(null, null);
        // 三种方式 输出 for 迭代器  Map.Entry
//		for (String  key : m.keySet()) {
//			System.out.println("key= "+ key + " and value= " + m.get(key));
//		}

//	    Iterator<Map.Entry<String, String>> i = m.entrySet().iterator();
//	     while (i.hasNext()){
//	    	Map.Entry<String, String> e = i.next();
//	    	System.out.println("key= "+ e.getKey() + " and value= " +e.getValue());
//	     }

        for (Map.Entry<String, String> e : m.entrySet()) {
            System.out.println("key= "+ e.getKey() + " and value= " +e.getValue());
        }
        System.out.println(m.get("2"));
        System.out.println(m.toString());
        System.out.println(m.entrySet());
        System.out.println(m.keySet());
        System.out.println(m.values());
        System.out.println("----------------HashMap------------------");


        /// Hashtable
        Hashtable h = new Hashtable();  //和HashMap类很相似，但是它支持同步

        h.put("jxf", 2.15);
        h.put("lyj", 520);
        h.put("xxx", "hhh");
        h.put(1, 1);

        System.out.println(h.toString());



        System.out.println("---------------Hashtable-------------------");

        Properties p = new Properties();
        p.put("1", "one");
        p.put("2","er");

        p.list(System.out);
        System.out.println(p.toString());
        System.out.println("------------Properties-------------------");


        List<String> list = new ArrayList<String>();

        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        Iterator il = list.iterator();
        while (il.hasNext()){
            System.out.println(il.next());
            il.remove();
        }
        for (Object i: list)
            System.out.println((String)i);
        System.out.println(il.hasNext());
//	     String [] sl = new String[list.size()];
//	     list.toArray(sl);
//	     for (int i1=0; i1<list.size(); i1++) {
//	    	 System.out.println(sl[i1]);
//	     }
//	     for (String s1 : list) {
//	    	 System.out.println(s1);
//	     }


        // HashSet
        Set<Integer> mySet = new HashSet<Integer>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(70);
        System.out.println(mySet.toString());


        System.out.println("-----TreeSet---------");
        // TreeSet  有序集合
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(1);
        sortedSet.add(2);
        sortedSet.add(3);
        sortedSet.add(4);

        Integer [] arr = new Integer[sortedSet.size()];
        sortedSet.toArray(arr);
        for (int i=0; i<arr.length; i++)
            System.out.println(arr[i]);

        Iterator i = sortedSet.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        System.out.println("------------------");
        Integer [] input1 = {1,2,3,4};
        String [] input2 = {"11", "22", "33"};
        Character [] input3 = {'1', '2', '3'};
        showInfo(input1);
        showInfo(input2);
        showInfo(input3);

        MyStudent<Integer> stu = new MyStudent<Integer>(12);
        System.out.print(stu.getT());
        stu.showInfo();

        System.out.println("----------------------------");


        List list1 = new ArrayList();
        list1.add(new Object());
        list1.add(new Integer(11));
        list1.add(new String("sss"));
        for (Object o : list1)
            System.out.println(o.toString());

        List<Object> list2 = list1;  // 增加泛型限制
        list1.add(new Object());
        list1.add(new Integer(22));
        list1.add(new String("ttt"));


        List ll = new LinkedList();
        ll.add(1);
        ll.add("two");

        ListIterator iter = ll.listIterator();
        iter.next();
        iter.add("insert");
        System.out.println(ll.toString());

    }

    public static <E> void showInfo(E [] input) {

        for (E e : input) {
            System.out.println(e);
        }
    }
}

class MyStudent<T>{

    private T t;

    public MyStudent(T t) {
        this.t= t;
    }
    public void showInfo() {
        System.out.println(t);
    }
    public T getT() {
        return t;
    }
}
