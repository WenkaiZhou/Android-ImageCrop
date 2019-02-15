/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package com.kevin.imagecrop.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kevin.dialog.BaseDialog;
import com.kevin.imagecrop.R;

/**
 * PictureSelectorDialog
 *
 * @author zhouwenkai@baidu.com, Created on 2019-02-14 12:50:46
 * Major Function：<b></b>
 * <p/>
 * Note: If you modify this class please fill in the following content as a record.
 * @author mender，Modified Date Modify Content:
 */
public class PictureSelectorDialog extends BaseDialog implements View.OnClickListener {

    private static final String TAG = "SelectPictureDialog";
    private Button takePhotoBtn, pickPictureBtn, cancelBtn;

    private OnSelectedListener mOnSelectedListener;

    public static PictureSelectorDialog getInstance() {
        PictureSelectorDialog dialog = new PictureSelectorDialog();
        // 设置屏蔽返回键
        dialog.canceledBack(false)
                // 设置屏蔽对话框点击外部关闭
                .canceledOnTouchOutside(false)
                // 设置对话框在底部
                .gravity(Gravity.BOTTOM)
                // 设置宽度为屏幕宽度
                .width(1f)
                // 设置黑色透明背景
                .dimEnabled(false)
                // 设置动画
                .animations(android.R.style.Animation_InputMethod);
        return dialog;
    }

    @Override
    public View createView(Context context, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.layout_picture_selector, parent, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        takePhotoBtn = view.findViewById(R.id.picture_selector_take_photo_btn);
        pickPictureBtn = view.findViewById(R.id.picture_selector_pick_picture_btn);
        cancelBtn = view.findViewById(R.id.picture_selector_cancel_btn);
        // 设置按钮监听
        takePhotoBtn.setOnClickListener(this);
        pickPictureBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.picture_selector_take_photo_btn:
                if (null != mOnSelectedListener) {
                    mOnSelectedListener.OnSelected(v, 0);
                }
                break;
            case R.id.picture_selector_pick_picture_btn:
                if (null != mOnSelectedListener) {
                    mOnSelectedListener.OnSelected(v, 1);
                }
                break;
            case R.id.picture_selector_cancel_btn:
                if (null != mOnSelectedListener) {
                    mOnSelectedListener.OnSelected(v, 2);
                }
                break;
            default:
                break;
        }
    }

    public void show(FragmentActivity activity) {
        super.show(activity.getSupportFragmentManager(), TAG);
    }

    public void show(Fragment fragment) {
        super.show(fragment.getChildFragmentManager(), TAG);
    }

    /**
     * 设置选择监听
     *
     * @param l
     */
    public void setOnSelectedListener(OnSelectedListener l) {
        this.mOnSelectedListener = l;
    }

    /**
     * 选择监听接口
     */
    public interface OnSelectedListener {
        void OnSelected(View v, int position);
    }
}
