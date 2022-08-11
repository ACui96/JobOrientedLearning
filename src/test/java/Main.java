/**
 * @author Acui
 * @date 2022年08月04日 16:41
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int day = sc.nextInt();
        List<String> strings = new ArrayList<>();
        String move = new String();
        while (sc.hasNextLine()) {
            String nextLine = sc.next();

            char flag = nextLine.charAt(0);
            if (flag >= '0' && flag <= '9') {
                move = nextLine;
            }
            strings.add(nextLine);
        }
        int rows = strings.size() - 1;
        int cols = strings.get(0).length();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = strings.get(i).charAt(j);
            }
        }
        int length = Math.min(move.length(), rows);
        StringBuilder sb = new StringBuilder();
        int cr = 0, cc = day - 1;
        for (int i = 0; i < length; i++) {
            int nr = cr + 1;
            int nc = cc == cols ? cc - 1 : cc + 1;
            int desCol = cc + (move.charAt(i) - '0');
            if (desCol > cols) {
                cr += 1;
                cc = desCol - cols;
            }
            sb.append(grid[cr][cc]);
            cr = nr;
            cc = nc;
        }
        System.out.println(sb);
    }
}
