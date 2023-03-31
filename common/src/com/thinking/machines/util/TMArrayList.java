package com.thinking.machines.util;
public class TMArrayList<T> implements TMList<T>
{
private Object[] collection;
private int size;
public TMArrayList()
{
this.collection=new Object[10];
this.size=0;
}
public class TMArrayListIterator implements TMIterator<T>
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return this.index<size;
}
public T next()
{
if(this.index>=size) throw new InvalidIteratorException("Invalid position accessed");
T data=(T)collection[index];
this.index++;
return data;
}
}
public TMIterator iterator()
{
return new TMArrayListIterator();
}
private void resize()
{
Object []tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
public void add(T data)
{
if(this.size%10==0 && this.size!=0) this.resize();
this.collection[this.size]=data;
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
if(this.size%10==0 && this.size!=0) this.resize();
for(int e=this.size;e>index;e--) this.collection[e]=this.collection[e-1];
this.collection[index]=data;
this.size++;
}
public void insert(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
if(this.size%10==0 && this.size!=0) this.resize();
for(int e=this.size;e>index;e--) this.collection[e]=this.collection[e-1];
this.collection[index]=data;
this.size++;
}
public T remove(int index)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
T tmpData=(T)this.collection[index];
for(int e=index;e<this.size-1;e++) this.collection[e]=this.collection[e+1];
this.size--;
return tmpData;
}

public T get(int index)
{
return (T)this.collection[index];
}
public int size()
{
return this.size;
}
public void clear()
{
this.size=0;
}
public void removeAll()
{
this.size=0;
}
public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("Invalid index : "+index);
this.collection[index]=data;
}
public void copyTo(TMList<T> other)
{
other.clear();
if(this.size==0) return;
for(int e=0;e<this.size;e++) other.add(this.get(e));
}
public void copyFrom(TMList<T> other)
{
this.clear();
if(other.size()==0) return;
for(int e=0;e<other.size();e++) this.add((T)other.get(e));
}
public void appendTo(TMList<T> other)
{
if(this.size==0) return;
for(int e=0;e<this.size;e++) other.add(this.get(e));
}
public void appendFrom(TMList<T> other)
{
if(other.size()==0) return;
for(int e=0;e<other.size();e++) this.add((T)other.get(e));
}
public void  forEach(TMTraversal tmTraversal)
{
for(int e=0;e<this.size;e++) tmTraversal.traverse((T)this.collection[e]);
}
}