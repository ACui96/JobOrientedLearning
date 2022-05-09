package Java.JavaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Acui
 * @date 2021年07月13日 14:34
 */
public class URLDemo {
    public static void main(String[] args) throws IOException {
//        URL url = new URL("http://www.baidu.com");
        URL url = new URL("http://acui96.github.io");

        InputStream is = url.openStream();

        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
