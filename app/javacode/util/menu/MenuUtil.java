package javacode.util.menu;

import javacode.entity.Result;
import javacode.entity.jsonentity.Menu;
import javacode.util.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zhanglt on 2016/3/4.
 */
public class MenuUtil {
    private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

    // 菜单创建（POST）
    public final static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 菜单查询（GET）
    public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 菜单删除（GET）
    public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @param accessToken 凭证
     * @return true成功 false失败
     */
    public static boolean createMenu(Menu menu, String accessToken) {
        boolean result = false;
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        try{
            String jsonMenu = JsonUtils.toJson(menu);
            System.out.println(jsonMenu);
            //JSONObject.fromObject(menu).toString();
            // 发起POST请求创建菜单
            String resultJson = CommonUtil.httpsRequest(url, "POST", jsonMenu);
            System.out.println(resultJson);
            if (null != resultJson) {
                Result result1=JsonUtils.getObject(resultJson,Result.class);
                int errorCode = result1.getErrcode();
                String errorMsg = result1.getErrmsg();
                if (0 == errorCode) {
                    result = true;
                } else {
                    result = false;
                    log.error("创建菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            result = false;
            log.error("创建菜单失败");
        }
        return result;
    }

    /**
     * 查询菜单
     *
     * @param accessToken 凭证
     * @return
     */
    public static String getMenu(String accessToken) {
        String result = null;
        String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
        // 发起GET请求查询菜单
        String jsonMenu = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonMenu) {
            result = jsonMenu;
        }
        return result;
    }

    /**
     * 删除菜单
     *
     * @param accessToken 凭证
     * @return true成功 false失败
     */
    public static boolean deleteMenu(String accessToken) {
        boolean result = false;
        String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
        // 发起GET请求删除菜单
        String resultJson = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != resultJson) {
            try{
                Result result1=JsonUtils.getObject(resultJson,Result.class);
                int errorCode = result1.getErrcode();
                String errorMsg = result1.getErrmsg();
                if (0 == errorCode) {
                    result = true;
                } else {
                    result = false;
                    log.error("删除菜单失败 errcode:{} errmsg:{}", errorCode, errorMsg);
                }
            }catch (Exception e){
                e.printStackTrace();
                result = false;
                log.error("删除菜单失败 resultJson{}", resultJson);
            }
        }
        return result;
    }
}
