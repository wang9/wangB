package com.itheinma.smartbj.view;

import com.itheinma.smartbj.acativity.MainActivity;

import android.view.Gravity;
import android.view.View;
import android.widget.Gallery;
import android.widget.TextView;
/**
 * 
 * @author 王玉伟
 * @创建时间上午8:50:44
 * @描述::左侧菜单的Fragment
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.viewSmartBJ
 *
 */
public class LeftMenuFragment extends BaseFragment {

	@Override
	public View initView() {
		// 
		TextView tv = new TextView(mainActivity);
		tv.setText("左侧菜单");
		tv.setTextSize(30);
		tv.setGravity(Gravity.CENTER);
		return tv;
	}

}
