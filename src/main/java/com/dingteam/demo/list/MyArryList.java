package com.dingteam.demo.list;


import java.util.Arrays;

public class MyArryList<T> {

    /**
     * 默认容量
     */
    private  int DEFAULT_CAPACITY = 10;

    /**
     * 初始化数组
     */
    private  Object[] objects;

    /**
     * 元素的个数
     */
    private  int size;


    /**
     * 增加元素需要扩容
     * @param t
     */
    public  void add(T t){

        if (objects == null) {
            //初始化数组
            objects = new Object[DEFAULT_CAPACITY];
        }
        if (objects != null && size>=DEFAULT_CAPACITY){
            //需要扩容
            int newCapacity = DEFAULT_CAPACITY+(DEFAULT_CAPACITY>>1);
            objects = Arrays.copyOf(objects,newCapacity);
            DEFAULT_CAPACITY = newCapacity;
        }
        objects[size++] = t;
        return;
    }


    public  T get(int index){

        if(objects==null || index>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return (T) objects[index];
    }


    /**
     * 删除元素需要缩容，仅支持下标删除
     * length>0 因为如果删的是数组的最后一个元素，不需要移动数组，只需要置为null
     * @param index
     */
   public  void remove(int index){

        if(objects==null || index<0 || index>=size) {
            throw new ArrayIndexOutOfBoundsException();
        }


        int length = size-index-1;
        if(length>0) {
            System.arraycopy(objects,index+1,objects,index,length);
        }
        objects[--size] = null;
        return;
   }

}
