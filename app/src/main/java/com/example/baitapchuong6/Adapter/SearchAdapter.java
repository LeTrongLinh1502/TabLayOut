package com.example.baitapchuong6.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapchuong6.Model.Cat;
import com.example.baitapchuong6.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<Cat> mSearch;

    public SearchAdapter() {
        mSearch=new ArrayList<>();
    }
    public void setList(List<Cat> mSearch){
        this.mSearch=mSearch;
        notifyDataSetChanged();
    }

    public List<Cat> getList() {
        return mSearch;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Cat cat =mSearch.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice()+"");
        holder.des.setText(cat.getDes());
    }

    @Override
    public int getItemCount() {
        return mSearch.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,price,des;
        public SearchViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.item_img);
            name=view.findViewById(R.id.item_name);
            price=view.findViewById(R.id.item_price);
            des=view.findViewById(R.id.item_des);
        }
    }
}
