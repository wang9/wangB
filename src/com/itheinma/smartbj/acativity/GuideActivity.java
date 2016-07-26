package com.itheinma.smartbj.acativity;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.itheinma.smartbj.R;
import com.itheinma.smartbj.utils.DensityUtil;
import com.itheinma.smartbj.utils.MyConstants;
import com.itheinma.smartbj.utils.SpTools;
/**
 * 
 * @author ����ΰ
 * @����ʱ������10:28:58
 * @����::�����򵼽���,����ViewPager��ɽ�����л�
 * @svn�ύ��:$Author$
 * @�ύʱ��:$Date$
 * @��ǰ�汾:$Rev$
 * @����������:com.itheinma.smartbj.acativitySmartBJ
 *
 */
public class GuideActivity extends Activity {
	
	private ViewPager mVpGuides;
	private LinearLayout mLlpoints;
	private View mVRedPoint;
	private Button mBtStartExp;
	private List<ImageView> guids;
	private MyAdapter adapter;
	private int disPoints;//�����֮��ľ���
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
			//����ȡ��������ʾtitle:
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		
			//����������
			initView();//��ʼ������
			initData();//��ʼ������
			initEvent();//��ʼ��������¼�
		
	}
	/**
	 * ��ʼ��������¼�
	 */
	private void initEvent() {
		
		//����Ǽ���������û�в��ֺõ��¼�������;�������,������ʾ�������¼�
		mVRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			

			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				
				//ȡ������,����仯�������Ļص����
				mVRedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				
				//��ʾ������֮��ļ��
				//System.out.println("distaance of points:" + (mLlpoints.getChildAt(1).getLeft() - mLlpoints.getChildAt(0).getLeft()));
				
				//��ʾ������֮��ļ��
				disPoints = (mLlpoints.getChildAt(1).getLeft() - mLlpoints.getChildAt(0).getLeft());
				
			}
		});
		
		
		//��ť��ӵ���¼�:
		mBtStartExp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// �������õ�״̬
				SpTools.setBoolean(getApplicationContext(), MyConstants.ISSETUP, true);//����������ɵ�״̬
				
				//����������
				Intent intent = new Intent(GuideActivity.this,MainActivity.class);
				//����������
				startActivity(intent);
				//�ر��Լ�
				finish();
				
			}
		});
		
		// ViewPagetr���ҳ��ı��¼�
		mVpGuides.setOnPageChangeListener(new OnPageChangeListener() {
			
			//��ǰViewPager��ʾ�Ľ���
			@Override
			public void onPageSelected(int position) {
				
				//���viewPager������������ҳ��(�������һҳ��ʾ),��ʾbutton��ť
				if (position == guids.size() - 1) {//�ж��ǲ������һҳ
					//�Ǿͽ���
					mBtStartExp.setVisibility(View.VISIBLE);//��ʾ��ť
				}else{
					//�������һҳ������button��ť
					mBtStartExp.setVisibility(View.GONE);//���ذ�ť
				}
			}
			//��ҳ�滬��ʱ�������¼�
			/**
			 * int position:��ǰViewPagerͣ����λ��
			 * float positionOffset:ƫ��ı���ֵ
			 * int positionOffsetPixels:ƫ�Ƶ�����
			 * 
			 */
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				//positionOffset �ƶ��ı���ֵ
				
				//���������߾�			(��ļ�� * ҳ��ı���ֵ)
				float leftMargin = disPoints * (position + positionOffset);
				//���ú�����߾�:���Ȼ�ȡ������
				
				
				
				
				
				
				
				
				
				//���������,��ʱhi���������
				LayoutParams layoutParams1 = (LayoutParams) mVRedPoint.getLayoutParams();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//ͨ���������õ�ĸı�
				layoutParams1.leftMargin = Math.round(leftMargin);//��float���ͽ�����������,���intent���͵�ֵ
				//�������ò��ֲ���
				mVRedPoint.setLayoutParams(layoutParams1);
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void initData() {
		//ViewPager-->Adapter-->list.�����ǻ�����Ҫ�Ĺ�ϵ
		//����ͼƬ��������
		int[] pics = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
		
		//��ͼƬ��װ�������ж���ViewPagerʹ�õ�����
		guids = new ArrayList<ImageView>();
		
		//��ʼ�������е�����
		for (int i = 0; i < pics.length; i++) {
			ImageView mIvTemp = new ImageView(getApplicationContext());
			mIvTemp.setBackgroundResource(pics[i]);//�������
			
			//��ӵ�������
			guids.add(mIvTemp);
			
		//��LinearLayout��ʼ����ӵ�;���ǻ�ɫ�ĵ�	
		View mVPoint = new View(getApplicationContext());
		//���õ�
		mVPoint.setBackgroundResource(R.drawable.gray_point);
		
///////���û�ɫ��Ĵ�С
		//LayoutParams params = new LayoutParams(10, 10);//ע�ⵥλ��px,����dp.
		int dip = 10;
		LayoutParams params = new LayoutParams(DensityUtil.dip2px(getApplicationContext(), dip), DensityUtil.dip2px(getApplicationContext(), dip));//���ǰ�px����ת����,�豸������dip��

		
		//���õ�֮��ļ��
		if (i != 0){//���˵���һ����.��һ���㲻Ҫ���
			params.leftMargin = 10;//��px����
			
			//���õ�mVPoint������
			mVPoint.setLayoutParams(params);//����û�м������
			
			//�ѵ���ӵ����Բ�����
			mLlpoints.addView(mVPoint);//�ٰ�������ӵ���̬��ӵ��������
		}
		
		
		
		
		
		//����û�в���ǰ,���λ����ȷ�����˵�,������ɺ�,����֪�������֮��ļ���Ƕ���
		
		//������¼���������initEvent��.
		
		
		
		
		}
		
		//���������ֵ�Ϳ��Դ���������
		adapter = new MyAdapter();//ע������˳��,��������Ĵ���,����Ͳ����ָ����
		
		//����������
		mVpGuides.setAdapter(adapter);
		
	}
	
	//����PagerAdapter������
	
	private class MyAdapter extends PagerAdapter{


		@Override
		public int getCount() {
			
			return guids.size();//�������ݵĸ���
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;//����������˻�������ö���:
		}
		
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//ɾ��
			container.removeView((View) object);//��ViewPager���Ƴ�
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// �����container���� ViewPager��
			
			//��ȡView
			View child = guids.get(position);
			//���View
			container.addView(child);
			//����View
			return child;
		}
		
	}
	
	
	
	/**
	 * ��ʼ������
	 */
	private void initView() {
		setContentView(R.layout.activity_guide);
		//ViewPager�����ȡ�����
		mVpGuides = (ViewPager) findViewById(R.id.vp_guide_pages);
		//��̬�ӵ������
		mLlpoints = (LinearLayout) findViewById(R.id.ll_guide_points);
		//���
		mVRedPoint = findViewById(R.id.v_guide_redpoint);
		//��ť
		mBtStartExp = (Button) findViewById(R.id.btn_guide_startexp);
		
	}
	
}
