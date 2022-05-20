package arithmetic.recall;

/**
 * 回溯法解决迷宫问题
 *
 * @Author li zhiqang
 * @create 2022/5/12
 */
public class Labyrinth2 {
    static int[][] matrix;
    public static void main(String[] args) {

        // 1 代表围墙，2代表走过，-1代表该点不通，避免下次重复搜索
        matrix = new int[][] {
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,0,0,1,1,1,0,1},
                {1,0,1,1,1,0,0,0,0,1},
                {1,0,0,0,1,0,0,0,0,1},
                {1,0,1,0,0,0,1,0,0,1},
                {1,0,1,1,1,0,1,1,0,1},
                {1,1,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}
        };
        // 起点 （1,1）终点（8,8），可以灵活设置
        recursionCopy(1, 1);
        printResult();
    }
    // 递归方法
    public static boolean recursion(int i, int j) {
        // 递归结束条件，代表已到达终点（8,8）
        if (matrix[8][8] == 2) {
            return true;
        }
        // 判断4个方向是否可行，一个方向可行就往深度递归，否则:回溯
        if (matrix[i][j] == 0) {  // 如果该点未访问过，则从该点探索
            matrix[i][j] = 2;
            if (recursion(i-1, j)) {  // 如果上方可行，则继续探索
                return true;
            } else if (recursion(i+1, j)) {  // 下方
                return true;
            } else if (recursion(i, j-1)) {  // 左方
                return true;
            } else if (recursion(i, j+1)) {  // 右方
                return true;
            } else {  // 如果四个方向 都不行说明该递归分支，不行，回溯
                // 该点走不通，标记 -1，避免重复访问
                matrix[i][j] = -1;
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 递归实现走出迷宫算法
     * 1：迷宫的围墙
     * 2：行走路线
     * -1：退回路线
     *
     * @param x
     * @param y
     * @return true：表示能走；false：表示不能走
     */
    public static boolean recursionCopy(int x, int y){
        //退出递归的条件
        if(matrix[8][8] == 2){
            return true;
        }

        //如果该位置值为0表示可以走，将该位置赋值为2
        if(matrix[x][y] == 0){
            matrix[x][y] = 2;

            //按照上下左右的固定顺序探查走出迷宫的路线
            if(recursionCopy(x - 1, y)){ //上
                return true;
            } else if(recursionCopy(x + 1, y)){ //下
                return true;
            } else if(recursionCopy(x, y - 1)){ //左
                return true;
            } else if(recursionCopy(x, y + 1)) { //右
                return true;
            } else { //上下左右都走不通，则将该位置赋值为-1并返回false，程序将退回到递归的上一个位置，并继续按上下左右顺序进行尝试
                matrix[x][y] = -1;
                return false;
            }
        } else {
            return false;
        }

    }


    // 输出迷宫图，显示路线
    public static void printResult() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1){
                    System.err.print(matrix[i][j]+"\t");
                } else {
                    System.out.print(matrix[i][j]+"\t");
                }
            }
            System.out.println();
        }
    }
}
