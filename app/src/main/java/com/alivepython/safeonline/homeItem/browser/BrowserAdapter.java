package com.alivepython.safeonline.homeItem.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.safeonline.HomeItemGridPojo;
import com.alivepython.safeonline.R;

import java.util.ArrayList;

public class BrowserAdapter extends RecyclerView.Adapter<BrowserAdapter.MyHolder> {

    Context context;
    ArrayList<HomeItemGridPojo> arrayList;

    public BrowserAdapter(Context context, ArrayList<HomeItemGridPojo> arrayList) {
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
            if (arrayList.get(position).getTitle().equals("Firefox")){
                String full_address = context.getResources().getString(R.string.firefox);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Brave")){
                String full_address = context.getResources().getString(R.string.brave);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Yandex")){
                String full_address = context.getResources().getString(R.string.yandex);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Vivaldi")){
                String full_address = context.getResources().getString(R.string.vivaldi);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Tor")){
                String full_address = context.getResources().getString(R.string.tor);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Opera")){
                String full_address = context.getResources().getString(R.string.opera);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(full_address));
                context.startActivity(i);
            }
            if (arrayList.get(position).getTitle().equals("Avast")){
                String full_address = context.getResources().getString(R.string.avast);
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
