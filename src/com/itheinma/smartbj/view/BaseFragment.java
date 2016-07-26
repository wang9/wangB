package com.itheinma.smartbj.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheinma.smartbj.acativity.MainActivity;

/**
 * 
 * @author 王玉伟
 * @创建时间上午8:01:17
 * @描述::TODO
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.viewSmartBJ
 * 
 * 这里给Fragment定义了一个框架,因为Fragment需要生命周期,
 * 我们就把声明周期方法定义到了框架里,这样,子类要完成功能就覆盖这里面的mvc即可
 * MVC是: 
 * 	M:initData();	
 * 	V:initView();
 *	C:initEvent();  
 * 
 */
public abstract class BaseFragment extends Fragment {

	// 获取上下文
	protected MainActivity mainActivity;

	// 创建时调用
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// 获取fragment所在的Activity
		mainActivity = (MainActivity) getActivity();

	}

	// 初始化界面
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = initView();//**V
		return root;

	}

	/**
	 * 	必须覆盖此方法完成界面的显示
	 * @return
	 */
	public abstract View initView();
	/**
	 * 子类完成此方法完成数据的添加
	 */
	public void initData(){
		
	}
	/**
	 * 子类完成此方法完成事件的添加
	 */
	public void initEvent(){
		
	}
	

	// 初始化事件和数据
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// 初始化事件和数据
		super.onActivityCreated(savedInstanceState);
		
		initData();//初始化数据
		initEvent();//初始化事件
	}

}
