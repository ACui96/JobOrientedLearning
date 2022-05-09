package Java.JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Acui
 * @date 2021年07月13日 14:45
 */
public class NIOCopyDemo {
    public static void fastCopy(String src, String dist) throws IOException {

        FileInputStream fin = new FileInputStream(src);
        FileChannel fcin = fin.getChannel();
        FileOutputStream fout = new FileOutputStream(dist);

        FileChannel fcout = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            int r = fcin.read(buffer);
            if (r == -1) {
                break;
            }

            buffer.flip();
            fcout.write(buffer);
            buffer.clear();
        }

    }

    public static void main(String[] args) throws IOException {
        String src = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\forCopy.txt";
        String dist = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\forCopy1.txt";
        fastCopy(src, dist);
    }
}
