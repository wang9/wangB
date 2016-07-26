package com.itheinma.smartbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * @author 王玉伟
 * @创建时间下午9:04:15
 * @描述::TODO
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.utilsSmartBJ
 * 
 */
public class SpTools {
	/**
	 * 
	 * @param key
	 * 关键字
	 * @param value
	 * 对应的值
	 */
	public static void setBoolean(Context context,String key,boolean value){
		//(CONFIGFLE是:sp配置文件context.MODE_PRIVATE是设置;CONFIGFLE的权限的是私有的)
		SharedPreferences sp =  context.getSharedPreferences(MyConstants.CONFIGFLE, context.MODE_PRIVATE);
		//提交保存键值对:
		sp.edit().putBoolean(key, value).commit();
		
	}
	/**
	 * 
	 * @param context
	 * @param key
	 * 		关键字
	 * @param defValue
	 * 		设置的默认值
	 * @return
	 */
	public static boolean getBoolean(Context context,String key,boolean defValue){
		
		SharedPreferences sp =  context.getSharedPreferences(MyConstants.CONFIGFLE, context.MODE_PRIVATE);
		//返回布尔类型的键值对
		return sp.getBoolean(key, defValue);
		
	}
}
