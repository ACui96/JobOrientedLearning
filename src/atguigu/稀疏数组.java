package atguigu;

/**
 * @author Acui
 * @date 2021年05月09日 20:04
 */
public class 稀疏数组 {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("=================原始数组========================");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int sum = 0;
        //1
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) {
                    sum += 1;
                }
            }
        }
        System.out.println("有效数据的个数：" + sum);
        //2.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //3.给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int rowCnt = 1;//用于记录当前正在写入稀疏矩阵的行数
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[rowCnt][0] = i;
                    sparseArr[rowCnt][1] = j;
                    sparseArr[rowCnt][2] = chessArr1[i][j];
                    rowCnt++;
                }
            }
        }
        System.out.println();
        System.out.println("=================稀疏数组===========");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //恢复成原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("=================恢复后的原始数组====================");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
