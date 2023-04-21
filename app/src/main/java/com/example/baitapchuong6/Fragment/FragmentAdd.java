package com.example.baitapchuong6.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitapchuong6.Adapter.CatAdapter;
import com.example.baitapchuong6.Adapter.SpinnerAdapter;
import com.example.baitapchuong6.MainActivity;
import com.example.baitapchuong6.Model.Cat;
import com.example.baitapchuong6.R;

public class FragmentAdd extends Fragment implements CatAdapter.CatItemListener{
    private CatAdapter adapter;
    private Spinner spinner;
    private EditText editName,editPrice,editDes;
    private Button btnAdd,btnUpdate;
    private RecyclerView recyclerView;
    private int posCurrent;
    private int[] imgs={R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter=new CatAdapter((MainActivity)getActivity());
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i=spinner.getSelectedItem().toString();
                int img;
                try {
                    img=imgs[Integer.parseInt(i)];
                    double price =Double.parseDouble(editPrice.getText().toString());
                    Cat cat=new Cat(img,editName.getText().toString(),editDes.getText().toString(),price);
                    adapter.add(cat);

                }catch (NumberFormatException e){

                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i=spinner.getSelectedItem().toString();
                int img;
                try {
                    img=imgs[Integer.parseInt(i)];
                    double price =Double.parseDouble(editPrice.getText().toString());
                    Cat cat=new Cat(img,editName.getText().toString(),editDes.getText().toString(),price);
                    adapter.update(cat,posCurrent);
                    btnUpdate.setVisibility(View.INVISIBLE);
                    btnAdd.setVisibility(View.VISIBLE);
                }catch (NumberFormatException e){

                }
            }
        });
    }

    private void initView(View view) {
        spinner=view.findViewById(R.id.spinner);
        SpinnerAdapter spinnerAdapter=new SpinnerAdapter(getContext(),imgs);
        spinner.setAdapter(spinnerAdapter);
        editName=view.findViewById(R.id.editName);
        editPrice=view.findViewById(R.id.editPrice);
        editDes=view.findViewById(R.id.editDes);
        btnAdd=view.findViewById(R.id.btnAdd);
        btnUpdate=view.findViewById(R.id.btnUpdate);
        recyclerView=view.findViewById(R.id.reView);
        btnUpdate.setVisibility(view.INVISIBLE);

    }

    @Override
    public void onItemClick(View view, int postion) {
        btnAdd.setVisibility(View.INVISIBLE);
        btnUpdate.setVisibility(View.VISIBLE);
        posCurrent=postion;
        Cat cat =adapter.getItem(postion);
        int img=cat.getImg();
        int p=0;
        for(int i=0;i<imgs.length;i++){
            if(img==imgs[i]){
                p=i;
                break;
            }
        }
        spinner.setSelection(p);
        editName.setText(cat.getName());
        editPrice.setText(cat.getPrice()+"");
        editPrice.setText(cat.getDes());
    }
}
