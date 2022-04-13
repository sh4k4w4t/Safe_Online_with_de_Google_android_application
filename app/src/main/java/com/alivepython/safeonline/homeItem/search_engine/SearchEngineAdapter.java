package com.alivepython.safeonline.homeItem.search_engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.safeonline.HomeItemGridPojo;
import com.alivepython.safeonline.R;

import java.util.ArrayList;

public class SearchEngineAdapter extends RecyclerView.Adapter<SearchEngineAdapter.MyHolder> {

    Context context;
    ArrayList<HomeItemGridPojo> arrayList;

    public SearchEngineAdapter(Context context, ArrayList<HomeItemGridPojo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item_custom_recycler_grid,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.image.setImageResource(arrayList.get(position).getImage());

        holder.itemView.setOnClickListener(v -> {
            if (arrayList.get(position).getTitle().equals("DuckDuckGo")){
                String full_address = context.getResources().getString(R.string.duckduckgo);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Searx.me")){
                String full_address = context.getResources().getString(R.string.searx);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Ecosia")){
                String full_address = context.getResources().getString(R.string.ecosia);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("StartPage")){
                String full_address = context.getResources().getString(R.string.startpage);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Qwant")){
                String full_address = context.getResources().getString(R.string.qwant);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Yandex")) {
                String full_address = context.getResources().getString(R.string.yandex);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.home_item_recyclerView_title_id);
            image=itemView.findViewById(R.id.home_item_recyclerView_image_id);
        }
    }
}
