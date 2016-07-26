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
		
		//�������ر���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//�����ĵ���
			initView();//��ʼ����ͼ
			initData();//��ʼ������
			initEvent();//��ʼ���¼�
		
	}
	/**
	 * //��ʼ���¼�
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * //��ʼ������
	 */
	private void initData() {
		// Fragment�Ĺ�����
		FragmentManager fragmentManager = getSupportFragmentManager();
		//1:��ȡ����
			FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		
		//2:����滻
			//������˵�������滻
			transaction.replace(R.id.fl_left_menu, new LeftMenuFragment(), LEFT_MUNE_TAG);
			//�����������滻
			transaction.replace(R.id.fl_main_menu, new MainContentFragment(), MAIN_MUNE_TAG);
			
		//3:�ύ����
			transaction.commit();
		
	}
	/**
	 * //��ʼ����ͼ
	 */
	private void initView() {
		// ����������
		setContentView(R.layout.fragment_content_tag);
		//�������Ĳ˵�
		setBehindContentView(R.layout.fragment_left);
		//���û���ģʽ
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		//���û����Ļ���λ��,��Ϊȫ������Ի���
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//����������ʣ���λ�ô�С.���ǻ�����������������ʣ��Ŀ��;
		sm.setBehindOffset(300);
		
		
		
	}
}
