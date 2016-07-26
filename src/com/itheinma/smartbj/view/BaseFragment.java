package com.itheinma.smartbj.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheinma.smartbj.acativity.MainActivity;

/**
 * 
 * @author ����ΰ
 * @����ʱ������8:01:17
 * @����::TODO
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.viewSmartBJ
 * 
 * �����Fragment������һ�����,��ΪFragment��Ҫ��������,
 * ���ǾͰ��������ڷ������嵽�˿����,����,����Ҫ��ɹ��ܾ͸����������mvc����
 * MVC��: 
 * 	M:initData();	
 * 	V:initView();
 *	C:initEvent();  
 * 
 */
public abstract class BaseFragment extends Fragment {

	// ��ȡ������
	protected MainActivity mainActivity;

	// ����ʱ����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// ��ȡfragment���ڵ�Activity
		mainActivity = (MainActivity) getActivity();

	}

	// ��ʼ������
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = initView();//**V
		return root;

	}

	/**
	 * 	���븲�Ǵ˷�����ɽ������ʾ
	 * @return
	 */
	public abstract View initView();
	/**
	 * ������ɴ˷���������ݵ����
	 */
	public void initData(){
		
	}
	/**
	 * ������ɴ˷�������¼������
	 */
	public void initEvent(){
		
	}
	

	// ��ʼ���¼�������
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// ��ʼ���¼�������
		super.onActivityCreated(savedInstanceState);
		
		initData();//��ʼ������
		initEvent();//��ʼ���¼�
	}

}
