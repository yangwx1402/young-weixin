package javacode.entity.xmlentity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
@XStreamAlias("clickbuttons")
public class ClickButtons {
        @XStreamImplicit
        List<ClickButton> clickbuttons=new ArrayList<ClickButton>();

        public List<ClickButton> getClickbuttons() {
            return clickbuttons;
        }

        public void setClickbuttons(List<ClickButton> clickbuttons) {
            this.clickbuttons = clickbuttons;
        }
}
