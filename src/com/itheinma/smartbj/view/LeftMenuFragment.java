package com.itheinma.smartbj.view;

import com.itheinma.smartbj.acativity.MainActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Gallery;
import android.widget.TextView;
/**
 * 
 * @author ����ΰ
 * @����ʱ������8:50:44
 * @����::���˵���Fragment
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.viewSmartBJ
 *
 */
public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView() {
		// 
		TextView tv = new TextView(mainActivity);
		tv.setText("���˵�");
		tv.setTextSize(30);
		tv.setGravity(Gravity.CENTER);
		return tv;
	}

}
