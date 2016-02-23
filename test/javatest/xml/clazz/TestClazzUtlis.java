package javatest.xml.clazz;

import javacode.util.xml.JdomUtils;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import scalacode.entity.SubscribeEvent;
import scalacode.entity.WeixinEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2016/2/20.
 */
public class TestClazzUtlis {
    public static void main(String[] args) throws IOException, JDOMException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JdomUtils jdom = new JdomUtils();
        FileInputStream input = new FileInputStream("E:\\data\\scribe_event.xml");
        Element root = jdom.getRootElement(input);
        System.out.println(jdom.selectField(root, "Event"));
        SubscribeEvent event = jdom.selectFields(root, SubscribeEvent.class);
        System.out.println(event.getFromUserName());
     }
}
