package com.example.projecttwoversion.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projecttwoversion.Adapter.Adapter_B;
import com.example.projecttwoversion.R;


public class BFragment extends Fragment {
    private RecyclerView rc_information;
    //private List<Bean_b> date = new ArrayList<>();
    private String a[] = {"温度","转速","锁水平直","冷却流速","剩余液氮","剩余液氦"};
    private String b[] = {"35","120","34","234","2342","2455"};
    private int[] imgres = new int[]{};
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.fragment_b,container,false);

        //initadapter();
        //initdate();

        return v;
    }

//    private void initadapter() {
//        rc_information = v.findViewById(R.id.rc_information);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        rc_information.setLayoutManager(linearLayoutManager);
//        //给item设置分割线
//        rc_information.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
//        Adapter_B adapter = new Adapter_B(a,b,getActivity());
//        rc_information.setAdapter(adapter);
//    }

//    private void initdate() {
//        for (int i = 0; i < 7; i++){
//            Bean_b msg = new Bean_b();
//            msg.setTv_one("1"+i);
//            //msg.setTv_two(b[i]);
//            date.add(msg);
//        }

    }
