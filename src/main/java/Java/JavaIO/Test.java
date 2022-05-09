package Java.JavaIO;

import java.io.*;

/**
 * @author Acui
 * @date 2021年07月13日 10:25
 */
public class Test {
    public static void listAllFiles(File dir) {
        if (dir == null || !dir.exists()) return ;
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles())
            listAllFiles(file);
    }

    public static void copyFile(String src, String dist) throws IOException {
        File file;
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        while ((cnt = in.read(buffer, 0, buffer.length)) != -1) {
            out.write(buffer, 0, cnt);
        }
        in.close();
        out.close();
    }

    public static void readFileContent(String filePath) throws IOException {
        File file;
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
//        listAllFiles(new File("D:\\Users\\Acui\\Documents\\英语家教\\高考英语总复习 基础版和提高版 讲解+解析"));
//        String src = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\forCopy.txt";
//        String dist = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\forCopy1.txt";
//        try {
//            copyFile(src, dist);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String str1 = "中文";
////        byte[] bytes = str1.getBytes("UTF-8");
//        byte[] bytes = str1.getBytes();
//        String str2 = new String(bytes, "UTF-8");
//        System.out.println(str2);


        String src = "D:\\workspace\\vscode\\leetcode\\src\\Java\\JavaIO\\forCopy.txt";
        readFileContent(src);
    }
}
