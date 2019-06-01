package com.example.uidemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScollViewPager extends ViewPager {

	public NoScollViewPager(Context context) {
		super(context);
	}

	public NoScollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		return true;
	}

}
