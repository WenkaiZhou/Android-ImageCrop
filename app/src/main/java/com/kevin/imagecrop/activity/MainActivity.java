package com.kevin.imagecrop.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.kevin.imagecrop.R;
import com.kevin.imagecrop.fragment.MainFragment;
/**
 * 版权所有：XXX有限公司
 *
 * MainActivity
 *
 * @author zhou.wenkai ,Created on 2016-5-5 10:24:35
 * 		   Major Function：<b>主界面</b>
 *
 *         注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * @author mender，Modified Date Modify Content:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMainFragment();
    }

    /**
     * 初始化内容Fragment
     *
     * @return void
     */
    public void initMainFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MainFragment mFragment = MainFragment.newInstance();
        transaction.replace(R.id.main_act_container, mFragment, mFragment.getClass().getSimpleName());
        transaction.commit();
    }
}
