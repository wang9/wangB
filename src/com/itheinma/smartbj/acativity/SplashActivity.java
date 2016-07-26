package com.itheinma.smartbj.acativity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.itheinma.smartbj.R;
import com.itheinma.smartbj.utils.MyConstants;
import com.itheinma.smartbj.utils.SpTools;

/**
 * 
 * @author 王玉伟
 * @创建时间下午7:43:47
 * @描述:智慧北京的Splash主界面,主要完成实现动画的效果:
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.acativitySmartBJ
 *
 */
public class SplashActivity extends Activity {
	//成员变量
	private ImageView mSplashMainView;
	private AnimationSet aas;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//
		super.onCreate(savedInstanceState);
		
		//去掉标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//方法的调用
		initView();//V初始化界面
		//启动,播放动画
		startAnimation();
		//初始化事件
		initEvent();
		
		
	}
	private void initEvent() {
		//1;监听动画播完的事件
				aas.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						//监听动画播完
						//2;判断进入那个界面
						if (SpTools.getBoolean(getApplicationContext(), MyConstants.ISSETUP, false)) {
							//true 设置过,直接进入主界面
							//进入主界面
							Intent intent = new Intent(SplashActivity.this,MainActivity.class);
							//启动主界面
							startActivity(intent);
							
						}else{
							//false 就是没设置过,就就进入设置向导界面
							System.out.println("guide View:进入设置向导界面");
							//进入设置向导界面
							Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
							//启动向导界面
							startActivity(intent);//启动设置向导界面
							
						}
						//关闭自己
						finish();
				
			
					}
				});
				
	}		
	/**
	 * 启动,播放动画:旋转,缩放,渐变
	 * 这里使用动集
	 */
	private void startAnimation() {
		aas = new AnimationSet(false);
		
		//1):旋转动画.注意锚点的设置
		RotateAnimation ra = new RotateAnimation(
				0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);//设置锚点是图片的中心点
		//设置动画的播放时间
		ra.setDuration(2000);
		ra.setFillAfter(true);//动画播放完,停留在当前状态
		
		//添加旋转动画,到动画集
		aas.addAnimation(ra);
		
		//2):渐变动画
		AlphaAnimation aa = new AlphaAnimation(0,1);//0,1:透明到不透明的状态的改变
		aa.setDuration(2000);
		aa.setFillAfter(true);
		aas.addAnimation(aa);
		
		//3):比例动画,就是缩放动画
		ScaleAnimation sa = new ScaleAnimation(
				0, 1, 
				0, 1, 
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);
		
		sa.setDuration(2000);
		sa.setFillAfter(true);
		aas.addAnimation(sa);
		
		
		//添加完动画集,就开始播放动画
		mSplashMainView.startAnimation(aas);
		
		//动画播完进入下一个界面if(向导界面)(主界面)
		
		
		//1;监听动画播完的事件
		/**
		 * 这里的代码放到了initEvent();中执行了:
		 */
		
		//2;判断进入那个界面
		/**
		 * 这里的代码放到了initEvent();中执行了:
		 */
		
		
	}
	/**
	 * 初始化界面
	 */
	private void initView() {
		//设置主界面
		setContentView(R.layout.activity_splash);
		//获取都图片资源
		mSplashMainView = (ImageView) findViewById(R.id.iv_splash_mainview);
		
	}

}
