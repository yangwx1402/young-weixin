package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Created by Administrator on 2016/3/3.
 */
public class XmlButton implements Comparable{
    @XStreamAsAttribute
    float order;
    @XStreamAsAttribute
    String name;

    public float getOrder() {
        return order;
    }

    public void setOrder(float order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        float result=this.getOrder()-((XmlButton)o).getOrder();
        if(result>0)
            return 1;
        else if(result==0)
            return 0;
        else
            return -1;
    }
}
