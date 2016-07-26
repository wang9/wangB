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
 * @author 王玉伟
 * @创建时间下午10:28:58
 * @描述::设置向导界面,采用ViewPager完成界面的切换
 * @svn提交者:$Author$
 * @提交时间:$Date$
 * @当前版本:$Rev$
 * @包名工程名:com.itheinma.smartbj.acativitySmartBJ
 *
 */
public class GuideActivity extends Activity {
	
	private ViewPager mVpGuides;
	private LinearLayout mLlpoints;
	private View mVRedPoint;
	private Button mBtStartExp;
	private List<ImageView> guids;
	private MyAdapter adapter;
	private int disPoints;//点与点之间的距离
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
			//设置取消标题显示title:
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		
			//方法的引用
			initView();//初始化界面
			initData();//初始化数据
			initEvent();//初始化组件的事件
		
	}
	/**
	 * 初始化组件的事件
	 */
	private void initEvent() {
		
		//这个是监听布局有没有布局好的事件监听器;布局完成,界面显示触发此事件
		mVRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			

			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				
				//取消监听,界面变化而发生的回调结果
				mVRedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				
				//显示两个点之间的间距
				//System.out.println("distaance of points:" + (mLlpoints.getChildAt(1).getLeft() - mLlpoints.getChildAt(0).getLeft()));
				
				//显示两个点之间的间距
				disPoints = (mLlpoints.getChildAt(1).getLeft() - mLlpoints.getChildAt(0).getLeft());
				
			}
		});
		
		
		//按钮添加点击事件:
		mBtStartExp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 保存设置的状态
				SpTools.setBoolean(getApplicationContext(), MyConstants.ISSETUP, true);//保存设置完成的状态
				
				//进入主界面
				Intent intent = new Intent(GuideActivity.this,MainActivity.class);
				//启动主界面
				startActivity(intent);
				//关闭自己
				finish();
				
			}
		});
		
		// ViewPagetr添加页码改变事件
		mVpGuides.setOnPageChangeListener(new OnPageChangeListener() {
			
			//当前ViewPager显示的界面
			@Override
			public void onPageSelected(int position) {
				
				//如果viewPager滑动到第三个页面(就是最后一页显示),显示button按钮
				if (position == guids.size() - 1) {//判断是不是最后一页
					//是就进来
					mBtStartExp.setVisibility(View.VISIBLE);//显示按钮
				}else{
					//不是最后一页就隐藏button按钮
					mBtStartExp.setVisibility(View.GONE);//隐藏按钮
				}
			}
			//在页面滑动时触发的事件
			/**
			 * int position:当前ViewPager停留的位置
			 * float positionOffset:偏离的比例值
			 * int positionOffsetPixels:偏移的像素
			 * 
			 */
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				//positionOffset 移动的比例值
				
				//计算红点的左边距			(点的间距 * 页面的比例值)
				float leftMargin = disPoints * (position + positionOffset);
				//设置红点的左边距:首先获取到参数
				
				
				
				
				
				
				
				
				
				//这句有问题,暂时hi唉解决不了
				LayoutParams layoutParams1 = (LayoutParams) mVRedPoint.getLayoutParams();
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//通过参数设置点的改变
				layoutParams1.leftMargin = Math.round(leftMargin);//对float类型进行四舍五入,变成intent类型的值
				//重新设置布局参数
				mVRedPoint.setLayoutParams(layoutParams1);
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private void initData() {
		//ViewPager-->Adapter-->list.他们是互相需要的关系
		//创建图片数据数组
		int[] pics = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
		
		//把图片封装到容器中定义ViewPager使用的容器
		guids = new ArrayList<ImageView>();
		
		//初始化容器中的数据
		for (int i = 0; i < pics.length; i++) {
			ImageView mIvTemp = new ImageView(getApplicationContext());
			mIvTemp.setBackgroundResource(pics[i]);//添加数据
			
			//添加到容器中
			guids.add(mIvTemp);
			
		//给LinearLayout初始化添加点;就是灰色的点	
		View mVPoint = new View(getApplicationContext());
		//设置点
		mVPoint.setBackgroundResource(R.drawable.gray_point);
		
///////设置灰色点的大小
		//LayoutParams params = new LayoutParams(10, 10);//注意单位是px,不是dp.
		int dip = 10;
		LayoutParams params = new LayoutParams(DensityUtil.dip2px(getApplicationContext(), dip), DensityUtil.dip2px(getApplicationContext(), dip));//这是把px像素转成了,设备像素了dip了

		
		//设置点之间的间距
		if (i != 0){//过滤掉第一个点.第一个点不要间距
			params.leftMargin = 10;//是px像素
			
			//设置到mVPoint容器中
			mVPoint.setLayoutParams(params);//他会没有间距的添加
			
			//把点添加到线性布局中
			mLlpoints.addView(mVPoint);//再把容器添加到动态添加点的容器中
		}
		
		
		
		
		
		//界面没有布局前,点的位置是确定不了的,布局完成后,才能知道点与点之间的间距是多少
		
		//这里的事件代码是在initEvent中.
		
		
		
		
		}
		
		//有了上面的值就可以创建适配器
		adapter = new MyAdapter();//注意代码的顺序,有了上面的代码,这里就不会空指针了
		
		//设置适配器
		mVpGuides.setAdapter(adapter);
		
	}
	
	//创建PagerAdapter适配器
	
	private class MyAdapter extends PagerAdapter{


		@Override
		public int getCount() {
			
			return guids.size();//返回数据的个数
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;//这个方法过滤缓存的作用都有:
		}
		
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//删除
			container.removeView((View) object);//从ViewPager中移除
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// 这里的container就是 ViewPager了
			
			//获取View
			View child = guids.get(position);
			//添加View
			container.addView(child);
			//返回View
			return child;
		}
		
	}
	
	
	
	/**
	 * 初始化界面
	 */
	private void initView() {
		setContentView(R.layout.activity_guide);
		//ViewPager组件获取到组件
		mVpGuides = (ViewPager) findViewById(R.id.vp_guide_pages);
		//动态加点的容器
		mLlpoints = (LinearLayout) findViewById(R.id.ll_guide_points);
		//红点
		mVRedPoint = findViewById(R.id.v_guide_redpoint);
		//按钮
		mBtStartExp = (Button) findViewById(R.id.btn_guide_startexp);
		
	}
	
}
