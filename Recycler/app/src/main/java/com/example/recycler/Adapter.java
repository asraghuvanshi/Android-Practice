package com.example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.VieHolder> {

    private List<MyListData> monthlist;
    public Adapter(List<MyListData> monthlist){
        this.monthlist = monthlist;
    }
    @NonNull
    @Override
    public Adapter.VieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new VieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.VieHolder holder, int position) {
        int image_resource = monthlist.get(position).getImageId();
        String monthName = monthlist.get(position).getMonth_Name();
        int monthId = monthlist.get(position).getMonth_Id();
        holder.setData(image_resource ,monthName,monthId);
    }

    @Override
    public int getItemCount() {
        return monthlist.size();
    }

    public class VieHolder extends RecyclerView.ViewHolder {
        private TextView textView1 ,textView2;
        private ImageView imageView;

        public VieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view1);
            textView1 = itemView.findViewById(R.id.month_name);
            textView2 = itemView.findViewById(R.id.month_id);
        }

        public void setData(int image_resource, String monthName, int monthId) {
            imageView.setImageResource(image_resource);
            textView1.setText(monthName);
            textView2.setText(monthId);
        }
    }
}
