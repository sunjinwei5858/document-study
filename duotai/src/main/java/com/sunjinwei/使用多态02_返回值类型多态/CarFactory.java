package com.sunjinwei.使用多态02_返回值类型多态;

import com.sunjinwei.使用多态01_参数多态.Benchi02;
import com.sunjinwei.使用多态01_参数多态.Car;
import com.sunjinwei.使用多态01_参数多态.JieDa02;

/**
 * @program: com.sunjinwei.使用多态02_返回值类型多态
 * @author: Sun jinwei
 * @create: 2019-07-13 17:02
 * @description:
 * 上面的例子中,不管是JD还是Benz都是我们自己直接new出来的.我们可以设计一个工厂类,专门生成汽车
 *  我们将多态使用在方法的返回类型中
 *  Car可以是抽象类,也可以是接口,JD和Benz分别继承该类或实现该借口
 **/
public class CarFactory {
    /**
     * 多态作用在返回值上面
     * @param carName
     * @return
     */
    public Car createCar(String carName){
        if ("benchi".equals(carName)){
            return new Benchi02();
        }else if ("jieda".equals(carName)){
            return new JieDa02();
        }else {
            System.out.println("对不起，没有该车辆");
            return null;
        }
    }

}