package com.itheinma.smartbj.basepage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itheinma.smartbj.R;

/**
 * 
 * @author ����ΰ
 * @����ʱ������9:52:01
 * @����::����һ��������.ʵ��һЩ[����]�Ĺ���
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.basepageSmartBJ
 *
 */
public class BaseTagPage {
	
	protected Context context;
	protected View root;
	protected ImageButton mIvMenu;//��ť
	protected TextView mTvTitle;
	protected FrameLayout mFlContent;
	
	public BaseTagPage(Context context){
		this.context = context;
		initView();
		initData();
		initEvent();
		
	}

	

	public void initView() {
		//root������ʾ������.���Ǹ�����
		root = View.inflate(context, R.layout.fragment_content_base_content, null);
		//��ȡ����
		mIvMenu = (ImageButton) root.findViewById(R.id.ib_base_content_ment);
		//
		mTvTitle = (TextView) root.findViewById(R.id.tv_base_content_title);
		//
		mFlContent = (FrameLayout) root.findViewById(R.id.fl_base_content_tag);
	}
	
	//��ʼ������
	public void initData() {
		// TODO Auto-generated method stub

	}
	public void initEvent() {
		// TODO Auto-generated method stub
		
	}
	
	//���巽����ȡ������
	public View getRoot(){
		return root;
		
	}
	
}
