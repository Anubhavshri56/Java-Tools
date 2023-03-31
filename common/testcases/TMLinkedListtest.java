import com.thinking.machines.util.*;
class psp
{
public static void main(String args[])
{
TMList list=new TMLinkedList();
TMList list1=new TMArrayList();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.add(50);
list.add(60);
list1.add(100);
list1.add(200);
list1.add(300);
list1.add(400);
list1.add(500);
list1.add(600);
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
list1.appendTo(list);
System.out.println("After operation");
for(int e=0;e<list.size();e++) System.out.println(list.get(e));
}
}