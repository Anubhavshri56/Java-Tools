package com.thinking.machines.util;
import java.io.*;
public class Keyboard
{
private BufferedReader bufferedReader;
public Keyboard()
{
bufferedReader=new BufferedReader(new InputStreamReader(System.in));
}
public String getString()
{
String str;
try
{
str=bufferedReader.readLine();
}catch(IOException ioe)
{
str="";
}
return str;
}
public String getString(String message)
{
System.out.print(message);
return getString();
}
public char getCharacter()
{
return getString().charAt(0);
}
public char getCharacter(String message)
{
System.out.print(message);
return getCharacter();
}
public long getLong()
{
long x;
try
{
x=Long.parseLong(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public long getLong(String message)
{
long x;
try
{
System.out.print(message);
x=Long.parseLong(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}

public int getInt()
{
int x;
try
{
x=Integer.parseInt(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public int getInt(String message)
{
int x;
try
{
System.out.print(message);
x=Integer.parseInt(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}

public short getShort()
{
short x;
try
{
x=Short.parseShort(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public short getShort(String message)
{
short x;
try
{
System.out.print(message);
x=Short.parseShort(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}

public byte getByte()
{
byte x;
try
{
x=Byte.parseByte(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public byte getByte(String message)
{
byte x;
try
{
System.out.print(message);
x=Byte.parseByte(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}


public double getDouble()
{
double x;
try
{
x=Double.parseDouble(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public double getDouble(String message)
{
double x;
try
{
System.out.print(message);
x=Double.parseDouble(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}



public float getFloat()
{
float x;
try
{
x=Float.parseFloat(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}
public float getFloat(String message)
{
float x;
try
{
System.out.print(message);
x=Float.parseFloat(getString());
}catch(NumberFormatException numberFormatException)
{
x=0;
}
return x;
}


public boolean getBoolean()
{
boolean x;
try
{
x=Boolean.parseBoolean(getString());
}catch(NumberFormatException numberFormatException)
{
x=false;
}
return x;
}
public boolean getBoolean(String message)
{
boolean x;
try
{
System.out.print(message);
x=Boolean.parseBoolean(getString());
}catch(NumberFormatException numberFormatException)
{
x=false;
}
return x;
}


}