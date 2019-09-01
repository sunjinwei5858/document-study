package com.sunjinwei;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-08-12 09:28
 * @description: jdk8的stream流的使用 ---代码简洁，函数式编程写出的代码简洁且意图明确，使用stream接口让你从此告别for循环。
 * 1。中间操作：总是惰性执行 调用中间操作只会生成一个标记了该操作的新stream
 * 2。结束操作：触发实际计算，计算时会把所有中间操作积攒的操作以pipeline的方式执行，这样可以减少迭代次数。
 *            这样计算完成之后stream就会失效
 * 3.注意：stream不是一种数据结构，无存储，只是某种数据源的一个视图，数据源可以是一个数组，java容器
 *         为函数式编程而生，对stream的任何修改都不会修改背后的数据源
 *         惰性执行，只有用户真正需要结果的时候才会执行
 *         可消费性，只能被消费一次，一旦遍历过就会失效。
 **/
public class Demo01 {
    /**
     * 1。获取stream ：1.大部分是通过容器调用 collection.stream()方法得到
     *              2.Stream.of()方法
     *  数组有两种方法可以获取：1通过Arrays直接将数组获取；2先将数组转成集合，然后集合获取
     *
     * 2.如何将stream转化成集合？--使用collect
     * stream.collect(Collectors.toList())
     */
    @Test
    public void test01(){
        //方式1：通过Arrays获取stream
        String[] arr=new String[]{"aa","bb","cc"};
        Stream<String> stream = Arrays.stream(arr);

        //方式2：数组变集合
        List<String> list = Arrays.asList("aa","cc","ee");
        Stream<String> stringStream = list.stream();

        //方式3：直接Stream.of
        Stream<String> stringStream1 = Stream.of("aa", "vv", "ee");
    }

    /**
     * 2。遍历流中的数据
     */
    @Test
    public void test02(){
        List<User> users = Arrays.asList(new User("张三", 11),
                new User("王五", 20),
                new User("王五", 91),
                new User("张三", 8),
                new User("李四", 44),
                new User("李四", 44),
                new User("李四", 44));

        //方式1：
        users.forEach(user -> System.out.println(user));
        //方式2：
        users.stream().forEach(user -> System.out.println(user));
    }
    /**
     * 3.sorted() 使用该方法排序数据
     */
    @Test
    public void test03(){
        List<User> users = Arrays.asList(new User("张三2", 11),
                new User("王五", 20),
                new User("王五", 91),
                new User("张三", 8),
                new User("李四", 44),
                new User("李四", 44),
                new User("李四", 44));
        //方式1：使用Collections排序 从小到大
        /*Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                //根据年龄进行排序 从小到大 就是01-02
                return o1.getAge()-o2.getAge();
            }
        });*/

        //方式2：使用stream流
        //自然排序
        //users.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user));
        //自定义排序
        users.stream().sorted((s1,s2)->s2.getAge()-s1.getAge()).forEach(user -> System.out.println(user));
    }
    /**
     * 4。filter()：使用该方法过滤
     */
    @Test
    public void test04(){
        List<User> users = Arrays.asList(new User("张三1", 11),
                new User("王五", 20),
                new User("王五", 91),
                new User("张三", 8),
                new User("李四", 44),
                new User("李四", 44),
                new User("李四", 44));
        //只需要包含李四的人
        Stream<User> stream = users.stream().filter(s -> s.getName().equals("李四"));
        List<User> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
    }
    /**
     * demo：将数组进行排序 使用lambda表达式
     */
    @Test
    public void test05(){
        Integer[] arr=new Integer[]{7,23,14,6,78,43};
        //默认s1-s2  从小到大的顺序
        Arrays.stream(arr).sorted().forEach(s-> System.out.println(s));
        //如果要从大到小的 那么需要自定义s2-s1
        Arrays.stream(arr).sorted((s1,s2)->s2-s1).forEach(s-> System.out.println(s));
    }

    /**
     * 将数组进行排序
     */
    @Test
    public void test06(){
        Integer[] arr=new Integer[]{7,23,14,100,6,78,43};
        Arrays.stream(arr).sorted().forEach(s-> System.out.println(s));
    }
    /**
     * 将数组进行去重+排序+遍历：总共4步
     * 1去重：使用set集合
     * 2排序：使用stream流 并且将流转换成集合list
     * 3将list转换为数组
     * 4使用流将数组进行遍历
     *
     */
    @Test
    public void test07(){
        Integer[] arr=new Integer[]{1,3,4,3,2,5,6,3,9,22};
        //去重
        Set<Integer> set=new HashSet<>(Arrays.asList(arr)); //第一步
        System.out.println("数组使用hashset去重：    "+set);
        //排序 从小到大
        List<Integer> list = set.stream().sorted().collect(Collectors.toList()); //第二步
        System.out.println("set使用stream流进行排序并且将流转换成list集合：    "+list);
        //将list集合转换成数组
        Integer[] array = list.toArray(new Integer[list.size()]); //第三步
        //通过流将数组进行遍历
        Stream.of(array).forEach(s-> System.out.println(s)); //第四步
    }




}