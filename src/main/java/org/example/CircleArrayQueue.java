package org.example;

import java.util.Scanner;

/**
 * @author YuCheng
 * @date 2021/12/8 - 下午 05:05
 */
public class CircleArrayQueue {
    //隊列最大容量，實際會少一格當作判斷
    private int maxSize;
    //隊首，指向第一個元素
    private int front;
    //隊尾，指向最後一個元素的後面位置，空白區域判斷空或滿
    private int rear;
    //存放資料，模擬隊列
    private int[] array;

    //初始化
    public CircleArrayQueue(int arraySize) {
        maxSize = arraySize;
        array = new int[maxSize];
    }

    //隊列是否已滿
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //隊首取出資料
    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("隊列為空");
        }
        int data =
        front = (front + 1) % maxSize;
        return data;
    }

    //顯示隊列所有資料
    public void showAllData() {
        if (isEmpty()) {
            System.out.println("隊列為空");
            return;
        }
        //從頭開始找出全部元素
        for (int i = front; i < front + countSize(); i++) {
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    //當前有效資料數
    public int countSize() {
        return (rear - front + maxSize) % maxSize;
    }

    //顯示隊列首資料
    public void showFront() {
        if (isEmpty()) {
            System.out.println("隊列為空");
            return;
        }
        System.out.println(array[front]);
    }

    //測試
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
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
                    circleArrayQueue.showAllData();
                    break;
                case 'e' :
                    flag = false;
                    break;
                case 'a' :
                    System.out.println("輸入數字");
                    int n = scanner.nextInt();
                    circleArrayQueue.addData(n);
                    break;
                case 'g' :
                    try {
                        System.out.println(circleArrayQueue.getData());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'f' :
                    circleArrayQueue.showFront();
                    break;

            }
        }
    }

}
