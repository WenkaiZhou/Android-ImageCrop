package com.kevin.imagecrop.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kevin.imagecrop.R;
import com.kevin.imagecrop.fragment.basic.PictureSelectFragment;

import butterknife.Bind;

/**
 * 版权所有：XXX有限公司
 *
 * MainFragment
 *
 * @author zhou.wenkai ,Created on 2016-5-5 10:25:49
 * 		   Major Function：<b>MainFragment</b>
 *
 *         注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * @author mender，Modified Date Modify Content:
 */
public class MainFragment extends PictureSelectFragment {

    /** Toolbar */
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.main_frag_picture_iv)
    ImageView mPictureIv;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initViews(View view) {
        initToolbar(toolbar);
    }

    @Override
    public void initEvents() {
        // 设置图片点击监听
        mPictureIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPicture();
            }
        });
        // 设置裁剪图片结果监听
        setOnPictureSelectedListener(new OnPictureSelectedListener() {
            @Override
            public void onPictureSelected(Uri fileUri, Bitmap bitmap) {
                mPictureIv.setImageBitmap(bitmap);

                String filePath = fileUri.getEncodedPath();
                String imagePath = Uri.decode(filePath);
                Toast.makeText(mContext, "图片已经保存到:" + imagePath, Toast.LENGTH_LONG).show();
            }
        });
    }

}
