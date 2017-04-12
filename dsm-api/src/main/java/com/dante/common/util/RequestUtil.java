package com.dante.common.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.BeansException;

import com.alibaba.fastjson.JSONObject;

public class RequestUtil {

	/**
	 * ConvertUtilsBean convertUtils = new ConvertUtilsBean(); DateConverter
	 * dateConverter = new DateConverter();
	 * convertUtils.register(dateConverter,Date.class);
	 */

	@SuppressWarnings("rawtypes")
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
			T bean = beanClass.newInstance(); // 实例化随意类型
			Enumeration en = request.getParameterNames(); // 获得参数的一个列举
			while (en.hasMoreElements()) { // 遍历列举来获取所有的参数
				String name = (String) en.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value); // 注意这里导入的是 import org.apache.commons.beanutils.BeanUtils;
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e); // 如果错误 则向上抛运行时异常
		}
	}
	
	public static <T>List<T> convertBase64String2List(HttpServletRequest request, Class<T> beanClass,String propertyName){
		String string = request.getParameter(propertyName);
		try {
			String paramOutListJson = new String(Base64.decodeBase64(string),"utf-8");
			List<T> list = JSONObject.parseArray(paramOutListJson,beanClass);
			return list;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * @param <T>
	 * @param newSource
	 * @param source
	 */
	public static <T> void beanConvert(T newSource, T source) {
		try {
			BeanUtils.copyProperties(newSource, source);
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param obj
	 *            Bean.class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T requestToBean(HttpServletRequest request, Class<T> clazz) {

		Enumeration<String> enume = request.getParameterNames();
		T beanObj = getObjectByClass(clazz);
		try {
			while (enume.hasMoreElements()) {
				String propertyName = enume.nextElement();
				if (isCheckBeanExitsPropertyName(clazz, propertyName)) {
					Object propertyValue = request.getParameter(propertyName);
					setProperties(beanObj, propertyName, propertyValue);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return beanObj;
	}

	private static <T> T getObjectByClass(Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return t;
	}

	/**
	 * @param clazz
	 *            Class
	 * @param propertyName
	 * @return true || false
	 */
	private static boolean isCheckBeanExitsPropertyName(Class<?> clazz, String propertyName) {
		boolean retValue = false;
		try {
			Field field = clazz.getDeclaredField(propertyName);
			if (null != field) {
				retValue = true;
			}
		} catch (NoSuchFieldException e) {
			System.out.println("Class : " + clazz.getSimpleName() + ",Property : " + propertyName
					+ "  is not found.The message is : " + e.getMessage());
		}
		return retValue;

	}

	/**
	 * �����ֶ�ֵ
	 * 
	 * @param obj
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public static void setProperties(Object object, String propertyName, Object value)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, object.getClass());
		Method methodSet = pd.getWriteMethod();
		methodSet.invoke(object, value);
	}

	/**
	 * request Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getParameterMap(HttpServletRequest request) {
		Map<?, ?> properties = request.getParameterMap();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<?> entries = properties.entrySet().iterator();
		Entry<?, ?> entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Entry<?, ?>) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}
}