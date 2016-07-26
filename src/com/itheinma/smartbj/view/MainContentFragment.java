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
 * @author ����ΰ
 * @����ʱ������8:51:13
 * @����::���������ݵ�Fragment
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.viewSmartBJ
 *
 */
public class MainContentFragment extends BaseFragment {

	@ViewInject(R.id.vp_main_content_pages)//�����Ͳ���дfindViewById();��
	private ViewPager viewPager;
	@ViewInject(R.id.rg_content_radios)//�����Ͳ���дfindViewById();��
	private RadioGroup mRgRadios;
	
	//��������
	private List<BaseTagPage> pager = new ArrayList<BaseTagPage>();
	
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		View root = View.inflate(mainActivity, R.layout.fragment_content_view, null);
		
		//xUtils �Ķ�̬ע��View
		ViewUtils.inject(this, root);//�����Ͳ���дfindViewById();��.���������iew������
		
		return root;
	}
	//����ֵ
	@Override
	public void initData() {
		//��ɽ���
		
		//��ҳ
		pager.add(new HomeBaseTagpager(mainActivity));
		//��������
		pager.add(new NewCenterBaseTagPager(mainActivity));
		//�ǻ۷���
		pager.add(new SmartServiceBaseTagPager(mainActivity));
		//����
		pager.add(new GovAffairsBaseTagPager(mainActivity));
		//��������
		pager.add(new SettingConterBaseTagPager(mainActivity));
		
		//����ʵ��MyAdapter
		MyAdapter adapter = new MyAdapter();
		viewPager.setAdapter(adapter);
	}
	
	//����Adapter
	private class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pager.size();//���صĳ���
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;//������Ⱦͷ���
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//ɾ��
			container.removeViewInLayout((View) object);//ɾ��,Ҫǿ��ת����View
			
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			//ʵ������Ŀ
			BaseTagPage baseTagPager = pager.get(position);
			View root = baseTagPager.getRoot();
			container.addView(root);
			return root;
			
		}
		
	}

}
