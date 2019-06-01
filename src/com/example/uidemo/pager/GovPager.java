package com.example.uidemo.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class GovPager extends BasePager{
	
	public GovPager(Activity activity) {
		super(activity);
		
	}
	
	public void initData() {
	}

	@Override
	public View initView() {
		//给帧布局填充布局对象
		TextView view=new TextView(mActivity);
		view.setText("政务");
		view.setTextColor(Color.RED);
		view.setTextSize(22);
		view.setGravity(Gravity.CENTER);
		return view;
	}
}
