package com.example.projecttwoversion.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttwoversion.Bean.BeanStart;
import com.example.projecttwoversion.R;

import java.util.List;

public class AdapterStart extends RecyclerView.Adapter<AdapterStart.MyViewHold> {
    private List<BeanStart> msg;
    private Context mcontext;


    public AdapterStart(List<BeanStart> msg, Context mcontext) {
        this.msg = msg;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_equipment,null);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, int position) {
        holder.tv_oen.setText(msg.get(position).getEquipment());
        holder.tv_two.setText(msg.get(position).getUser());
    }

    @Override
    public int getItemCount() {
        return msg.size();
    }

    public class MyViewHold extends RecyclerView.ViewHolder{
        private TextView tv_oen,tv_two;
        public MyViewHold(@NonNull View itemView) {
            super(itemView);
            tv_oen = itemView.findViewById(R.id.equipment_name);
            tv_two = itemView.findViewById(R.id.user_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    monRecycleritemclicklistener.onrcycyleritclick(getAdapterPosition());
                }
            });
        }
    }

    /**
     * 设置item点击监听
     */
    private OnRecycleritemclicklistener monRecycleritemclicklistener;
    public void setRecyclerItemClickListener(OnRecycleritemclicklistener listenenr){
        monRecycleritemclicklistener = listenenr;
    }
    public interface OnRecycleritemclicklistener{
        void onrcycyleritclick(int position);
    }
}
