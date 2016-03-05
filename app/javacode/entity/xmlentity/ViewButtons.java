package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("viewbuttons")
public class ViewButtons{
    @XStreamImplicit
    List<ViewButton> viewbutton=new ArrayList<ViewButton>();

    public List<ViewButton> getViewbutton() {
        return viewbutton;
    }

    public void setViewbutton(List<ViewButton> viewbutton) {
        this.viewbutton = viewbutton;
    }
}
