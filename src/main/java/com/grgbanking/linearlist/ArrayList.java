package com.grgbanking.linearlist;

/**
 * @author zxlei1
 * @version 1.0  2018年07月12日 zxlei1 create
 * @create 2018年07月12日 13:25
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/

import java.util.Arrays;

/**
 * 自己用数组实现的线性表
 *
 * @param <E>
 */
public class ArrayList<E> {

    /**
     * 用来保存此队列中内容的数组
     */
    Object[] data = null;

    /**
     * 保存当前为第几个元素的指标
     */
    int current;

    /**
     * 表示数组大小的指标
     */
    int capacity;

    public ArrayList() {
        this(10);
    }

    /**
     * 初始化线性表，并且声明保存内容的数组大小
     *
     * @param initalSize
     */
    public ArrayList(int initalSize) {
        if (initalSize < 0) {
            throw new RuntimeException("数组大小错误:" + initalSize);
        } else {
            this.data = new Object[initalSize];
            this.current = 0;
            capacity = initalSize;
        }
    }

    /**
     * 添加元素的方法
     * 添加前，先确认是否已经满了
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        ensureCapacity(current);
        this.data[current] = e;
        current++;
        return true;
    }

    /**
     * 确认系统当前容量是否满足需要,如果满足，则不执行操作 如果不满足，增加容量
     *
     * @param cur 当前个数
     */
    private void ensureCapacity(int cur) {
        if (cur == capacity) {
            //如果容量达到极限，则扩容10
            this.capacity = this.capacity + 10;
            Object[] newdata = new Object[capacity];
            //复制当前数组到新数组中
            for (int i = 0; i < cur; i++) {
                newdata[i] = this.data[i];
            }
            this.data = newdata;
        }
    }

    /**
     * 得到指定下标的数据
     *
     * @param index
     * @return
     */
    public E get(int index) {
        validateIndex(index);
        return (E) this.data[index];
    }

    /**
     * 验证当前下标是否合法，如果不合法，抛出运行时异常
     *
     * @param index 下标
     */
    public void validateIndex(int index) {
        if (index < 0 || index > current) {
            throw new RuntimeException("数组index错误: " + index);
        }
    }

    /**
     * 返回当前队列的大小
     *
     * @return
     */
    public int size() {
        return this.current;
    }

    /**
     * 更改指定下标元素的数据为e
     *
     * @param index
     * @param e
     * @return
     */
    public boolean set(int index, E e) {
        validateIndex(index);
        this.data[index] = e;
        return true;
    }

    /**
     * 在指定下标位置处插入数据e
     *
     * @param index 下标
     * @param e     需要插入的数据
     * @return
     */
    public boolean insert(int index, E e) {
        validateIndex(index);
        //用一个临时数组作为备份
        Object[] tem = new Object[capacity];
        for (int i = 0; i <= current; i++) {
            if (i < index) {
                tem[i] = data[i];
            } else if (i == index) {
                tem[i] = e;
            } else if (i > index) {
                tem[i] = data[i - 1];
            }
        }
        current++;
        this.data = tem;
        return true;
    }

    /**
     * 删除指定下标的元素
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        validateIndex(index);
        //用一个临时数组做备份
        Object[] tem = new Object[capacity];
        //开始备份数组
        for (int i = 0; i < current; i++) {
            if (i < index) {
                tem[i] = data[i];
            } else if (i >= index) {
                tem[i] = data[i + 1];
            }
        }
        current--;
        this.data = tem;
        return true;

    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                ", current=" + current +
                ", capacity=" + capacity +
                '}';
    }
}
