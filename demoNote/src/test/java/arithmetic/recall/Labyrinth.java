package arithmetic.recall;

import java.util.Stack;

/**
 * 回溯法解决迷宫问题
 *
 * @Author li zhiqang
 * @create 2022/5/12
 */
public class Labyrinth {
    static int[][] matrix;
    public static void main(String[] args) {

        // 1 代表围墙，2代表走过，-1代表该点不通，避免下次重复搜索
        matrix = new int[][] {
                {1,1,1,1,1,1,1,1,1,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,0,0,0,0,1,1,0,0,1},
                {1,0,1,1,1,0,0,0,0,1},
                {1,0,0,0,1,0,0,0,0,1},
                {1,0,1,0,0,0,1,0,0,1},
                {1,0,1,1,1,0,1,1,0,1},
                {1,1,0,0,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1,1,1}
        };
        goCopy(new int[]{1, 1});
        printResult();
    }


    public static void go(int[] start){
        // 初始化栈
        Stack<int[]> stack = new Stack<>();
        // 初始化四个方向 上下左右
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        // （1,1）作为起点
        stack.push(start);
        // 修改（1,1）的值为 2，代表已经走过
        matrix[1][1] = 2;
        while (!stack.isEmpty()) {  // 栈不为空就一直循环
            int[] cur = stack.peek();  // 获取当前点，cur[0]：代表 横坐标 cur[1]：代表纵坐标
            // 到达终点
            if (cur[0] == 8 && cur[1] == 8) {
                break;
            }
            // 从当前点向四个方向找可行的点
            int i;
            for (i = 0; i < 4; i++) {
                int row = cur[0]+x[i];
                int column = cur[1]+y[i];

                // 判断当前方向是否可以通过
                if (matrix[row][column] == 0) {
                    stack.push(new int[]{row, column});
                    matrix[row][column] = 2;
                    break;
                }
            }
            // 如果未找到可行方向，则将栈顶元素 pop，修改为 -1
            if (i == 4) {
                cur = stack.pop();
                matrix[cur[0]][cur[1]] = -1;
            }
        }
    }


    /**
     * 使用栈来记录走迷宫的路线
     * @param start
     */
    public static void goCopy(int[] start){
        Stack<int[]> load = new Stack<>();
        load.push(start);

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        while(!load.isEmpty()){
            if(matrix[8][8] == 2){
                break;
            }
            int[] latestStep = load.peek();
            if(matrix[latestStep[0]][latestStep[1]] == 0 || matrix[latestStep[0]][latestStep[1]] == 2){
                matrix[latestStep[0]][latestStep[1]] = 2;

                //按上下左右顺序尝试
                int i;
                for (i = 0; i < 4; i++) {
                    int row = latestStep[0] + x[i];
                    int column = latestStep[1] + y[i];
                    if(matrix[row][column] == 0){
                        load.push(new int[]{row, column});
                        break;
                    }
                }

                if(i == 4){
                    //四个方向都走不通，将该位置标记为-1，并退回上一步，即pop出load中的栈顶元素
                    matrix[latestStep[0]][latestStep[1]] = -1;
                    load.pop();
                }

            }

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
