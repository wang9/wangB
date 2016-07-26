package com.itheinma.smartbj.acativity;


import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.Window;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.itheinma.smartbj.R;
import com.itheinma.smartbj.view.LeftMenuFragment;
import com.itheinma.smartbj.view.MainContentFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	private static final String LEFT_MUNE_TAG = "left_mune_tag";
	private static final String MAIN_MUNE_TAG = "main_mune_tag";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//设置隐藏标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//方法的调用
			initView();//初始化视图
			initData();//初始化数据
			initEvent();//初始化事件
		
	}
	/**
	 * //初始化事件
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * //初始化数据
	 */
	private void initData() {
		// Fragment的管理器
		FragmentManager fragmentManager = getSupportFragmentManager();
		//1:获取事物
			FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		
		//2:完成替换
			//完成左侧菜单界面的替换
			transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(), LEFT_MUNE_TAG);
			//完成主界面的替换
			transaction.replace(R.id.fl_main_menu, new MainContentFragment(), MAIN_MUNE_TAG);
			
		//3:提交事物
			transaction.commit();
		
	}
	/**
	 * //初始化视图
	 */
	private void initView() {
		// 设置主界面
		setContentView(R.layout.fragment_content_tag);
		//设置左侧的菜单
		setBehindContentView(R.layout.fragment_left);
		//设置滑动模式
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		//设置滑动的滑动位置,设为全屏快可以划屏
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//设置主界面剩余的位置大小.就是滑动左界面主界面必须剩余的宽度;
		sm.setBehindOffset(300);
		
		
		
	}
}
