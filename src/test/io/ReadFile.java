import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws Exception {
        String pathname = "files" + File.separator + "FileByteInput.txt";
        File f = new File(pathname);

        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];

        int len = in.read(b);
        in.close();
        // 但是这个例子读取出来会有大量的空格，我们可以利用in.read(b);的返回值来设计程序。如下：
        System.out.println(new String(b));

        System.out.println("---------");
        
        System.out.println("读入长度为：" + len);
        System.out.println(new String(b, 0, len));

        System.out.println("---------");
        read2(f);
        System.out.println("---------");
        read3(f);
    }

    public static void read2(File f) throws Exception {
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));
    }

    // 上面的几个例子都是在知道文件的内容多大，然后才展开的，有时候我们不知道文件有多大，这种情况下，我们需要判断是否独到文件的末尾。
    public static void read3(File f) throws Exception {
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        while ((temp = in.read()) != (-1)) { // 当独到文件末尾的时候会返回-1.正常情况下是不会返回-1的
            b[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(b));
    }
}