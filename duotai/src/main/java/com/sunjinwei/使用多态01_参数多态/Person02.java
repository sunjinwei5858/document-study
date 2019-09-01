package com.sunjinwei.使用多态01_参数多态;

/**
 * @program: com.sunjinwei.使用多态01_参数多态
 * @author: Sun jinwei
 * @create: 2019-07-13 16:51
 * @description: 运用参数多态,以后不管买什么车都可以
 * 这个demo是将多态用在方法的参数上面
 * K中可以大量的看到多态的应用,比如在Object类中的equals(Object obj)方法中,参数是个Object类型的参数
 *
 * 因为Object是Java中所有类的基类.,但是才传入参数的时候,可以传入任何一个类的对象 这就是多态的应用!
 * 使用多态可以解决项目中紧偶合的问题,提高程序的课扩展性.是OCP原则的一个具体的实现
 *
 **/
public class Person02 {
    private Car car;

    public void drive(){
        car.run();
    }

    public Person02() {
    }

    public Person02(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    //运用参数多态,以后不管买什么车都可以
    public void setCar(Car car) {
        this.car = car;
    }
}