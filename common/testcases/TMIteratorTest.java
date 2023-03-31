import com.thinking.machines.util.*;
class TMIteratorTest
{
public static void main(String gg[])
{
TMList list=new TMArrayList();
TMList list1=new TMLinkedList();
list.add(10);
list.add(20);
list.add(30);
list.add(40);
list.add(50);
list.add(60);
list.add(70);
list.add(80);
list.add(90);
list.forEach((j)->{System.out.println(j);});
}

}