package com.learn.mmp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.learn.mmp.notice.model.NoticeConfBean;


/**
 * 配置文件工具类
 * @author liuwenkang
 *
 */
public class PropUtil {

    /**
     * 将配置信息读取到对于的 配置bean 中
     * 
     * return需要强制类型转换 (bean)PropUtil.getProp(url,class)
     * 当bean中仅有一下元素时可使用：String,List<String>,boolean(值为false/true)
     * 
     * @param url 配置文件路径
     * @param c object.class
     * @param charSet 配置文件的编码类型
     * @return 含有配置信息的object对象
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    public static Object getProp(String url,Class c,String charset)
            throws UnsupportedEncodingException, IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {

        //加载配置文件
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(url);
        prop.load(new InputStreamReader(fis, charset));
        Object obj = c.newInstance();//实例化对象
        String fieldName;// 变量名
        StringBuffer getMethodName; // 方法名
        Class valueClass = null;// 变量类型
        Field[] fs = c.getDeclaredFields();//获得对象所有变量
        for (Field field : fs) {//遍历所有成员变量，对有set方法的变量赋值
            fieldName = field.getName();//变量名
            Method getMethod = null;//get方法
            // 拼接set方法名
            getMethodName = new StringBuffer("set");
            getMethodName.append(fieldName.substring(0, 1).toUpperCase());
            getMethodName.append(fieldName.substring(1));

             //System.out.println("sb:"+getMethodName);
             //System.out.println(field.getType().toString());
            
            try {
                //获得变量类型
                valueClass = field.getType();
                // 获取set方法
                getMethod = c.getDeclaredMethod(getMethodName.toString(), valueClass);
            } catch (NoSuchMethodException e) {//找不到set方法则跳过
                //System.out.println("noSuchMethod:" + getMethodName + "\n============");
                continue;
            }

            //System.out.println("realMethod:" + getMethod.getName() + "\n============");
            if  (valueClass==String.class) {//为String类型赋值
                getMethod.invoke(obj, prop.getProperty(fieldName));// 执行set方法
            }
            if(valueClass==List.class) {//为List类型赋值         ps.list<String>
                List<String> list = null;
                try {//配置文件中取不到时，list 为 null
                    String[] values =  prop.getProperty(fieldName).split(",");
                    list = Arrays.asList(values);
                }catch (java.lang.NullPointerException e) {
                }
                getMethod.invoke(obj, list);// 执行set方法
            }
            if(valueClass==boolean.class) {//为boolean类型赋值
                getMethod.invoke(obj, setBooleanValue(prop.getProperty(fieldName)));// 执行set方法
            }
            
            
        }
        //System.out.println(bean.toString());
        //System.out.println(new NoticeConfBean().toString());
        return obj;

    }

    /**
     * 从string获得boolean值
     * @param value 
     * @return true返回true；false/null 返回 false
     */
    private static boolean setBooleanValue(String value) {
        boolean result = false;
        if (value != null) {
            result = ("true".equals(value.toLowerCase())) ? true : false;
        }
        return result;
    }



 
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        NoticeConfBean bean = (NoticeConfBean)PropUtil.getProp("C:/Users/liuwenkang/git/NewLearnPrj/NewLearnPrj/resource/mmp/notice.properties"
               , NoticeConfBean.class,"utf-8");
        System.out.println(bean);
    }
}
