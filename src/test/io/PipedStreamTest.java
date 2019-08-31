import java.io.*;
/**
管道流
管道流主要可以进行两个线程之间的通信。

PipedOutputStream 管道输出流

PipedInputStream 管道输入流
 */
public class PipedStreamTest {
    public static void main(String[] args) throws IOException {
        Send send = new Send();
        Receiver receiver = new Receiver();

        // 管道连接
        send.getOut().connect(receiver.getIn());

        new Thread(send).start();
        new Thread(receiver).start();
    }
}

// 消息发送类
class Send implements Runnable {
    // 如果你已经有一个资源是 final 或等效于 final 变量,
    // 可以在 try-with-resources 语句中使用该变量，而无需在 try-with-resources 语句中声明一个新变量。
    private final PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    @Override
    public void run() {
        String message = "hello, hello";
        
        // // Original try-with-resources statement from JDK 7 or 8
        // try (PipedOutputStream out1 = out) {

        try (out) {
            out.write(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 消息接收者
class Receiver implements Runnable {
    private final PipedInputStream in = new PipedInputStream();

    public PipedInputStream getIn() {
        return in;
    }

    @Override
    public void run() {
        byte[] b = new byte[1024];
        int len = 0;

        try (in) {
            len = this.in.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("received: " + new String(b, 0, len));
    }
}