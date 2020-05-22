package com.example.cokoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.LikesViewHolder> {
    private ArrayList<LikesInfo> arrayList;
    private Context context;

    public LikesAdapter(ArrayList<LikesInfo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public LikesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        LikesViewHolder holder = new LikesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LikesViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile())
//                .into(holder.iv_profile);

//        Picasso.with(holder.itemView)

//        String url = arrayList.get(position).getProfile();
//        Picasso.get()
//                .load(url)
////                .resize(80, 80)
//                .into(holder.iv_profile);


//        String url = arrayList.get(position).getProfile();
//        Picasso.get()
//                .load(url)
////                .resize(80, 80)
//                .into(holder.iv_profile);

//        String picUrl = arrayList.get(position).get

//        holder.tv_id.setText(arrayList.get(position).getId());
//        holder.tv_pw.setText(String.valueOf(arrayList.get(position).getPw()));
//        holder.tv_userName.setText(arrayList.get(position).getUserName());

        String picUrl = arrayList.get(position).getPlacePic();
        Picasso.get().load(picUrl)
//                .resize(80, 80)
                .into(holder.placePic);

        holder.placeName.setText(arrayList.get(position).getPlaceName());
        holder.placeLocation.setText(arrayList.get(position).getPlaceLocation());


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class LikesViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_profile;
//        TextView tv_id;
//        TextView tv_pw;
//        TextView tv_userName;

        ImageView placePic;
        TextView placeName;
        TextView placeLocation;

        public LikesViewHolder(@NonNull View itemView) {
            super(itemView);
//            this.iv_profile = itemView.findViewById(R.id.profile);
//            this.tv_id = itemView.findViewById(R.id.tv_id);
//            this.tv_pw = itemView.findViewById(R.id.tv_pw);
//            this.tv_userName = itemView.findViewById(R.id.userName);
            this.placePic = itemView.findViewById(R.id.profile_pic);
            this.placeName = itemView.findViewById(R.id.place_name);
            this.placeLocation = itemView.findViewById(R.id.place_location);

        }
    }

}
