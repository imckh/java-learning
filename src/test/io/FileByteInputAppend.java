import java.io.*;

public class FileByteInputAppend {
    public static void main(String[] args) throws Exception {
        String pathname = "files" + File.separator + "FileByteInput.txt";
        File f = new File(pathname);

        OutputStream out = new FileOutputStream(f, true);

        String s = "还很好喝还很哈哈哈哈哈";

        byte[] b = s.getBytes();
        out.write(b);
        out.close();
    }
}