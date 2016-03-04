package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("clickbutton")
public class ClickButton extends XmlButton{
    @XStreamAsAttribute
    String type;
    @XStreamAsAttribute
    String key;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ClickButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}