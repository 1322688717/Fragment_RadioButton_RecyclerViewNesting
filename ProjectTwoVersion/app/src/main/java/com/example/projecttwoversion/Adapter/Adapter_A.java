package com.example.projecttwoversion.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.projecttwoversion.AllPage.ClickIntentActivity;
import com.example.projecttwoversion.Bean.Bean_a;
import com.example.projecttwoversion.Bean.ListBean;
import com.example.projecttwoversion.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_A  extends RecyclerView.Adapter<Adapter_A.MainRecyclerViewHolder> {

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        MainRecyclerViewHolder viewHolder = new MainRecyclerViewHolder(item);
        viewHolder.setIsRecyclable(false);//取消viewHolder的重用机制。没有这句话子布局subView会被重复添加。

        return viewHolder;
    }

    //第一层数据设置
    @Override
    public void onBindViewHolder(MainRecyclerViewHolder viewHolder, int position) {
        if (viewHolder instanceof MainRecyclerViewHolder) {
            MainRecyclerViewHolder mvh = (MainRecyclerViewHolder) viewHolder;
            mvh.tv_two.setText(""+(position + 1));
            mvh.tv_three.setText("admin" + (position + 1));
            mvh.tv_four.setText("00:00");
            if (position%2==1){
                mvh.tv_five.setText("watting");
            }else  mvh.tv_five.setText("done");
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    protected static class MainRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_two,tv_three,tv_four,tv_five;

        public MainRecyclerViewHolder(View itemView) {
            super(itemView);
            tv_two = itemView.findViewById(R.id.tv_two);
            tv_three = itemView.findViewById(R.id.tv_three);
            tv_four = itemView.findViewById(R.id.tv_four);
            tv_five = itemView.findViewById(R.id.tv_five);
            //item点击事件监听
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int flag = 1;//用于判断当前是展开还是收缩状态
                    //获取外层linearlayout布局
                    LinearLayout linearLayout = view.findViewById(R.id.main_tree_root_layout);
                    //new一个RecyclerView来当展开的子布局。
                    RecyclerView subView = new RecyclerView(view.getContext());
                    SubViewAdapter adapter = new SubViewAdapter();
                    subView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    subView.setAdapter(adapter);
                    //当flag不为空的时候,获取flag的值。
                    if (linearLayout.getTag() != null) {
                        flag = (int) linearLayout.getTag();
                    }
                    //当flag为1时，添加子布局。否则，移除子布局。
                    if (flag == 1) {
                        linearLayout.addView(subView);
                        subView.setTag(101);
                        linearLayout.setTag(2);
                    } else {
                        linearLayout.removeView(view.findViewWithTag(101));
                        linearLayout.setTag(1);
                    }
                }
            });
        }
    }


    //==========================================================================================================

    private static class SubViewAdapter extends RecyclerView.Adapter {
        private Context context;
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SubViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_detail, parent, false));
        }

        //第二层数据设置
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            if (viewHolder instanceof SubViewHolder) {
                SubViewHolder mvh = (SubViewHolder) viewHolder;

                //创建布局管理器并设置适配器
                mvh.rv.setLayoutManager(new LinearLayoutManager(context));
                MyListAdapter myListAdapter = new MyListAdapter();
                mvh.rv.setAdapter(myListAdapter);

                //添加第三层表格数据
                List<ListBean> list = new ArrayList<>();
                for (int i = 0 ; i < 4 ; i++){
                    ListBean msg = new ListBean();
                    msg.setEqupment("experiment");
                    msg.setSolvent("H2CO3");
                    msg.setState("watting");
                    msg.setTime("00：00");
                    list.add(msg);
                }
                myListAdapter.addItems(list);
            }

        }

        @Override
        public int getItemCount() {
            return 1;
        }

        private static class SubViewHolder extends RecyclerView.ViewHolder {

            RecyclerView rv;

            private SubViewHolder(View itemView) {
                super(itemView);
                rv = itemView.findViewById(R.id.rv_in);
            }
        }
    }
//=======================================================================================================================

    //第三层数据
    private static class MyListAdapter extends RecyclerView.Adapter {

        List<ListBean> list = new ArrayList<>();

        public void addItems(List<ListBean> list) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder instanceof MyViewHolder) {
                MyViewHolder wtvh = (MyViewHolder) viewHolder;
                //wtvh.tv_finally.setText(list.get(i).getName());
                wtvh.one.setText(list.get(i).getEqupment());
                wtvh.two.setText(list.get(i).getSolvent());
                wtvh.three.setText(list.get(i).getTime());
                wtvh.four.setText(list.get(i).getState());

                //点击回调
                wtvh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), ClickIntentActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        static class MyViewHolder extends RecyclerView.ViewHolder {
            TextView one,two,three,four;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                one = itemView.findViewById(R.id.one);
                two = itemView.findViewById(R.id.two);
                three = itemView.findViewById(R.id.three);
                four = itemView.findViewById(R.id.four);

            }
        }

    }

}
