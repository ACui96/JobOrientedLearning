package Interview.alibaba20220415;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年04月15日 18:58
 */
public class Q2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 行
//        int m = sc.nextInt(); // 列
//        char[][] board = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            String line = sc.next();
//            for (int j = 0; j < m; j++) {
//                board[i][j] = line.charAt(j);
//            }
//        }

        //4 5
        //rpprr
        //prrpp
        //p.r..
        //p..r.
        char[][] board = new char[][]{
                {'r', 'p', 'p', 'r', 'r'},
                {'p', 'r', 'r', 'p', 'p'},
                {'p', '.', 'r', '.', '.'},
                {'p', '.', '.', 'r', '.'}};

        // kou         yukari       to be continued
        func(board);

    }

    private static List<Character> path = new ArrayList<>();
    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

    private static void func(char[][] board) {
//        if (board == null || board.length == 0){}
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        if (dfs(board, 0, 0, 'r', visited)){
            System.out.println("kou");
            return;
        }
        if (dfs(board, 0, 0, 'p',visited)) {
            System.out.println("yukari");
            return;
        }
        System.out.println("to be continued");

    }

    private static boolean dfs(char[][] board, int r, int c, char rp, boolean[][] visited) {
        if (path.size() >= 4) return true;
        if (visited[r][c] || r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        char cc = board[r][c];
        if (cc == rp) {
            for (int[] direction : directions) {
                int dx = direction[0], dy = direction[1];
                int prex = r - dx, prey = c - dy;
                int nextX = r + dx, nextY = c + dy;
                if (prex > 0 && prex < board.length && prey > 0 && prey < board.length &&
                        nextX > 0 && nextY < board.length && nextX > 0 && nextY < board.length) {
                    char next = board[r + dx][c + dy];
                    if (cc == next) { // 当前跟前一个连着
                        visited[r][c] = true;
                        path.add(cc);
                        dfs(board, r+dx, c + dy, rp,visited);
                        visited[r][c] = false;
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
        return false;

    }
}
