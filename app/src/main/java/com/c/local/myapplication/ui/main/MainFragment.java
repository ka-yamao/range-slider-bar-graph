package com.c.local.myapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.c.local.myapplication.R;
import com.c.local.myapplication.databinding.MainFragmentBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import static com.c.local.myapplication.App.getApplication;

public class MainFragment extends Fragment {

	private MainViewModel mViewModel;

	private MainFragmentBinding mBinding;

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		// DataBinding
		mBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);

		// ViewModel
		mViewModel = new ViewModelProvider(requireActivity(),
				new ViewModelProvider.AndroidViewModelFactory(getApplication())).
				get(MainViewModel.class);
		// グラフにデータを設定
		mBinding.barGraph.setGraphValues(mViewModel.getGraphValues());
		mBinding.barGraph.setMinIndex(mViewModel.getMinIndex());
		mBinding.barGraph.setMaxIndex(mViewModel.getMaxIndex());
		// テキスト情報
		mBinding.minText.setText(mViewModel.getMinTextArr()[0]);
		mBinding.maxText.setText(mViewModel.getMaxTextArr()[18]);
		// スライダーの初期値を設定
		mBinding.rangeSlider.setValues((float) mViewModel.getMinIndex(), (float) mViewModel.getMaxIndex());
		// スライダーの変更リスナー
		mBinding.rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
			Float[] values = slider.getValues().toArray(new Float[2]);
			float min = values[0];
			float max = values[1];
			mViewModel.setMinIndex((int) min);
			mViewModel.setMaxIndex((int) max);
			// 棒グラフのカスタムViewはデータバインディングに対応してないので、値を設定
			mBinding.barGraph.setMinIndex(mViewModel.getMinIndex());
			mBinding.barGraph.setMaxIndex(mViewModel.getMaxIndex());
			// 棒グラフの再描画
			mBinding.barGraph.invalidate();
			// 最小、最大のテキストを更新
			mBinding.minText.setText(mViewModel.getMinTextArr()[mViewModel.getMinIndex()]);
			mBinding.maxText.setText(mViewModel.getMaxTextArr()[mViewModel.getMaxIndex()]);
		});

		return mBinding.getRoot();
	}

}