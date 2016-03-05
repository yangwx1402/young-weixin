package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import scala.beans.BeanProperty;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("menu")
public class MenuEntity {
    @XStreamAlias("clickbuttons") ClickButtons clickbuttons;
    @XStreamAlias("viewbuttons") ViewButtons viewbuttons;
    @XStreamAlias("complexbuttons") ComplexButtons complexbuttons;

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

    public ComplexButtons getComplexbuttons() {
        return complexbuttons;
    }

    public void setComplexbuttons(ComplexButtons complexbuttons) {
        this.complexbuttons = complexbuttons;
    }
}
