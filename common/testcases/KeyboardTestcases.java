import com.thinking.machines.util.*;
class KeyboardTestcases
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
a=k.getString("Enter a string : ");
System.out.println(a);
long b;
b=k.getLong("Enter Long Integer : ");
System.out.println(b);
int c;
c=k.getInt("Enter Int Integer : ");
System.out.println(c);
short d;
d=k.getShort("Enter Short Integer : ");
System.out.println(d);
byte e;
e=k.getByte("Enter Byte Integer : ");
System.out.println(e);
double f;
f=k.getDouble("Enter Double Integer : ");
System.out.println(f);
float g;
g=k.getFloat("Enter Float Integer : ");
System.out.println(g);
char h;
h=k.getCharacter("Enter Charater : ");
System.out.println(h);
boolean i;
i=k.getBoolean("Enter Boolean Integer : ");
System.out.println(i);


}


}