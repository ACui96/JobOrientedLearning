package atguigu.递归;

/**
 * @author Acui
 * @date 2021年05月12日 10:21
 */
public class migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i]= 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("============初始地图===============");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }

//        setWay(map, 1, 1);
        setWay2(map, 1, 1);
        System.out.println("============标识地图===============");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     * 说明: 结束位置为 (6,5)
     * 约定: 当 map[i][j] 为 2 表示可以走
     * 策略：下-右-上-左  ↓ → ↑ ←，如果走不通再回溯
     * @author Acui
     * @date 2021/5/12 10:26
     * @param map 地图
     * @param i 开始位置横坐标
     * @param j 开始位置纵坐标
     * @return boolean 是否找到路径
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//该点没走过
                map[i][j] = 2; // 假定可以走通
                if (setWay(map, i + 1, j)) { //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//map[i][j] != 0,可能是 1，2，3
                return false;
            }
        }
    }

    /**
     * 使用递归回溯给小球找路
     * 说明: 结束位置为 (6,5)
     * 约定: 当 map[i][j] 为 2 表示可以走
     * 策略：  ↑ → ↓   ←，如果走不通再回溯
     * @author Acui
     * @date 2021/5/12 10:26
     * @param map 地图
     * @param i 开始位置横坐标
     * @param j 开始位置纵坐标
     * @return boolean 是否找到路径
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//该点没走过
                map[i][j] = 2; // 假定可以走通
                if (setWay2(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//map[i][j] != 0,可能是 1，2，3
                return false;
            }
        }
    }
 
}
