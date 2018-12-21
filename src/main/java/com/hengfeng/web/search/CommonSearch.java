package com.hengfeng.web.search;

import java.lang.reflect.Field;

public class CommonSearch {

	/**
	 * 设置默认值查询属性默认值为空
	 * @return
	 */
	 public <T> T setDefautValues() 
	 {
	     Field[] list = this.getClass().getDeclaredFields();
	     try {
	    	 for (Field field:list) {
	    		 if (field.getGenericType().toString().equals("class java.lang.String")) {
		    		 field.setAccessible(true);
		             if (field == null) {
		            	continue;
		             }
		            	
		             if (field.get(this).equals("") && this != null) {
		            	 field.set(this, null);
		             }
	    		 }
	    	 }
	        	
	     } catch (Exception ex) {
	    	 return (T)ex.getMessage();
	     }
	    	
	     return (T)this;
	  }
	 /**
	  * 设置某个字段缺省值
	  * @param name
	  * @return
	  */
	 public Object setDefautValue(String name) 
	 {
	     try {
	    	 Class<?> classObj = this.getClass();
	         Field field = classObj.getDeclaredField(name);
	         field.setAccessible(true);
	         if (field == null) {
	        	return null;
	         }
	         if (field.get(this) == "") {
	        	 field.set(this, null);
	         }
	     } catch (Exception ex) {
	    		
	     }
	    	
	     return this;
	  }
}
