package javacode.util.javacode;

import javacode.entity.jsonentity.*;
import javacode.entity.xmlentity.*;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/3/4.
 */
public class AssembleMenu {
    /**
     * 一级菜单
     */
    public static List<ClickButton> clickButtons;
    public static List<ViewButton> viewButtons;
    public static List<ComplexButton> complexButtons;

    /**
     * 二级菜单
     */
    public static List<ClickButton> sub_ClickButtons;
    public static List<ViewButton> sub_ViewButtons;

    public static Menu getMenu(MenuEntity menuEntity) {
        Menu menu=null;
        if(menuEntity!=null){
            clickButtons=menuEntity.getClickbuttons().getClickbuttons();
            viewButtons=menuEntity.getViewbuttons().getViewbutton();
            complexButtons=menuEntity.getComplexbuttons().getComplexbuttons();
            //合并菜单集合并对一级菜单排序
            List<XmlButton> xmlButtons=getXmlButton();
            //获得菜单Menu对象
            menu=createMenu(xmlButtons);
        }
        return menu;
    }
    private static Menu createMenu(List<XmlButton> xmlButtons) {
        Menu menu=null;
        if(!CollectionUtils.isEmpty(xmlButtons)){
            menu=new Menu();
            List<Button> buttons=new ArrayList<Button>();
            for(XmlButton xmlButton:xmlButtons){
                if(xmlButton instanceof ClickButton) {
                    JsonClickButton jsonClickButton = getJsonClickButton(xmlButton);
                    buttons.add(jsonClickButton);
                }else if(xmlButton instanceof ViewButton){
                    JsonViewButton jsonViewButton=getJsonViewButton(xmlButton);
                    buttons.add(jsonViewButton);
                }else if(xmlButton instanceof ComplexButton){
                    JsonComplexButton jsonComplexButton=getJsonComplexButton(xmlButton);
                    buttons.add(jsonComplexButton);
                }
            }
            menu.setButton(buttons);
        }
        return menu;
    }
    private static JsonComplexButton getJsonComplexButton(XmlButton xmlButton) {
        ComplexButton complexButton=(ComplexButton)xmlButton;
        JsonComplexButton jsonComplexButton=new JsonComplexButton();

        jsonComplexButton.setName(complexButton.getName());
        sub_ClickButtons=complexButton.getClickbuttons().getClickbuttons();
        sub_ViewButtons=complexButton.getViewbuttons().getViewbutton();
        //合并二级菜单并排序
        List<XmlButton> subXmlButtons=getSubXmlButtons();
        if (!CollectionUtils.isEmpty(subXmlButtons)){
            List<Button> sub_buttons=new ArrayList<Button>();
            for(XmlButton subXmlButton:subXmlButtons){
                if(subXmlButton instanceof ClickButton){
                    JsonClickButton jsonClickButton = getJsonClickButton(subXmlButton);
                    sub_buttons.add(jsonClickButton);
                }else if(subXmlButton instanceof ViewButton){
                    JsonViewButton jsonViewButton=getJsonViewButton(subXmlButton);
                    sub_buttons.add(jsonViewButton);
                }
            }
            jsonComplexButton.setSub_button(sub_buttons);
        }
        return jsonComplexButton;
    }
    private static List<XmlButton> getSubXmlButtons() {
        List<XmlButton> subXmlButtons=new ArrayList<XmlButton>();
        if(!CollectionUtils.isEmpty(sub_ClickButtons)){
            for(ClickButton clickButton:sub_ClickButtons)
                subXmlButtons.add(clickButton);
        }
        if(!CollectionUtils.isEmpty(sub_ViewButtons)){
            for (ViewButton viewButton:sub_ViewButtons)
                subXmlButtons.add(viewButton);
        }
        //为二级菜单排序
        sort(subXmlButtons);
        return subXmlButtons;
    }
    private static JsonViewButton getJsonViewButton(XmlButton xmlButton) {
        ViewButton viewButton=(ViewButton)xmlButton;
        JsonViewButton jsonViewButton=new JsonViewButton();
        jsonViewButton.setName(viewButton.getName());
        jsonViewButton.setType(viewButton.getType());
        jsonViewButton.setUrl(viewButton.getUrl());
        return jsonViewButton;
    }

    private static JsonClickButton getJsonClickButton(XmlButton xmlButton) {
        ClickButton clickButton=(ClickButton)xmlButton;
        JsonClickButton jsonClickButton=new JsonClickButton();
        jsonClickButton.setName(clickButton.getName());
        jsonClickButton.setType(clickButton.getType());
        jsonClickButton.setKey(clickButton.getKey());
        return jsonClickButton;
    }

    private static void sort(List<XmlButton> xmlButtons) {
        if(!CollectionUtils.isEmpty(xmlButtons))
            Collections.sort(xmlButtons);
    }
    private static List<XmlButton> getXmlButton() {
        List<XmlButton> xmlButtons=new ArrayList<XmlButton>();
        if(!CollectionUtils.isEmpty(clickButtons)){
            for (ClickButton clickButton:clickButtons)
                xmlButtons.add(clickButton);
        }
        if(!CollectionUtils.isEmpty(viewButtons)){
            for(ViewButton viewButton:viewButtons)
                xmlButtons.add(viewButton);
        }
        if(!CollectionUtils.isEmpty(complexButtons)){
            for(ComplexButton complexButton:complexButtons)
                xmlButtons.add(complexButton);
        }
        sort(xmlButtons);//对一级菜单排序
        return xmlButtons;
    }
}
