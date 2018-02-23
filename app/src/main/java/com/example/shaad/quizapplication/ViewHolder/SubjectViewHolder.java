package com.example.shaad.quizapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shaad.quizapplication.Interface.ItemClickListener;
import com.example.shaad.quizapplication.R;

/**
 * Created by Shaad on 13-11-2017.
 */

public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView subject_name;
    public TextView subjext_code;

    private ItemClickListener itemClickListener;

    public SubjectViewHolder(View itemView) {
        super(itemView);
        subject_name = (TextView) itemView.findViewById(R.id.subject_name);
        subjext_code = (TextView) itemView.findViewById(R.id.subject_code);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);

    }
}
