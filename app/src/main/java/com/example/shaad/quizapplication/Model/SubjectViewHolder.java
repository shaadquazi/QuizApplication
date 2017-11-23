package com.example.shaad.quizapplication.Model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shaad.quizapplication.R;

public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView subjectName, subjectCode, subjectCredit;
    private ItemClickListener itemClickListener;

    public SubjectViewHolder(View itemView) {
        super(itemView);
        subjectName = (TextView) itemView.findViewById(R.id.subjectName);
        subjectCredit = (TextView) itemView.findViewById(R.id.subjectCredit);
        subjectCode = (TextView) itemView.findViewById(R.id.subjectCode);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
