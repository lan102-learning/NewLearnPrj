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
 * �����ļ�������
 * @author liuwenkang
 *
 */
public class PropUtil {

    /**
     * ��������Ϣ��ȡ�����ڵ� ����bean ��
     * 
     * return��Ҫǿ������ת�� (bean)PropUtil.getProp(url,class)
     * ��bean�н���һ��Ԫ��ʱ��ʹ�ã�String,List<String>,boolean(ֵΪfalse/true)
     * 
     * @param url �����ļ�·��
     * @param c object.class
     * @param charSet �����ļ��ı�������
     * @return ����������Ϣ��object����
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

        //���������ļ�
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(url);
        prop.load(new InputStreamReader(fis, charset));
        Object obj = c.newInstance();//ʵ��������
        String fieldName;// ������
        StringBuffer getMethodName; // ������
        Class valueClass = null;// ��������
        Field[] fs = c.getDeclaredFields();//��ö������б���
        for (Field field : fs) {//�������г�Ա����������set�����ı�����ֵ
            fieldName = field.getName();//������
            Method getMethod = null;//get����
            // ƴ��set������
            getMethodName = new StringBuffer("set");
            getMethodName.append(fieldName.substring(0, 1).toUpperCase());
            getMethodName.append(fieldName.substring(1));

             //System.out.println("sb:"+getMethodName);
             //System.out.println(field.getType().toString());
            
            try {
                //��ñ�������
                valueClass = field.getType();
                // ��ȡset����
                getMethod = c.getDeclaredMethod(getMethodName.toString(), valueClass);
            } catch (NoSuchMethodException e) {//�Ҳ���set����������
                //System.out.println("noSuchMethod:" + getMethodName + "\n============");
                continue;
            }

            //System.out.println("realMethod:" + getMethod.getName() + "\n============");
            if  (valueClass==String.class) {//ΪString���͸�ֵ
                getMethod.invoke(obj, prop.getProperty(fieldName));// ִ��set����
            }
            if(valueClass==List.class) {//ΪList���͸�ֵ         ps.list<String>
                List<String> list = null;
                try {//�����ļ���ȡ����ʱ��list Ϊ null
                    String[] values =  prop.getProperty(fieldName).split(",");
                    list = Arrays.asList(values);
                }catch (java.lang.NullPointerException e) {
                }
                getMethod.invoke(obj, list);// ִ��set����
            }
            if(valueClass==boolean.class) {//Ϊboolean���͸�ֵ
                getMethod.invoke(obj, setBooleanValue(prop.getProperty(fieldName)));// ִ��set����
            }
            
            
        }
        //System.out.println(bean.toString());
        //System.out.println(new NoticeConfBean().toString());
        return obj;

    }

    /**
     * ��string���booleanֵ
     * @param value 
     * @return true����true��false/null ���� false
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
