package com.learn.mmp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.learn.mmp.notice.model.NoticeConfBean;


/**
 * �����ļ�������
 * @author liuwenkang
 *
 */
public class PropUtilTest {
    private static final String url = "C:/Users/liuwenkang/git/NewLearnPrj/NewLearnPrj/resource/mmp/notice.properties";

    public static Object getProp(String url,Class c)
            throws UnsupportedEncodingException, IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(url);
        prop.load(fis);
        Object obj = c.newInstance();
        Field[] fs = c.getDeclaredFields();
        String fieldName;// ������
        StringBuffer getMethodName; // ������
        Class valueClass = null;// ��������
        for (Field field : fs) {
            fieldName = field.getName();
            Method getMethod = null;
            // ƴ��set������
            getMethodName = new StringBuffer("set");
            getMethodName.append(fieldName.substring(0, 1).toUpperCase());
            getMethodName.append(fieldName.substring(1));

             //System.out.println("sb:"+getMethodName);
             //System.out.println(field.getType().toString());
            
            try {
                // ��ȡset����
                valueClass = field.getType();
                getMethod = c.getDeclaredMethod(getMethodName.toString(), valueClass);
            } catch (NoSuchMethodException e) {
                //System.out.println("noSuchMethod:" + getMethodName + "\n============");
                continue;
            }

            //System.out.println("realMethod:" + getMethod.getName() + "\n============");
            if  (valueClass==String.class) {
                getMethod.invoke(obj, prop.getProperty(fieldName));// ִ��set����
            }
            if(valueClass==List.class) {
                String[] values =  prop.getProperty(fieldName).split(",");
                List<String> list = Arrays.asList(values);
                getMethod.invoke(obj, list);// ִ��set����
            }
            if(valueClass==boolean.class) {
                getMethod.invoke(obj, setBooleanValue(prop.getProperty(fieldName)));// ִ��set����
            }
            
            
        }
        //System.out.println(bean.toString());
        //System.out.println(new NoticeConfBean().toString());
        return obj;

    }

    private static boolean setBooleanValue(String value) {
        boolean result = false;
        if (value != null) {
            result = ("true".equals(value.toLowerCase())) ? true : false;
        }
        return result;
    }


    public static void main1(String[] args)
            throws UnsupportedEncodingException, IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(url);
        prop.load(fis);
        // String receiveMail = prop.getProperty("receiveMail");
        Class c = NoticeConfBean.class;
        Object obj = c.newInstance();
        Field[] fs = c.getDeclaredFields();
        String fieldName;// ������
        StringBuffer getMethodName; // ������
        Class valueClass = null;// ��������
        NoticeConfBean bean = null;//���
        for (Field field : fs) {
            fieldName = field.getName();
            Method getMethod = null;
            // if(!"catchTimeList".equals(fieldName))continue;//
            // ƴ��set������
            getMethodName = new StringBuffer("set");
            getMethodName.append(fieldName.substring(0, 1).toUpperCase());
            getMethodName.append(fieldName.substring(1));

             System.out.println("sb:"+getMethodName);
             System.out.println(field.getType().toString());
            
            try {
                // ��ȡset����
                valueClass = field.getType();
                getMethod = c.getDeclaredMethod(getMethodName.toString(), valueClass);
                // ��� <T>����
                /*
                 * Type gType = field.getGenericType();
                 * System.out.println("---"+gType.toString()); ParameterizedType pType =
                 * (ParameterizedType)gType;
                 * System.out.println("---"+pType.getActualTypeArguments()[0]);
                 */
                //
            } catch (NoSuchMethodException e) {
                System.out.println("noSuchMethod:" + getMethodName + "\n============");
                continue;
            }

            System.out.println("realMethod:" + getMethod.getName() + "\n============");
            /*if (getMethod != null) {
                getMethod.invoke(obj, new String("url"));// ִ��set����
            } */
            if  (valueClass==String.class) {
                getMethod.invoke(obj, prop.getProperty(fieldName));// ִ��set����
            }
            if(valueClass==List.class) {
                String[] values =  prop.getProperty(fieldName).split(",");
                List<String> list = Arrays.asList(values);
                getMethod.invoke(obj, list);// ִ��set����
            }
            if(valueClass==boolean.class) {
                getMethod.invoke(obj, setBooleanValue(prop.getProperty(fieldName)));// ִ��set����
            }
        }
        bean = (NoticeConfBean)obj;
            System.out.println(bean.toString());
        //System.out.println(new NoticeConfBean().toString());
        // --------------------------------------
        /*
         * Class c = NoticeConfBean.class; Field[] fs = c.getDeclaredFields();
         * 
         * // ����ɱ䳤���ַ����������洢���� StringBuffer sb = new StringBuffer(); //
         * ͨ��׷�ӵķ�������ÿ������ƴ�ӵ����ַ����� // ����ߵ�public����
         * sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName()
         * + "{\n"); // ��ߵ�ÿһ������ for (Field field : fs) { sb.append("\t");// �ո�
         * sb.append(Modifier.toString(field.getModifiers()) + " ");//
         * ������Ե����η�������public��static�ȵ� sb.append(field.getType().getSimpleName() +
         * " ");// ���Ե����͵����� sb.append(field.getName() + ";\n");// ���Ե�����+�س� }
         * 
         * sb.append("}");
         * 
         * System.out.println(sb);
         * 
         * Method[] ms = c.getDeclaredMethod(); sb = new StringBuffer("Method List:");
         * for (Method method : ms) { sb.append("\n");
         * sb.append(Modifier.toString(method.getModifiers()));
         * sb.append(" "+method.getReturnType().getSimpleName()+" "+method.getName()+"("
         * ); Parameter[] paras = method.getParameters(); for (Parameter para : paras) {
         * sb.append(para.getType().getSimpleName()+" "); sb.append(para.getName()+",");
         * } if(sb.lastIndexOf(",")!=-1) sb.deleteCharAt(sb.lastIndexOf(","));
         * sb.append(")"); } System.out.println(sb);
         */

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        PropUtil util = new PropUtil();
        NoticeConfBean bean = (NoticeConfBean)util.getProp("C:/Users/liuwenkang/git/NewLearnPrj/NewLearnPrj/resource/mmp/notice.properties", NoticeConfBean.class, null);
        System.out.println(bean);
    }
}
