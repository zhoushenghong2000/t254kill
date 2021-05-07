package com.zking.killprovider.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

//import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {
	
	/**
	 * 返回基本json格式数据
	 * @param resp  响应
	 * @param b     操作是否成功
	 * @param msg   消息提醒
	 */
	public static void writeJsonMsg(HttpServletResponse resp,boolean b,String msg) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("success", b);
		map.put("msg", msg);
		try {
			objectMapper.writeValue(resp.getOutputStream(), map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	/**
	 * 返回json数据
	 * @param resp
	 * @param obj
	 * @param msg
	 * @param status
	 */
	public static void writeJsonData(HttpServletResponse resp,Object obj,String msg,String status) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("msg",msg);
		map2.put("status",status);
		map.put("message", obj);
		map.put("meta", map2);
		try {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			objectMapper.writeValue(resp.getOutputStream(), map);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 返回分页的json格式数据
	 * @param resp  响应
	 * @param b     操作是否成功
	 * @param msg   消息提醒
	 * @param data  分页查询返回的结果集
	 * @param total 总记录数
	 */
	public static void writePageJsonMsg(HttpServletResponse resp,boolean b,String msg,Object data,int total) {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("success", b);
		map.put("msg", msg);
		map.put("rows", data);//千年老坑  一部留神就给了data
		map.put("total", total);
		try {
			objectMapper.writeValue(resp.getOutputStream(), map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	
	/**
	 * 根据ResultSet数据集，利用反射机制动态赋值并返回List<T>
	 * @param rs ResultSet数据集
	 * @param clazz 实体类对象
	 * @return 返回List实体集合
	 * @throws Exception
	 */
	public static <T> List<T> toList(ResultSet rs,Class<T> clazz){
		try {
			//定义实体集合
			List<T> lst=new ArrayList<T>();
			//获取ResultSet的metadata列信息
			ResultSetMetaData metaData = rs.getMetaData();
			//获取对象属性集合
			Field[] fields=clazz.getDeclaredFields();
			//循环ResultSet
			while(rs.next()) {
				//反射机制实例化
				T obj = clazz.newInstance();
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					//获取列名
					String columnName=metaData.getColumnLabel(i+1).toUpperCase();
//					System.out.println("columnName="+columnName);
					for (Field field : fields) {
						//判断属性名与列名是否相同
						if(field.getName().toUpperCase().equals(columnName)) {
							//获取属性对应的set方法名，方法名首字母大写
							String methodName="set"+field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1);
							//获取属性对应的set方法
							Method method = obj.getClass().getDeclaredMethod(methodName, field.getType());
							//设置访问权限
							method.setAccessible(true);
							//执行set方法，将数据存储到对象中的相应属性中
							method.invoke(obj, rs.getObject(columnName));
							break;
						}
					}
				}
				lst.add(obj);
				System.out.println("obj="+obj);
			}
			return lst;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 多表查询时返回结果集,利用反射机制赋值 
	 * @param rs
	 * @return 返回List<Map<String,Object>>
	 * @throws Exception
	 */
	public static List<Map<String,Object>> toList(ResultSet rs) throws Exception{
		//定义实体集合
		List<Map<String,Object>> lst=new ArrayList<Map<String,Object>>();
		//获取ResultSet的metadata列信息	
		ResultSetMetaData metaData = rs.getMetaData();
		Map<String,Object> set=null;
		while(rs.next()) {
			set=new HashMap<String,Object>();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				String columnName=metaData.getColumnLabel(i+1);
				set.put(columnName, rs.getObject(columnName));
			}
			lst.add(set);
		}
		return lst;
	}
}
