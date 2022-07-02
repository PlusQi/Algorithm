package com.example.recursion;

/**
 * 迷宫 回溯
 */
public class Maze {

    public static void main(String[] args) {
        //创建迷宫
        int[][] maze = new int[8][7];
        // 使用1表示墙，上下表示墙
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        System.out.println("地图：");
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(maze[i][i1] + " ");
            }
            System.out.println();
        }

        setWay(maze, 1, 1);

        System.out.println("地图：");
        for (int i = 0; i < 8; i++) {
            for (int i1 = 0; i1 < 7; i1++) {
                System.out.print(maze[i][i1] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯寻路
     * 约定maze[6][5] 表示终点，当maze[i][j]为0表示该点没有走过，为1表示墙，2表示通路可以走，3表示该点已走过，但是不通
     * 制订寻路策略 下->右->上->左，如果该点不通，再回溯
     *
     * @param maze 地图
     * @param i    (i, j)表示出发位置
     * @param j
     * @return
     */
    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else { // 该点还没走过
            if (maze[i][j] == 0) {
                // 按照策略 下->右->上->左
                maze[i][j] = 2;
                if (setWay(maze, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(maze, i, j - 1)) { // 向左走
                    return true;
                } else { // 说明该点不通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
