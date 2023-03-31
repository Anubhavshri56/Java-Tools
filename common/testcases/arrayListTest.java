import com.thinking.machines.util.*;
class arrayListTest
{
public static void main(String gg[])
{
TMList<Integer> list=new TMLinkedList();
TMList list1=new TMArrayList();
list.add(10);
list.add(20);
list.add(30);
//list.add("gandu");
list.add(50);
list.add(60);
//list.add(2.34);
list.add(80);
list.add(90);
list.add(100);
list.add(110);
list.add(120);
for(int e=0;e<list.size();e++) System.out.println((e+1)+" "+list.get(e));
list1.add(600);
list1.add("ashwath");
list1.add(800);
list1.add(900);
list1.add(1000);
list1.add(1100);
list1.add(1200);
list1.appendTo(list);
System.out.println("After operation");
for(int e=0;e<list.size();e++) System.out.println((e+1)+" "+list.get(e));


}
}

