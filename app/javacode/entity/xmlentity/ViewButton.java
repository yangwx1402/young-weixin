package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("viewbutton")
public class ViewButton extends XmlButton{
    @XStreamAsAttribute
    String type;
    @XStreamAsAttribute String url;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ViewButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}

