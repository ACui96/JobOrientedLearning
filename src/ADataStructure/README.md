# 数据结构简介

## 0. 前言

如下图所示，常见的数据结构可分为「线性数据结构」与「非线性数据结构」，具体为：「数组」、「链表」、「栈」、「队列」、「树」、「图」、「散列表」、「堆」。

<img src="D:\Users\acui\IdeaProjects\DataStruct\src\ADataStructure\image\1599638810-SZDwfK-Picture1.png" alt="常见数据结构" style="zoom: 45%;" />

## 1. 数组

数组是将相同类型的元素存储于连续内存空间的数据结构，其长度**不可变**。

构建此数组需要在初始化时给定长度，并对数组每个索引元素赋值：

```java
// 初始化一个长度为 5 的数组 array
int[] array = new int[5];
// 元素赋值
array[0] = 2;
array[1] = 3;
array[2] = 1;
array[3] = 0;
array[4] = 2;

// 或者在初始化时直接赋值
int[] array1 = {2, 3, 1, 0, 2};
```

「可变数组」是经常使用的数据结构，其基于数组和扩容机制实现，相比普通数组更加灵活。常用操作有：访问元素、添加元素、删除元素。

```java
// 初始化可变数组
List<Integer> array2 = new ArrayList<>();

// 向尾部添加元素
array2.add(2);
array2.add(3);
array2.add(1);
array2.add(0);
array2.add(2);

// 访问元素
System.out.println(array2.get(2));

// 删除元素
array2.remove(2);
```

## 2. 链表

链表以节点为单位，每个元素都是一个独立对象，在内存空间的存储是非连续的。链表的节点对象具有两个成员变量：「值 `val`」，「后继节点引用 `next`」 。

```java
class ListNode {
    int val;        //节点值
    ListNode next;  //后续节点引用

    ListNode(int x) {
        val = x;
    }
}
```

```java
// 实例化节点
ListNode n1 = new ListNode(0);// 节点 head
ListNode n2 = new ListNode(1);
ListNode n3 = new ListNode(2);

// 构建引用指向
n1.next = n2;
n2.next = n3;
```

## 3. 栈

栈是一种具有 「先入后出」 特点的抽象数据结构，可使用数组或链表实现。

```java
Stack<Integer> stack = new Stack<>();
stack.push(1); // 元素 1 入栈
stack.push(2); // 元素 2 入栈
stack.pop();   // 出栈 -> 元素 2
stack.pop();   // 出栈 -> 元素 1
```

> 注意：通常情况下，不推荐使用 Java 的 Vector 以及其子类 Stack ，而一般将 Linked List作为栈来使用。详细说明请见：[Stack，Array Deque，Linked List的区别](https://blog.csdn.net/cartoon_/article/details/87992743) 。
>

