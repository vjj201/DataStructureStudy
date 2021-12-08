package org.example;

/**
 * @author YuCheng
 * @date 2021/12/8 - 下午 02:18
 */
public class SparseArray {
    public static void main(String[] args) {
        //創建一個二維陣列
        int[][] chessArray = new int[11][8];
        chessArray[2][4] = 5;
        chessArray[5][7] = 7;
        chessArray[10][3] = 3;

        for (int[] array : chessArray) {
            for (int data : array) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("稀疏陣列");

        int[][] sparseArray = new SparseArray().toSparseArray(chessArray);
        for (int[] array : sparseArray) {
            for (int data : array) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("還原陣列");

        int[][] chessArray2 = new SparseArray().toChessArray(sparseArray);
        for (int[] array : chessArray2) {
            for (int data : array) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

    public int[][] toSparseArray(int[][] chessArray) {
        int row = chessArray.length;
        int col = chessArray[0].length;
        int count = 0;

        //第一次遍歷算出有幾個值
        for (int[] array : chessArray) {
            for (int data : array) {
                if (data != 0) {
                    count++;
                }
            }
        }
        //第一行放入陣列行列值資料，所以總數加一
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = col;
        sparseArray[0][2] = count;
        int stand = 1;

        //有值的位置放入新的陣列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (chessArray[i][j] != 0) {
                    //row
                    sparseArray[stand][0] = i;
                    //col
                    sparseArray[stand][1] = j;
                    //value
                    sparseArray[stand][2] = chessArray[i][j];
                    stand++;
                }
            }
        }
        return sparseArray;
    }

    public int[][] toChessArray(int[][] sparseArray) {
        int[][] chessArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessArray;
    }
}
