package com.bwie.text.monthb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.bwie.text.monthb.OnChildclickListener;
import com.bwie.text.monthb.R;
import com.bwie.text.monthb.holder.RSimpHolder;

import java.util.List;

/**
 * Created by dell on 2017/4/4.
 */

public class RSimpAdapter extends RecyclerView.Adapter<RSimpHolder> {
    private Context context;
    private List<String> list;
    private OnChildclickListener listener;

    public void setOnChildClickListener(OnChildclickListener listener) {
        this.listener = listener;
    }

    public RSimpAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RSimpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //布局初始错误，写法这么写
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        RSimpHolder holder = new RSimpHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RSimpHolder holder, final int position) {
        holder.item_text.setText(list.get(position));

        holder.item_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onChildClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
