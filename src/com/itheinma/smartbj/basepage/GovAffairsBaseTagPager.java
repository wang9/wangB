package com.itheinma.smartbj.basepage;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

public class GovAffairsBaseTagPager extends BaseTagPage {

	public GovAffairsBaseTagPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initData() {
		// 
		mTvTitle.setText("政务");
		
		TextView tv = new TextView(context);
		tv.setText("政务的内容");
		tv.setTextSize(25);
		tv.setGravity(Gravity.CENTER);
		
		super.initData();
	}

}
