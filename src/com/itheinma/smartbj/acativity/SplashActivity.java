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
 * @author ����ΰ
 * @����ʱ������7:43:47
 * @����:�ǻ۱�����Splash������,��Ҫ���ʵ�ֶ�����Ч��:
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.acativitySmartBJ
 *
 */
public class SplashActivity extends Activity {
	//��Ա����
	private ImageView mSplashMainView;
	private AnimationSet aas;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//
		super.onCreate(savedInstanceState);
		
		//ȥ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//�����ĵ���
		initView();//V��ʼ������
		//����,���Ŷ���
		startAnimation();
		//��ʼ���¼�
		initEvent();
		
		
	}
	private void initEvent() {
		//1;��������������¼�
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
						//������������
						//2;�жϽ����Ǹ�����
						if (SpTools.getBoolean(getApplicationContext(), MyConstants.ISSETUP, false)) {
							//true ���ù�,ֱ�ӽ���������
							//����������
							Intent intent = new Intent(SplashActivity.this,MainActivity.class);
							//����������
							startActivity(intent);
							
						}else{
							//false ����û���ù�,�;ͽ��������򵼽���
							System.out.println("guide View:���������򵼽���");
							//���������򵼽���
							Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
							//�����򵼽���
							startActivity(intent);//���������򵼽���
							
						}
						//�ر��Լ�
						finish();
				
			
					}
				});
				
	}		
	/**
	 * ����,���Ŷ���:��ת,����,����
	 * ����ʹ�ö���
	 */
	private void startAnimation() {
		aas = new AnimationSet(false);
		
		//1):��ת����.ע��ê�������
		RotateAnimation ra = new RotateAnimation(
				0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);//����ê����ͼƬ�����ĵ�
		//���ö����Ĳ���ʱ��
		ra.setDuration(2000);
		ra.setFillAfter(true);//����������,ͣ���ڵ�ǰ״̬
		
		//�����ת����,��������
		aas.addAnimation(ra);
		
		//2):���䶯��
		AlphaAnimation aa = new AlphaAnimation(0,1);//0,1:͸������͸����״̬�ĸı�
		aa.setDuration(2000);
		aa.setFillAfter(true);
		aas.addAnimation(aa);
		
		//3):��������,�������Ŷ���
		ScaleAnimation sa = new ScaleAnimation(
				0, 1, 
				0, 1, 
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);
		
		sa.setDuration(2000);
		sa.setFillAfter(true);
		aas.addAnimation(sa);
		
		
		//����궯����,�Ϳ�ʼ���Ŷ���
		mSplashMainView.startAnimation(aas);
		
		//�������������һ������if(�򵼽���)(������)
		
		
		//1;��������������¼�
		/**
		 * ����Ĵ���ŵ���initEvent();��ִ����:
		 */
		
		//2;�жϽ����Ǹ�����
		/**
		 * ����Ĵ���ŵ���initEvent();��ִ����:
		 */
		
		
	}
	/**
	 * ��ʼ������
	 */
	private void initView() {
		//����������
		setContentView(R.layout.activity_splash);
		//��ȡ��ͼƬ��Դ
		mSplashMainView = (ImageView) findViewById(R.id.iv_splash_mainview);
		
	}

}
