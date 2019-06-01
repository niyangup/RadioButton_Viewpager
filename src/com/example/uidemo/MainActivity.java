package com.example.uidemo;

import java.util.ArrayList;

import com.example.uidemo.pager.BasePager;
import com.example.uidemo.pager.GovPager;
import com.example.uidemo.pager.HomePager;
import com.example.uidemo.pager.NewsPager;
import com.example.uidemo.pager.SettingPager;
import com.example.uidemo.pager.SmartServicePager;
import com.example.uidemo.view.NoScollViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	private NoScollViewPager mVp;
	private RadioGroup mRgGroup;
	private ArrayList<BasePager> mPagers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initUI();

		initData();
		initAdapter();
		mRgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int id) {
				switch (id) {
				case R.id.rb_home:
					mVp.setCurrentItem(0, false);
					break;

				case R.id.rb_news:
					mVp.setCurrentItem(1, false);
					break;

				case R.id.rb_smart:
					mVp.setCurrentItem(2, false);
					break;

				case R.id.rb_gov:
					mVp.setCurrentItem(3, false);
					break;

				case R.id.rb_setting:
					mVp.setCurrentItem(4, false);
					break;
				}
			}
		});
	}

	private void initAdapter() {
		mVp.setAdapter(new MyAdapter());
	}

	public void initData() {
		mPagers = new ArrayList<BasePager>();
		mPagers.add(new HomePager(this));
		mPagers.add(new NewsPager(this));
		mPagers.add(new SmartServicePager(this));
		mPagers.add(new GovPager(this));
		mPagers.add(new SettingPager(this));
	}

	public void initUI() {
		mVp = (NoScollViewPager) findViewById(R.id.vp);
		mRgGroup = (RadioGroup) findViewById(R.id.rg_group);
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mPagers.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			BasePager pager = mPagers.get(position);
			View view = pager.initView();

			container.addView(view);
			return view;
		}

	}

}
