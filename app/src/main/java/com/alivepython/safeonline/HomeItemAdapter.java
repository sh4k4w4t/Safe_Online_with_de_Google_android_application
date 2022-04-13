package com.alivepython.safeonline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.safeonline.homeItem.browser.BrowserActivity;
import com.alivepython.safeonline.homeItem.calender.CalenderActivity;
import com.alivepython.safeonline.homeItem.chat_apps.ChatAppsActivity;
import com.alivepython.safeonline.homeItem.drive.DriveActivity;
import com.alivepython.safeonline.homeItem.email.EmailActivity;
import com.alivepython.safeonline.homeItem.host.HostActivity;
import com.alivepython.safeonline.homeItem.map.MapActivity;
import com.alivepython.safeonline.homeItem.os.OsActivity;
import com.alivepython.safeonline.homeItem.remote_client.RemoteActivity;
import com.alivepython.safeonline.homeItem.search_engine.Search_engine;
import com.alivepython.safeonline.homeItem.social_site.SocialSiteActivity;

import java.util.ArrayList;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.MyHolder> {

    Context context;
    ArrayList<HomeItemGridPojo> arrayList;

    public HomeItemAdapter(Context context, ArrayList<HomeItemGridPojo> arrayList) {
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
            if (arrayList.get(position).getTitle().equals("Search Engine")){
                v.getContext().startActivity(new Intent(context, Search_engine.class));
            }
            if (arrayList.get(position).getTitle().equals("Email")){
                v.getContext().startActivity(new Intent(context, EmailActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Drive")){
                v.getContext().startActivity(new Intent(context, DriveActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("OS")){
                v.getContext().startActivity(new Intent(context, OsActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Social Site")){
                v.getContext().startActivity(new Intent(context, SocialSiteActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Calender")){
                v.getContext().startActivity(new Intent(context, CalenderActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Chat Apps")){
                v.getContext().startActivity(new Intent(context, ChatAppsActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Map")){
                v.getContext().startActivity(new Intent(context, MapActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Browser")){
                v.getContext().startActivity(new Intent(context, BrowserActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Remote Client")){
                v.getContext().startActivity(new Intent(context, RemoteActivity.class));
            }
            if (arrayList.get(position).getTitle().equals("Host")){
                v.getContext().startActivity(new Intent(context, HostActivity.class));
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
