import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化一组对象
 */
public class SerializableDemo {
    public static void main(String[] args) throws Exception {
        Student[] stu = { new Student("hello", 20), new Student("world", 30), new Student("rollen", 40) };
        ser(stu);
        Object[] obj = dser();
        for (int i = 0; i < obj.length; ++i) {
            Student s = (Student) obj[i];
            System.out.println(s);
        }
    }
    /*
    关于序列化反序列化

    这里使用的两个 file output/input stream其实可以替换为使用内存操作流

    ByteArrayInputStream 主要将内容写入内容
    ByteArrayOutputStream  主要将内容从内存输出

    这样就可以实现对象的深复制
    */

    // 序列化
    public static void ser(Object[] obj) throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(obj);
        out.close();
    }

    // 反序列化
    public static Object[] dser() throws Exception {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Object[] obj = (Object[]) input.readObject();
        input.close();
        return obj;
    }
}

class Student implements Serializable {
    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：  " + name + "  年龄：" + age;
    }

    private String name;
    private int age;
}