package javacode.util.xml;

import javacode.util.clazz.ClassUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/2/20.
 */
public class JdomUtils {

    private SAXBuilder dom;

    public JdomUtils() {
        dom = new SAXBuilder();
    }

    public Element getRootElement(InputStream input) throws JDOMException, IOException {
        Document doc = dom.build(input);
        Element root = doc.getRootElement();
        return root;
    }

    public Element getRootElement(Reader reader) throws JDOMException, IOException {
        Document doc = dom.build(reader);
        return doc.getRootElement();
    }

    public String selectField(Element root, String fieldName) throws JDOMException, IOException {
        return root.getChild(fieldName).getTextTrim();
    }

    public <T> T selectFields(Element root, Class<T> clazz) throws JDOMException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T t = clazz.newInstance();
        Field[] fields = null;
        Class parent = clazz.getSuperclass();
        if(parent!=null){
            fields = parent.getDeclaredFields();
            t = wrapObject(root,fields,clazz,t);
        }
        fields = clazz.getDeclaredFields();
        t = wrapObject(root,fields,clazz,t);
        return t;
    }

    private <T> T wrapObject(Element root,Field[] fields, Class<T> clazz, T t) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = null;
        Element temp = null;
        for (Field field : fields) {
            temp = root.getChild(field.getName());
            if (temp != null) {
                method = ClassUtils.getMethod(setMethodName(field.getName()), clazz, String.class);
                method.invoke(t, temp.getTextTrim());
            }
        }
        return t;
    }


    private String setMethodName(String field) {
        return "set" + field.substring(0, 1).toUpperCase() + field.substring(1, field.length());
    }
}
