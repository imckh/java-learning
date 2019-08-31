import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FIleRandomeAccessFile {
    public static void main(String[] args) throws IOException {
        String pathname = "files" + File.separator + "FIleRandomeAccessFile.txt";

        File f = new File(pathname);

        // 使用RandomAccessFile写入文件
        // 如果你此时打开hello.txt查看的话， 会发现那是乱码
        RandomAccessFile r = new RandomAccessFile(f, "rw");

        r.writeBytes("dwadwadassgbers");
        r.writeInt(321);
        r.writeBoolean(false);
        r.writeChar('v');
        r.writeDouble(432.432);
        r.writeFloat(432.4f);
        r.close();
    }
}