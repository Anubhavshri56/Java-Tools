package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
private class TMLinkedListNode
{
public TMLinkedListNode next;
public T data;
TMLinkedListNode()
{
this.next=null;
this.data=null;
}
}
private TMLinkedListNode head;
private TMLinkedListNode end;
int size;
public class TMLinkedListIterator implements TMIterator<T>
{
private TMLinkedListNode ptr;
public TMLinkedListIterator(TMLinkedListNode ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(this.ptr==null) throw new InvalidIteratorException("invalid position accessed");
T data=(T)ptr.data;
ptr=ptr.next;
return data;
}
}
public TMIterator iterator()
{
return new TMLinkedListIterator(this.head);
}
public TMLinkedList()
{
this.head=null;
this.end=null;
this.size=0;
}
private TMLinkedListNode createNode(T data)
{
TMLinkedListNode tmp=new TMLinkedListNode();
tmp.data=data;
tmp.next=null;
return tmp;
}
public void add(T data)
{
TMLinkedListNode tmp=createNode(data);
if(this.size==0)
{
this.head=tmp;
this.end=tmp;
}
else
{
this.end.next=tmp;
this.end=tmp;
}
this.size++;
}
public void add(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid index");
TMLinkedListNode tmp=createNode(data);
TMLinkedListNode t1=null,t2=null;
if(index==0) 
{
tmp.next=head;
head=tmp;
}
else
{
t1=this.head;
for(int e=0;e<index;e++,t1=t1.next) t2=t1;
t2.next=tmp;
tmp.next=t1; 
}
this.size++;
}
public void insert(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index");
TMLinkedListNode tmp=createNode(data);
TMLinkedListNode t1=null,t2=null;
if(index==0) 
{
tmp.next=head;
head=tmp;
}
else
{
t1=this.head;
for(int e=0;e<index;e++,t1=t1.next) t2=t1;
t2.next=tmp;
tmp.next=t1; 
}
this.size++;
}
public void removeAll()
{
this.size=0;
this.head=null;
}
public void clear()
{
this.size=0;
this.head=null;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index");
TMLinkedListNode tmp=this.head;
for(int e=0;e<index;e++,tmp=tmp.next);
return (T)tmp.data;
}
public void update(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index");
TMLinkedListNode tmp=this.head;
for(int e=0;e<index;e++,tmp=tmp.next);
tmp.data=data;
}
public void copyTo(TMList other)
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
public void forEach(TMTraversal tmTraversal)
{
for(TMLinkedListNode tmp=this.head;tmp!=null;tmp=tmp.next)
{
tmTraversal.traverse(tmp.data);
}
}
}