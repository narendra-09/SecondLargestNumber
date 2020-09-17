package com.example.secondlargestnumber;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<AddNumber> arrayList;

    public MyAdapter(Context context, ArrayList<AddNumber> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        Log.d("Construct", "MyAdapter: ");
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.display_numbers, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddNumber addNumber = arrayList.get(position);
        String value = String.valueOf(addNumber.getNumber());
        holder.textView.setText(value);
        holder.textView.setBackgroundResource(R.drawable.text_background);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.the_number);
        }
    }
}
