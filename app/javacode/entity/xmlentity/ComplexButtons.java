package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("complexbuttons")
public class ComplexButtons{
    @XStreamImplicit
    List<ComplexButton> complexbuttons=new ArrayList<ComplexButton>();

    public List<ComplexButton> getComplexbuttons() {
        return complexbuttons;
    }

    public void setComplexbuttons(List<ComplexButton> complexbuttons) {
        this.complexbuttons = complexbuttons;
    }
}
