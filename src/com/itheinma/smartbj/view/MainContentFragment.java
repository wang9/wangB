package com.itheinma.smartbj.view;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.itheinma.smartbj.R;
import com.itheinma.smartbj.basepage.BaseTagPage;
import com.itheinma.smartbj.basepage.GovAffairsBaseTagPager;
import com.itheinma.smartbj.basepage.HomeBaseTagpager;
import com.itheinma.smartbj.basepage.NewCenterBaseTagPager;
import com.itheinma.smartbj.basepage.SettingConterBaseTagPager;
import com.itheinma.smartbj.basepage.SmartServiceBaseTagPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
/**
 * 
 * @author 王玉伟
 * @创建时间上午8:51:13
 * @描述::主界面内容的Fragment
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.viewSmartBJ
 *
 */
public class MainContentFragment extends BaseFragment {

	@ViewInject(R.id.vp_main_content_pages)//这样就不用写findViewById();了
	private ViewPager viewPager;
	@ViewInject(R.id.rg_content_radios)//这样就不用写findViewById();了
	private RadioGroup mRgRadios;
	
	//创建容器
	private List<BaseTagPage> pager = new ArrayList<BaseTagPage>();
	
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		View root = View.inflate(mainActivity, R.layout.fragment_content_view, null);
		
		//xUtils 的动态注入View
		ViewUtils.inject(this, root);//这样就不用写findViewById();了.到这里就有iew主键了
		
		return root;
	}
	//设置值
	@Override
	public void initData() {
		//完成界面
		
		//首页
		pager.add(new HomeBaseTagpager(mainActivity));
		//新闻中心
		pager.add(new NewCenterBaseTagPager(mainActivity));
		//智慧服务
		pager.add(new SmartServiceBaseTagPager(mainActivity));
		//政务
		pager.add(new GovAffairsBaseTagPager(mainActivity));
		//设置中心
		pager.add(new SettingConterBaseTagPager(mainActivity));
		
		//创建实例MyAdapter
		MyAdapter adapter = new MyAdapter();
		viewPager.setAdapter(adapter);
	}
	
	//设置Adapter
	private class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pager.size();//返回的长度
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;//内容相等就返回
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//删除
			container.removeViewInLayout((View) object);//删除,要强制转换成View
			
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			//实例化项目
			BaseTagPage baseTagPager = pager.get(position);
			View root = baseTagPager.getRoot();
			container.addView(root);
			return root;
			
		}
		
	}

}
