import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 序列化和反序列化的操作
 */
public class ExternalizableDemo {
    public static void main(String[] args) throws Exception {
        ser(); // 序列化
        dser(); // 反序列话
    }

    public static void ser() throws Exception {
        File file = new File("files" + File.separator + "ExternalizableDemo.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(new Person("rollen", 20));
        out.close();
    }

    public static void dser() throws Exception {
        File file = new File("files" + File.separator + "ExternalizableDemo.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Object obj = input.readObject();
        input.close();
        System.out.println(obj);
    }
}
/*
Externalizable接口
被Serializable接口声明的类的对象的属性都将被序列化，
但是如果想自定义序列化的内容的时候，就需要实现Externalizable接口。

当一个类要使用Externalizable这个接口的时候，这个类中必须要有一个无参的构造函数，
如果没有的话，在构造的时候会产生异常，这是因为在反序列话的时候会默认调用无参的构造函数。
*/
class Person implements Externalizable {
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "  年龄：" + age;
    }

    // 复写这个方法，根据需要可以保存的属性或者具体内容，在序列化的时候使用
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(age);
    }

    // 复写这个方法，根据需要读取内容 反序列话的时候需要
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }

    private String name;
    private int age;
}