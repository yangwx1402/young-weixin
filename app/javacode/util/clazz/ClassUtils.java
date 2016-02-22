package javacode.util.clazz;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/2/20.
 */
public class ClassUtils {
    public static Method getMethod(String methodName,Class clazz,Class... parameterClass) throws NoSuchMethodException {
        return clazz.getMethod(methodName,parameterClass);
    }
}
