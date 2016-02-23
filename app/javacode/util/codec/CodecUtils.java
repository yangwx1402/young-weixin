package javacode.util.codec;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Administrator on 2016/2/22.
 */
public class CodecUtils {
    public static String SHA1Encode(String string){
        return DigestUtils.sha1Hex(string);
    }
    public static void main(String[] args){
       System.out.println(CodecUtils.SHA1Encode("yangyong"));
    }
}
