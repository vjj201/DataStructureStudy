package org.example;

import java.util.Scanner;

/**
 * @author YuCheng
 * @date 2021/12/8 - 下午 03:49
 */
public class ArrayQueue {
    //隊列最大容量
    private int maxSize;
    //隊首
    private int front;
    //隊尾
    private int rear;
    //存放資料，模擬隊列
    private int[] array;

    //初始化
    public ArrayQueue(int arraySize) {
        maxSize = arraySize;
        front = -1;
        rear = -1;
        array = new int[maxSize];
    }

    //隊列是否已滿
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //隊列是否為空
    public boolean isEmpty() {
        return front == rear;
    }

    //隊尾添加資料
    public void addData(int n) {
        if (isFull()) {
            System.out.println("隊列已滿");
            return;
        }
        rear++;
        array[rear] = n;
    }

    //隊首取出資料
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("隊列為空");
        }
        front++;
        return array[front];
    }

    //顯示隊列所有資料
    public void showAllData() {
        if (isEmpty()) {
            System.out.println("隊列為空");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    //顯示隊列首資料
    public void showFront() {
        if (isEmpty()) {
            System.out.println("隊列為空");
            return;
        }
        System.out.println(array[front + 1]);
    }

    //測試
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s:顯示隊列");
            System.out.println("e:退出程式");
            System.out.println("a:添加資料");
            System.out.println("g:取出資料");
            System.out.println("f:查看隊首");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' :
                    arrayQueue.showAllData();
                    break;
                case 'e' :
                    flag = false;
                    break;
                case 'a' :
                    System.out.println("輸入數字");
                    int n = scanner.nextInt();
                    arrayQueue.addData(n);
                    break;
                case 'g' :
                    System.out.println(arrayQueue.getData());
                    break;
                case 'f' :
                    arrayQueue.showFront();
                    break;

            }
        }
    }
}
