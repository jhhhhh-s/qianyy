package com.dingteam.demo.list;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;

/**
 * 双向节点的链表
 *
 * @param <T>
 */
public class MyLinkList<T> {


    /**
     * 默认容量
     */
    private int DEFAULT_CAPACITY = 10;

    private Entry<T> first;

    @Data
    class Entry<T> {
        T t;
        Entry<T> pre;
        Entry<T> next;

        Entry(Entry<T> pre, Entry<T> next, T t) {

            this.pre = pre;
            this.next = next;
            this.t = t;
        }
    }


    /**
     * 链表后追加元素
     *
     * @param t
     */
    public void add(T t) {

        if (first == null) {
            first = new Entry<>(null, null, t);

        } else {
            Entry<T> e = first;
            while (e.next != null) {
                e = e.next;
            }
            e.next = new Entry<>(e, null, t);
        }

        return;
    }


    /**
     * 查找元素
     *
     * @param t
     * @return
     */

    public T get(T t) {

        Entry<T> e = first;
        while (e != null) {
            if (e.getT().equals(t)) {
                return e.getT();
            }

            e = e.next;
        }
        return null;
    }

    /**
     * 删除指定元素，并把该节点置为null
     * @param t
     */
    public void remove(T t) {

        Entry<T> e = first;
        while (e!=null && e.next!= null){

            //删除的是头结点
            if(e.getT().equals(t)){
                first = e.next;

                //指控旧的头结点
                first.pre = null;
                e.next = null;
                e.t = null;
                return;
            }

            //删除的不是头结点
            if(  e.next.getT().equals(t)){
                Entry<T> temp = e.next;
                e.next = temp.next;
                temp.next.pre = e;

                //置空删除的节点
                temp.next= null;
                temp.pre = null;
                temp.t = null;
            }
            e = e.next;
        }

        return;
    }


}
