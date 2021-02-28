package com.example.sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组表示棋盘
        // 0：表示没有棋子，1：表示黑子，2：表示白子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        // 输出原始的二维数组
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转稀疏数组
        // 1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        // 2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 遍历二维数组，将非0的值存放到sparseArray中
        int count = 0; // count用于记录是第几个非0数据
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组------------");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        System.out.println();


        /*
        * 将稀疏数组恢复成二维数组
        * 1.先读取稀疏数组的第一行数据，创建原始的二维数组
        * 2.再读取稀疏数组其余行的数据，并赋值给二维数组
        * */
        // 1.先读取稀疏数组的第一行数据，创建原始的二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 2.再读取稀疏数组其余行的数据，并赋值给二维数组
        for (int x = 1; x < sparseArray.length; x++) {
            chessArray2[sparseArray[x][0]][sparseArray[x][1]] = sparseArray[x][2];
        }

        // 输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] ints : chessArray2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
