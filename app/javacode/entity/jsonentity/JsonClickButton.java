package javacode.entity.jsonentity;

/**
 * click类型的按钮
 * Created by Administrator on 2016/3/4.
 */
public class JsonClickButton extends Button{
    private String type;
    private String key;

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
}
