package com.sunjinwei.demo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: com.sunjinwei.demo
 * @author: Sun jinwei
 * @create: 2019-07-28 17:30
 * @description: 击鼓传花算法
 **/
public class Demo {
    public static void main(String[] args) {
        //1定义一个玩家数组
        String[] names=new String[]{"andy","amy","hello","tom","sun"};
        //2创建一个队列
        ArrayDeque<String> queue = new ArrayDeque<>();
        //3将玩家放入队列中
        for (String name : names) {
            queue.push(name);
        }

        //4寻找最后剩下来的人 --定义游戏规则 数到8的人淘汰
        int num = 7;
        while (queue.size()>1){
            for (int i = 0; i < num; i++) {
                //将前num-1中的人, 都从队列的前端取出放在队列的后端
                String pop = queue.pop();
                queue.push(pop);
            }
            //将第num个人进行踢出队列
            String last = queue.getLast();
            System.out.println(last);
            queue.remove(last);
        }
        System.out.println(queue.size());
        System.out.println(queue.element());


    }
}