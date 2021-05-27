package com.example.projecttwoversion.AllPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projecttwoversion.Fragment.AFragment;
import com.example.projecttwoversion.Fragment.BFragment;
import com.example.projecttwoversion.R;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {
    //声明变量
    private TextView tv_one,tv_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        //获取Fragmnet管理器并且获取fragment事务（开启事务）
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //给FragmentLayout容器添加fragment
        transaction.add(R.id.id_fragment,new AFragment());
        //提交事务
        transaction.commit();
        //将变量关联控件
        tv_one = findViewById(R.id.btn_sample);
        tv_two = findViewById(R.id.btn_state);
        //给控件添加点击事件
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //获取Fragmnet管理器并且获取fragment事务（开启事务）
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btn_sample:
                //点击第一个tv_one切换成AFragment
                transaction.replace(R.id.id_fragment,new AFragment());
                break;
            case R.id.btn_state:
                //点击tv_two切换到BFragment
                transaction.replace(R.id.id_fragment,new BFragment());
                break;
        }
        //最后也提交事务一下
        transaction.commit();
    }
}