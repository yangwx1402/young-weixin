package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("complexbutton")
public class ComplexButton extends XmlButton{
    @XStreamAlias("clickbuttons")
    ClickButtons clickbuttons;
    @XStreamAlias("viewbuttons")
    ViewButtons viewbuttons;

    public ClickButtons getClickbuttons() {
        return clickbuttons;
    }

    public void setClickbuttons(ClickButtons clickbuttons) {
        this.clickbuttons = clickbuttons;
    }

    public ViewButtons getViewbuttons() {
        return viewbuttons;
    }

    public void setViewbuttons(ViewButtons viewbuttons) {
        this.viewbuttons = viewbuttons;
    }
}

