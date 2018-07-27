package com.zyhp.restaurantmanagement.adapter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.zyhp.restaurantmanagement.R;
import com.zyhp.restaurantmanagement.entity.Member;



import java.util.List;

/**
 * Created by abc on 2017/4/28.
 */
public class MemberRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }


    private List<Member> list;
    private Handler myhandler;
    public MemberRecyclerViewAdapter(List<Member> list, Handler handler) {
        this.list = list;
        myhandler = handler;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_memberset, parent, false);


        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Member member = list.get(position);
        //判断是否设置了监听器

        //为ItemView设置监听器
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mOnItemClickListener", "mOnItemClickListener");
                Message message = Message.obtain();
                message.arg1 = position;
                message.what = 0;
                myhandler.sendMessage(message);

            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.i("mOnItemClickListener", "mOnItemLongClickListener");
                int position = holder.getLayoutPosition();
                Message message = Message.obtain();
                message.arg1 = position;
                message.what = 1;
                myhandler.sendMessage(message);
                return true;
            }
        });

        holder.recyclerView_item_name.setText(member.getName());
        holder.recyclerView_item_money.setText(member.getMoney());
        holder.recyclerView_item_integral.setText(member.getIntegral()+"");
        holder.recyclerView_item_number.setText(member.getNumber());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView recyclerView_item_name,recyclerView_item_money,recyclerView_item_integral,recyclerView_item_number;


    public MyViewHolder(View itemView) {
        super(itemView);
        recyclerView_item_name=(TextView) itemView.findViewById(R.id.recyclerView_item_name);
        recyclerView_item_money=(TextView) itemView.findViewById(R.id.recyclerView_item_money);
        recyclerView_item_integral=(TextView) itemView.findViewById(R.id.recyclerView_item_integral);
        recyclerView_item_number=(TextView) itemView.findViewById(R.id.recyclerView_item_number);
    }


}

