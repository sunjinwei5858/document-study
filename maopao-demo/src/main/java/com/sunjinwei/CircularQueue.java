package com.sunjinwei;

import java.util.Arrays;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-08-20 10:03
 * @description: 使用数组实现循环队列
 **/
public class CircularQueue {
    private String[] values;// 容器
    private int capacity = 0;// 容量
    // head 表示队头下标，tail表示对尾下标
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        values = new String[capacity];
        this.capacity = capacity;
    }

    public Boolean enqueue(String value) {
        // 队列满了
        if ((tail + 1) % capacity == head) {
            return false;
        }
        values[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = values[head];
        head = (head + 1) % capacity;
        return ret;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "values=" + Arrays.toString(values) +
                ", capacity=" + capacity +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
