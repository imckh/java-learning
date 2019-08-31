import java.io.File;

public class ListFIleRecursivly {
    public static void main(String[] args) {
        String pathname = "F:" + File.separator + "Java" + File.separator + "java-learning" + File.separator + "src";

        File f = new File(pathname);
        print(f);
    }

    private static void print(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fs = f.listFiles();
                if (fs != null) {
                    for (File children : fs) {
                        print(children);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }
}