import java.io.*;

public class WriteFileWriter {
    public static void main(String[] args) throws Exception {
        String pathname = "files" + File.separator + "WriteFileWriter.txt";
        File f = new File(pathname);

        Writer out = new FileWriter(f);

        out.write("hello");
        out.close();
    }
}