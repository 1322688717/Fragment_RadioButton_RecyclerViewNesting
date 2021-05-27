package com.example.projecttwoversion.Fragment;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttwoversion.Adapter.Adapter_A;
import com.example.projecttwoversion.Adapter.Adapter_B;
import com.example.projecttwoversion.Bean.Bean_a;
import com.example.projecttwoversion.Bean.Bean_b;
import com.example.projecttwoversion.R;

import java.util.ArrayList;
import java.util.List;


public class AFragment extends Fragment {
    private RecyclerView rc_information;
    private List<Bean_a> date = new ArrayList<>();
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_a,container,false);

        initadapter();
        initdate();
        return v;
    }

    private void initadapter() {
        rc_information = v.findViewById(R.id.rc_sample);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rc_information.setLayoutManager(linearLayoutManager);
        //给item设置分割线
        //rc_information.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        Adapter_A adapter = new Adapter_A();
        rc_information.setAdapter(adapter);

    }

    private void initdate() {
        for (int i = 1; i < 100; i++) {
            Bean_a msg = new Bean_a();
            msg.setEqupment("实验"+i);
            msg.setSample("样品"+i);
            msg.setSolvent("溶剂"+i);
            msg.setScantime(""+i);
            //msg.setTime(i+":"+i);
            date.add(msg);
        }
    }
}