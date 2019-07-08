package thinkinjava.io;

import java.io.*;

public class BasicFileOutput {
    static String file = "src/temp/README.md";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(file)));

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();

        // 显示文件
        System.out.println(BufferedInputFile.read(file));
    }
}
