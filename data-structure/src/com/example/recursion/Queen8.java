package com.example.recursion;

/**
 * 8皇后
 */
public class Queen8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后存放位置，下标表示行号，对应值表示列
    int[] array = new int[max];
    static int count;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("总结果数：" + count);
    }

    /**
     * 放置皇后
     * @param n 皇后序号
     */
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        // 依次放入皇后，并判断是否冲突
        // check 是每一次递归时，进入到check都有for(int i = 0; i < max; i++)
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后，放到该行第一列
            array[n] = i;

            // 判断当前放置的皇后是否与前面的皇后冲突
            if (judge(n)) { // 不冲突
                // 接着放置第n+1个皇后，即开始递归
                check(n + 1);
            }

            // 如果冲突，就继续执行array[n] = i; 即将第n个皇后放置在本行下一列
        }
    }

    /**
     * 检查放置的皇后，是否与前面的皇后冲突
     * @param n 当前放置的皇后序号
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 判断第n个皇后是否和前面的n-1个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断第n个皇后和第i个皇后是否在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
