package com.example.projecttwoversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.projecttwoversion.Adapter.AdapterStart;
import com.example.projecttwoversion.AllPage.SampleActivity;
import com.example.projecttwoversion.Bean.BeanStart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rc_oen;
    private List<BeanStart> date = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc_oen = findViewById(R.id.rc_one);
        //给item设置分割线
        rc_oen.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //设置成线下布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc_oen.setLayoutManager(linearLayoutManager);
        //设置适配器
        AdapterStart apater = new AdapterStart(date,this);
        rc_oen.setAdapter(apater);
        GatDate();

        apater.setRecyclerItemClickListener(new AdapterStart.OnRecycleritemclicklistener() {
            @Override
            public void onrcycyleritclick(int position) {
                Intent intent = new Intent(MainActivity.this, SampleActivity.class);
                startActivity(intent);
                Log.e("TAG","点击了第"+(position+1)+"个");
            }
        });
    }

    private void GatDate() {
        for (int i = 0;i < 100; i++){
            BeanStart msg = new BeanStart();
            msg.setEquipment("设备"+i);
            msg.setUser("用户"+i);
            date.add(msg);
        }
    }
}