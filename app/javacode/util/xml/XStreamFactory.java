package javacode.util.xml;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
public class XStreamFactory {

    private static Map<String, XStreamUtils> cache = new Hashtable<String, XStreamUtils>();

    public static XStreamUtils getInstance(Class[] classes) {
        XStreamUtils xml = null;
        String key = getKey(classes);
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            xml = new XStreamUtils(classes);
            cache.put(key, xml);
            return xml;
        }
    }

    private static <T> String getKey(Class[] classes) {
        String result = "";
        if (classes == null && classes.length == 0) {
            return "default";
        }
        for (Class clazz : classes) {
            result += clazz.getName() + "_";
        }
        return result;
    }
}
