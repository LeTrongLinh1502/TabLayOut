package com.example.baitapchuong6.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapchuong6.MainActivity;
import com.example.baitapchuong6.Model.Cat;
import com.example.baitapchuong6.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat> mList;
    private CatItemListener itemListener;
    private MainActivity mainActivity;

    public CatAdapter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        mList=new ArrayList<>();

    }

    public void setItemListener(CatItemListener itemListener) {

        this.itemListener = itemListener;
    }

    public Cat getItem(int pos){
        return mList.get(pos);
    }
    public List<Cat> getListCat(){
        return mList;
    }
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat=mList.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice()+"");
        holder.des.setText(cat.getDes());

//        holder.des.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "okokok",Toast.LENGTH_SHORT).show();
//            }
//        });
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(view.getContext());
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn xóa item này không ?");
                builder.setIcon(R.drawable.ic_remove);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mList.remove(position);
                        notifyDataSetChanged();
                        mainActivity.list=mList;
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView name,price,des;
        Button btnRemove;

        public CatViewHolder(@NonNull View view) {
            super(view);
            img=view.findViewById(R.id.item_img);
            name=view.findViewById(R.id.item_name);
            price=view.findViewById(R.id.item_price);
            des=view.findViewById(R.id.item_des);
            btnRemove=view.findViewById(R.id.item_btnRemove);
            btnRemove.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null){
                itemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public void add(Cat cat){
        mList.add(cat);
        notifyDataSetChanged();
        mainActivity.list=mList;
    }
    public void update(Cat cat,int pos){
        mList.set(pos,cat);
        notifyDataSetChanged();
        mainActivity.list=mList;
    }
    public  interface CatItemListener{
        void onItemClick(View view,int postion);
    }
}
