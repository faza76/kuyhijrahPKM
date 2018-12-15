package com.example.pkm.kuyhijrahpkm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> todos = new ArrayList<>();
    private ArrayList<String> cb = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> cb,ArrayList<String> todoss, Context mContext) {
        this.todos = todoss;
        this.mContext = mContext;
        this.cb = cb;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_todo, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");

        viewHolder.tekstodo.setText(todos.get(i));
        if (cb.get(i) == "1"){
            viewHolder.cb_todos.setChecked(true);
        }else{
            viewHolder.cb_todos.setChecked(false);
        }



        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + todos.get(i));

                Toast.makeText(mContext,todos.get(i),Toast.LENGTH_SHORT).show();
                viewHolder.cb_todos.setChecked(true);
            }
        });



    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tekstodo;
        RelativeLayout relativeLayout;
        CheckBox cb_todos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tekstodo = itemView.findViewById(R.id.teks_todo);
            relativeLayout = itemView.findViewById(R.id.rela_layout);
            cb_todos = itemView.findViewById(R.id.cb_todo);
        }
    }
}
