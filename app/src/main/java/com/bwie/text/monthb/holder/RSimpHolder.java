package com.bwie.text.monthb.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.text.monthb.R;

/**
 * Created by dell on 2017/4/4.
 */

public class RSimpHolder extends RecyclerView.ViewHolder {

    public final TextView item_text;

    public RSimpHolder(View itemView) {
        super(itemView);
        item_text = (TextView) itemView.findViewById(R.id.item_text);
    }
}
