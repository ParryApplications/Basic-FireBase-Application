package com.example.paras.firstfirebaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private Context context;
    private List<Model> list;

    public RecyclerViewAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.read_layout,parent,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position)
    {
        Model model = list.get(position);

        holder.name_view.setText(model.getName_id());
        holder.email_view.setText(model.getEmail_send_id());
        holder.pass_view.setText(model.getPass_send_id());
        holder.age_view.setText(model.getAge_send_id());
        holder.number_view.setText(model.getPhone_send_id());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name_view,email_view,pass_view,age_view,number_view;
        private String user_id;

        public ViewHolder(@NonNull View itemView , Context ctx)
        {
            super(itemView);

            context = ctx;

            name_view = itemView.findViewById(R.id.name_read_id);
            email_view = itemView.findViewById(R.id.email_read_id);
            pass_view = itemView.findViewById(R.id.pass_read_id);
            age_view = itemView.findViewById(R.id.age_read_id);
            number_view = itemView.findViewById(R.id.phone_read_id);

            user_id = null;

        }
    }
}
