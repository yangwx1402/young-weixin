package javacode.util.xml;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class XStreamUtils {

    private XStream stream;

    public XStreamUtils(Class[] classes){
        stream = new XStream();
        stream.autodetectAnnotations(true);
        stream.processAnnotations(classes);
    }

    public String toXml(Object obj){
       return stream.toXML(obj);
    }

    public <T> T fromXmlString(String xml,Class<T> clazz){
        return (T) stream.fromXML(xml);
    }
    
    public <T> T fromXmlStream(InputStream input,Class<T> clazz) throws IOException{
    	return fromXmlString(IOUtils.toString(input, "utf-8"),clazz);
    }
}
