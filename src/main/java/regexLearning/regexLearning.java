package regexLearning;

/**
 * @author Acui
 * @date 2022年05月29日 21:09
 */
public class regexLearning {
    public static void main(String[] args) {
        String pattern = "\\d{18}";
        String phoneRegex = "\\d{11}";
        String emailRegex = "[a-zA-Z]+@[a-z0-9]+\\.[a-z]+";


        String id = "130429199611078013";
        String phoneNumber = "17603209617";
        String email = "LianTong@163.com";

        System.out.println(id.matches(pattern));
        System.out.println(phoneNumber.matches(phoneRegex));
        System.out.println(email.matches(emailRegex));

        System.out.println("\"1010926232\".matches(\"^\\\\d{10}$\") = " + "1010926232".matches("^\\d{10}$"));


    }
}
