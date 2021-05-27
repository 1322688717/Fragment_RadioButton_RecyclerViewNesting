package com.example.projecttwoversion.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttwoversion.Bean.Bean_b;
import com.example.projecttwoversion.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_B extends RecyclerView.Adapter<Adapter_B.MyHoldView> {
    private String a[],b[];
    private Context mcontext;


    public Adapter_B(String[] a, String[] b, Context mcontext) {
        this.a = a;
        this.b = b;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyHoldView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext,R.layout.item_information,null);
        return new MyHoldView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoldView holder, int position) {
        holder.tv_one.setText(a[position]);
        holder.tv_two.setText(b[position]);
    }

    @Override
    public int getItemCount() {
        return a.length;
    }

    public class MyHoldView extends RecyclerView.ViewHolder {
        private TextView tv_one,tv_two;
        public MyHoldView(@NonNull View itemView) {
            super(itemView);
            tv_one= itemView.findViewById(R.id.tv_one);
            tv_two = itemView.findViewById(R.id.tv_two);
        }
    }
}
