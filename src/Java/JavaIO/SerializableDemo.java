package Java.JavaIO;

import java.io.*;

/**
 * @author Acui
 * @date 2021年07月13日 10:59
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A(123, "abc");
        String objectFile = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\a1.txt";

        OutputStream out;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        File file;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }

    private static class A implements Serializable {
        private int x;
        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + " " + "y = " + y;
        }
    }

}
