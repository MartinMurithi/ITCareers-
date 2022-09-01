package com.wachiramartin.recyclerviewonclicklistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
        //A ViewHolder describes an item view and metadata about its place within the RecyclerView.
        private final RecyclerViewInterface recyclerViewInterface;
        List<Career> careerList;
        Context context;

        public RecyclerViewAdapter(RecyclerViewInterface recyclerViewInterface, List<Career> careerList, Context context) {
            this.recyclerViewInterface = recyclerViewInterface;
            this.careerList = careerList;
            this.context = context;
        }

        @NonNull
        @Override
        // (On Create view Holder)Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_career_list, parent,false);
            MyViewHolder holder = new MyViewHolder(view, recyclerViewInterface);
            return holder;
        }


        //This method is called by RecyclerView to display the data at the specified position.
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.iv_logoJ.setImageResource(careerList.get(position).getCareerImages());
            holder.tv_logoJ.setText(careerList.get(position).getCareerName());

        }


        @Override
        //Returns the total number of items in the data set held by the adapter.
        public int getItemCount() {
            return careerList.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView iv_logoJ;
            TextView tv_logoJ;
            ConstraintLayout careerListLayoutJ;

            public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
                super(itemView);
                iv_logoJ = itemView.findViewById(R.id.iv_Logo);
                tv_logoJ = itemView.findViewById(R.id.tv_logo);
                careerListLayoutJ = itemView.findViewById(R.id.careerListLayout);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(recyclerViewInterface != null){
                            int pos = getAdapterPosition();

                            if(pos != RecyclerView.NO_POSITION){
                                recyclerViewInterface.onItemClick(pos);
                            }
                        }
                    }
                });
            }
        }
    }
