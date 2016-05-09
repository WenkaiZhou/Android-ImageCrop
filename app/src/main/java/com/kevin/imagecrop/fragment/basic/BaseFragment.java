package com.kevin.imagecrop.fragment.basic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 版权所有：----有限公司</br>
 *
 * BaseFragment </br>
 *
 * @author zhou.wenkai ,Created on 2015-1-22 22:35:48</br>
 * @Description Major Function：Fragment基类 </br>
 *
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！</br>
 * @author mender，Modified Date Modify Content:
 */
public abstract class BaseFragment extends Fragment {

	/** 类标签 */
	protected static String TAG = "";
	/** 上下文 */
	protected Context mContext 	= null;
	/** 依附的Activity */
	protected Activity mActivity= null;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		TAG = this.getClass().getSimpleName();
		mContext  = activity;
		mActivity = activity;
//		LogUtils.i(getFragmentName() + " onAttach()");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		LogUtils.i(getFragmentName() + " onCreate()");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
//		LogUtils.i(getFragmentName() + " onCreateView()");
		if (getContentViewId() != 0) {
			return inflater.inflate(getContentViewId(), null);
		} else {
			return super.onCreateView(inflater, container, savedInstanceState);
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
//		LogUtils.i(getFragmentName() + " onViewCreated()");
		ButterKnife.bind(this, view);
		init();
		initViews(view);
		initData();
		initEvents();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		LogUtils.i(getFragmentName() + " onActivityCreated()");
	}

	@Override
	public void onStart() {
		super.onStart();
//		LogUtils.i(getFragmentName() + " onStart()");
	}

	@Override
	public void onResume() {
		super.onResume();
//		LogUtils.i(getFragmentName() + " onResume()");
	}

	@Override
	public void onPause() {
		super.onPause();
//		LogUtils.i(getFragmentName() + " onPause()");
	}

	@Override
	public void onStop() {
		super.onStop();
//		LogUtils.i(getFragmentName() + " onStop()");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
//		LogUtils.i(getFragmentName() + " onDestroyView()");
		ButterKnife.unbind(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
//		LogUtils.i(getFragmentName() + " onDestroy()");
	}

	@Override
	public void onDetach() {
		super.onDetach();
//		LogUtils.i(getFragmentName() + " onDetach()");
	}

	/**
	 * 使用Toolbar代替ActionBar
	 *
	 * @return void
	 */
	protected void initToolbar(Toolbar toolbar) {
		((AppCompatActivity)mActivity).setSupportActionBar(toolbar);
	}

	/**
	 * 使用Toolbar代替ActionBar
	 *
	 * @return void
	 */
	protected void initToolbar(Toolbar toolbar, String title) {
		toolbar.setTitle(title);
		initToolbar(toolbar);
	}

	/**
	 * 获取当前Fragment的名称
	 * @return
	 */
	public String getFragmentName(){
		return TAG;
	}

	/** 初始化方法 */
	public void init() {}
	/** 设置布局 */
	protected abstract int getContentViewId();
	/** 初始化View的抽象方法 */
	public abstract void initViews(View view);
	/** 初始化数据 */
	protected void initData() {}
	/** 初始化事件的抽象方法 */
	public abstract void initEvents();

}