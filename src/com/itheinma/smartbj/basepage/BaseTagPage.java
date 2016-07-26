package com.itheinma.smartbj.basepage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.itheinma.smartbj.R;

/**
 * 
 * @author 王玉伟
 * @创建时间下午9:52:01
 * @描述::定义一个基础类.实现一些[共有]的功能
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.basepageSmartBJ
 *
 */
public class BaseTagPage {
	
	protected Context context;
	protected View root;
	protected ImageButton mIvMenu;//按钮
	protected TextView mTvTitle;
	protected FrameLayout mFlContent;
	
	public BaseTagPage(Context context){
		this.context = context;
		initView();
		initData();
		initEvent();
		
	}

	

	public void initView() {
		//root就是显示的内容.就是根布局
		root = View.inflate(context, R.layout.fragment_content_base_content, null);
		//获取主键
		mIvMenu = (ImageButton) root.findViewById(R.id.ib_base_content_ment);
		//
		mTvTitle = (TextView) root.findViewById(R.id.tv_base_content_title);
		//
		mFlContent = (FrameLayout) root.findViewById(R.id.fl_base_content_tag);
	}
	
	//初始化数据
	public void initData() {
		// TODO Auto-generated method stub

	}
	public void initEvent() {
		// TODO Auto-generated method stub
		
	}
	
	//定义方法获取根布局
	public View getRoot(){
		return root;
		
	}
	
}
