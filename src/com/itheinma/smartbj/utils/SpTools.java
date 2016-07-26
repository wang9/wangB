package com.itheinma.smartbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * @author ����ΰ
 * @����ʱ������9:04:15
 * @����::TODO
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.utilsSmartBJ
 * 
 */
public class SpTools {
	/**
	 * 
	 * @param key
	 * �ؼ���
	 * @param value
	 * ��Ӧ��ֵ
	 */
	public static void setBoolean(Context context,String key,boolean value){
		//(CONFIGFLE��:sp�����ļ�context.MODE_PRIVATE������;CONFIGFLE��Ȩ�޵���˽�е�)
		SharedPreferences sp =  context.getSharedPreferences(MyConstants.CONFIGFLE, context.MODE_PRIVATE);
		//�ύ�����ֵ��:
		sp.edit().putBoolean(key, value).commit();
		
	}
	/**
	 * 
	 * @param context
	 * @param key
	 * 		�ؼ���
	 * @param defValue
	 * 		���õ�Ĭ��ֵ
	 * @return
	 */
	public static boolean getBoolean(Context context,String key,boolean defValue){
		
		SharedPreferences sp =  context.getSharedPreferences(MyConstants.CONFIGFLE, context.MODE_PRIVATE);
		//���ز������͵ļ�ֵ��
		return sp.getBoolean(key, defValue);
		
	}
}
