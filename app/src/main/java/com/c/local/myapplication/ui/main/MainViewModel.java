package com.c.local.myapplication.ui.main;

import android.app.Application;

import com.c.local.myapplication.R;

import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {

	// グラフデータ
	private int[] mGraphValues;
	// 下限 index
	private int mMinIndex;
	// 上限 index
	private int mMaxIndex;
	// min テキストの配列
	private String[] mMinTextArr;
	// max テキストの配列
	private String[] mMaxTextArr;

	public MainViewModel(Application application) {
		super(application);
		mGraphValues = new int[]{330, 1156, 2557, 4137, 5386, 6677, 7730, 8369, 10906, 11184, 10705, 10150, 9550, 13477, 9960, 7181, 5846, 3656, 2118};
		mMinIndex = 0;
		mMaxIndex = 18;

		// テキストの表示
		mMinTextArr = application.getResources().getStringArray(R.array.min_price_text);
		mMaxTextArr = application.getResources().getStringArray(R.array.max_price_text);

	}

	public int[] getGraphValues() {
		return mGraphValues;
	}

	public int getMinIndex() {
		return mMinIndex;
	}

	public int getMaxIndex() {
		return mMaxIndex;
	}

	public void setMinIndex(int mMinIndex) {
		this.mMinIndex = mMinIndex;
	}

	public void setMaxIndex(int mMaxIndex) {
		this.mMaxIndex = mMaxIndex;
	}

	public String[] getMinTextArr() {
		return mMinTextArr;
	}

	public String[] getMaxTextArr() {
		return mMaxTextArr;
	}
}