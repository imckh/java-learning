package designpattern.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class XMLUtil {
    public static final File CONFIG_FILE = new File("src\\designpattern\\util\\config.xml");

    /**
     * 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
     * @param TagName 标签名
     * @return
     */
    public static Object getBean(String TagName) {
        try {
            String cName = getTagValue(TagName);

            return newInstance(cName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回相应的标签名里的内容
     * @param TagName 标签名
     * @return 标签名里的内容
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static String getTagValue(String TagName) throws ParserConfigurationException, SAXException, IOException {
        //创建文档对象
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document doc;
        doc = builder.parse(CONFIG_FILE);
        //获取包含类名的文本节点
        // doc.getDocumentElement().getElementsByTagName("className").item(0).getFirstChild().getNodeValue()
        NodeList nl = doc.getElementsByTagName(TagName);
        Node classNode = nl.item(0).getFirstChild();
        return classNode.getNodeValue();
    }

    /**
     * 通过类名生成实例对象并将其返回
     * @param className 完整的类名
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static Object newInstance(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //
        Class c = Class.forName(className);
        Object obj = c.getDeclaredConstructor().newInstance();
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(XMLUtil.getTagValue("className"));
        System.out.println(XMLUtil.getTagValue("className2"));
        System.out.println(XMLUtil.getTagValue("className3"));
    }
}
