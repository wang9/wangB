package com.itheinma.smartbj.basepage;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

public class SmartServiceBaseTagPager extends BaseTagPage {

	public SmartServiceBaseTagPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initData() {
		// 
		mTvTitle.setText("�ǻ۷���");
		
		TextView tv = new TextView(context);
		tv.setText("�ǻ۷��������");
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		
		super.initData();
	}
}
