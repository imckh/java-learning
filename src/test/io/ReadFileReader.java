
import java.io.*;

public class ReadFileReader {
    public static void main(String[] args) throws Exception {
        String pathname = "files" + File.separator + "WriteFileWriter.txt";
        File f = new File(pathname);

        Writer out = new FileWriter(f);

        out.write("hello");
        out.close();
    }
    /*
    当你打开hello。txt的时候，会看到hello

其实这个例子上之前的例子没什么区别，只是你可以直接输入字符串，而不需要你将字符串转化为字节数组。

当你如果想问文件中追加内容的时候，可以使用将上面的声明out的哪一行换为：

Writer out =new FileWriter(f,true);

这样，当你运行程序的时候，会发现文件内容变为：

hellohello如果想在文件中换行的话，需要使用“\r\n”

比如将str变为String str="\r\nhello";

这样文件追加的str的内容就会换行了。

 
    */
}