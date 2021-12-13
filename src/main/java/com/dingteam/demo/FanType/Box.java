package com.dingteam.demo.FanType;


import lombok.Data;

@Data
public class Box<T> {

    private  T data;

    public Box(T data){
        this.data = data;
    }

    /**
     * 泛型方法
     * 1）public与返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * @param t
     * @param <T>
     * @return
     */
    public <T> T genericMethod(Box<T> t){

        return t.getData();
    }

    public static void main(String[] args) {


        Box box0 = new Box("1");

        Box<String> box1 = new Box<>("1");
        Box<Integer> box2 = new Box<>(2);
        Box<Number> box3 = new Box<>(3);

        System.out.println("box1.getData() = " + box1.getData().getClass());
        System.out.println("box2.getData() = " + box2.getData().getClass());
        System.out.println("box3.getData() = " + box3.getData().getClass());

        getData1(box1);
        getData1(box2);

//        getData2(box1);  //此处报错，类型通配符上限，只能是Number及其子类
        getData2(box2);

//        getData3(box1); //此处报错，类型通配符下限，只能是Number及其父类
//        getData3(box2);
        getData3(box3);


        //使用泛型方法
        String s = box1.genericMethod(box1);
        System.out.println("泛型值:"+s);

    }

    public  static  void  getData1(Box<?> data1){
        System.out.println("data1.getData() = " + data1.getData());
    }

    public  static  void  getData2(Box<? extends Number> data2) {
        System.out.println("data2.getData() = " + data2.getData());
    }

    public  static  void  getData3(Box<?  super Number> data3){
        System.out.println("data3.getData() = " + data3.getData());
    }

}
