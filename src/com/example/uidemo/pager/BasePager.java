package com.example.uidemo.pager;

import android.app.Activity;
import android.view.View;

public abstract class BasePager {
	public Activity mActivity;

	public BasePager(Activity activity) {
		this.mActivity = activity;
	}

	public void initData() {

	}

	public abstract View initView();
}
