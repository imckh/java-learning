# 使用jdk中的工具实现object和xml之间的互转

JDK中JAXB相关的重要Class和Interface：

- JAXBContext类，是应用的入口，用于管理XML/Java绑定信息。
- Marshaller接口，将Java对象序列化为XML数据。
- Unmarshaller接口，将XML数据反序列化为Java对象。

JDK中JAXB相关的重要Annotation：

- @XmlType，将Java类或枚举类型映射到XML模式类型
- @XmlAccessorType(XmlAccessType.FIELD) ，控制字段或属性的序列化。FIELD表示JAXB将自动绑定Java类中的每个非静态的（static）、非瞬态的（由@XmlTransient标注）字段到XML。其他值还有XmlAccessType.PROPERTY和XmlAccessType.NONE。
- @XmlAccessorOrder，控制JAXB 绑定类中属性和字段的排序。
- @XmlJavaTypeAdapter，使用定制的适配器（即扩展抽象类XmlAdapter并覆盖marshal()和unmarshal()方法），以序列化Java类为XML。
- @XmlElementWrapper ，对于数组或集合（即包含多个元素的成员变量），生成一个包装该数组或集合的XML元素（称为包装器）。
- @XmlRootElement，将Java类或枚举类型映射到XML元素。
- @XmlElement，将Java类的一个属性映射到与属性同名的一个XML元素。
- @XmlAttribute，将Java类的一个属性映射到与属性同名的一个XML属性。

[javax.xml.bind.annotation 的分层结构](https://aisia.moe/java6api-cn/javax/xml/bind/annotation/package-tree.html)

## 工具类

```java
import java.io.*;
import javax.xml.bind.*;
 
/**
 * 封装了XML转换成object，object转换成XML的代码
 */
public class XMLUtil {
	/**
	 * 将对象直接转换成String类型的 XML输出
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
 
			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
 
	/**
	 * 将对象根据路径转换成xml文件
	 * 
	 * @param obj
	 * @param path
	 * @return
	 */
	public static void convertToXml(Object obj, String path) {
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
 
			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			// 创建输出流
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			marshaller.marshal(obj, fw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * 将String类型的xml转换成对象
	 */
	public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
		Object xmlObject = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			// 进行将Xml转成对象的核心接口
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader sr = new StringReader(xmlStr);
			xmlObject = unmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlObject;
	}
 
	/**
	 * 将file类型的xml转换成对象
	 */
	public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
		Object xmlObject = null;
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileReader fr = null;
			try {
				fr = new FileReader(xmlPath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			xmlObject = unmarshaller.unmarshal(fr);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlObject;
	}
}

// timestamp 适配器
public class TimestampAdapter extends XmlAdapter<String, Timestamp>{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Timestamp v) throws Exception {
        return dateFormat.format(new Date(v.getTime()));
    }

    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return Timestamp.valueOf(v);
    }
}
```

## 实体类

```java
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "search")
@XmlType(propOrder = { "patient_id", "org_code", "purchase_date_from", "purchase_date_to" })
public class MemberQueryInputView extends BaseView {
    public MemberQueryInputView() {}
    public MemberQueryInputView(BigDecimal patient_id, String org_code, Timestamp purchase_date_from, Timestamp purchase_date_to) {
        super();
        this.patient_id = patient_id;
        this.org_code = org_code;
        this.purchase_date_from = purchase_date_from;
        this.purchase_date_to = purchase_date_to;
    }
    private BigDecimal patient_id;
    private String org_code;
    // date/calendar不需要自定义适配器, timestamp需要自定义适配器
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp purchase_date_from;
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp purchase_date_to;
    public BigDecimal getPatient_id() {
        return patient_id;
    }
    public String getOrg_code() {
        return org_code;
    }
    public Timestamp getPurchase_date_from() {
        return purchase_date_from;
    }
    public Timestamp getPurchase_date_to() {
        return purchase_date_to;
    }
    public void setPatient_id(BigDecimal patient_id) {
        this.patient_id = patient_id;
    }
    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }
    public void setPurchase_date_from(Timestamp purchase_date_from) {
        this.purchase_date_from = purchase_date_from;
    }
    public void setPurchase_date_to(Timestamp purchase_date_to) {
        this.purchase_date_to = purchase_date_to;
    }
    @Override
    public String toString() {
        return "MemberQueryInputView [patient_id=" + patient_id + ", org_code=" + org_code + ", purchase_date_from=" + purchase_date_from
                + ", purchase_date_to=" + purchase_date_to + "]";
    }
}
```