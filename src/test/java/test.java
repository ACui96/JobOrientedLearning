import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年08月04日 16:59
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            System.out.println(sc.next());
//        }

        int a = sc.nextInt();
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

    }
}
