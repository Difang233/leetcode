public class $0059$SpiralMatrixII {
    public static void main(String[] args) {
        printMatrix(generateMatrix(5));
    }

    /**
     * 用一对索引(row, col)来模拟矩阵填充的过程：
     * 1.初始化一个n*n的矩阵，其每个元素都是0
     * 2.初始索引(0, 0)，指向矩阵的左上角
     * 3.将i放入该位置，并向右移动一格
     * 4.如果所指的位置，超出当前矩阵的范围或者该位置已经有值（不为0），按照 右-》下-》左-》上 的顺序进行方向的切换
     * 时间复杂度：O(n^2)
     * @param n
     * @return
     */
    static int[][] generateMatrix(int n) {
        int row = 0, col = 0, direct = 0;
        int powN = (int) Math.pow(n, 2);
        int[][] result = new int[n][n];
        for (int i = 1; i <= powN; i++) {
            result[row][col] = i;
            switch (direct) {
                //向右移动
                case 0:
                    //当移动到头或者下一个位置有值时，转向下
                    if (++col == n || result[row][col] != 0) {
                        direct = ++direct % 4;
                        col--;
                        row++;
                    }
                    break;
                //向下移动
                case 1:
                    //转向左
                    if (++row == n || result[row][col] != 0) {
                        direct = ++direct % 4;
                        row--;
                        col--;
                    }
                    break;
                //向左移动
                case 2:
                    //转向上
                    if (--col == -1 || result[row][col] != 0){
                        direct = ++direct % 4;
                        col++;
                        row--;
                    }
                    break;
                    //向上移动
                case 3:
                    //转向右
                    if (result[--row][col] != 0){
                        direct = ++direct % 4;
                        row++;
                        col++;
                    }
                    break;
            }
        }
        return result;
    }

    static void printMatrix(int[][] result){
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
