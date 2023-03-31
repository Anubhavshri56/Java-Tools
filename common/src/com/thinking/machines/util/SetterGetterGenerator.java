package com.thinking.machines.util;
import java.lang.reflect.*;
import java.io.*;
class SetterGetterGenerator
{
public static void main(String gg[])
{
if(gg.length!=1 && gg.length!=2)
{
System.out.println("invalid command, Usage : java  -classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name");
return;
}
if(gg.length==2)
{
if(gg[1].equalsIgnoreCase("constructor=false")==false && gg[1].equalsIgnoreCase("constructor=true")==false)
{
System.out.println("Invalid comman, Usage : java  -classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name contructor=true/false");
return;
}
}
String className=gg[0];
try
{
Class c=Class.forName(className);
String fieldName,setterName,getterName,line,tmp;
Field fields[];
Field field;
Class fieldType;
TMList<String> list=new TMArrayList<String>();
fields=c.getDeclaredFields();
if(gg.length==1 || (gg.length==2 && gg[1].equalsIgnoreCase("constructor=true")==true))
{
line="public "+c.getName()+"()";
list.add(line);
list.add("{");
for(int e=0;e<fields.length;e++)
{
field=fields[e];
line="this."+field.getName()+"="+getDefaultValue(field.getType())+";";
list.add(line);
}
list.add("}");
}
for(int e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();
if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122) tmp=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
else tmp=fieldName;
line="public void set"+tmp+"("+fieldType.getName()+" "+fieldName+")";
list.add(line);
list.add("{");
line="this."+fieldName+"="+fieldName+";";
list.add(line);
list.add("}");
line="public "+fieldType.getName()+" get"+tmp+"()";
list.add(line);
list.add("{");
line="return this."+fieldName+";";
list.add(line);
list.add("}");
}
File file=new File("tmp.tmp");
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
TMIterator<String> iterator=list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line+"\r\n");
}
randomAccessFile.close();
System.out.println("Setter and getter has been generated and are stored in file named tmp.tmp");
}catch(ClassNotFoundException classNotFoundException)
{
System.out.println("Unable to load class or class not found");
}
catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
private static String getDefaultValue(Class type)
{
if(type.getName().equals("Long") || type.getName().equals("long")) return "0";
if(type.getName().equals("Integer") || type.getName().equals("int")) return "0";
if(type.getName().equals("Short") || type.getName().equals("short")) return "0";
if(type.getName().equals("Byte") || type.getName().equals("byte")) return "0";
if(type.getName().equals("Double") || type.getName().equals("double")) return "0.0";
if(type.getName().equals("Float") || type.getName().equals("float")) return "0.0f";
if(type.getName().equals("Character") || type.getName().equals("char")) return " ";
if(type.getName().equals("Boolean") || type.getName().equals("boolean")) return "fasle";
if(type.getName().equals("java.lang.String")) return "\"\"";
return null;
}
}