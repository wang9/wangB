package com.itheinma.smartbj.basepage;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

public class SettingConterBaseTagPager extends BaseTagPage {

	public SettingConterBaseTagPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initData() {
		// 
		mTvTitle.setText("��������");
		
		TextView tv = new TextView(context);
		tv.setText("�������ĵ�����");
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		
		super.initData();
	}
}
