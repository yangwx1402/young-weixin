package javacode.entity.jsonentity;

import java.util.List;

/**
 * 复合类型按钮
 * Created by Administrator on 2016/3/4.
 */
public class JsonComplexButton extends Button{
    private List<Button> sub_button;

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
