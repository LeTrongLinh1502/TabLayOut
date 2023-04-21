package com.example.baitapchuong6.Adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.baitapchuong6.Fragment.FragmentAdd;
import com.example.baitapchuong6.Fragment.FragmentList;
import com.example.baitapchuong6.Fragment.FragmentSearch;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numberPage=3;

    public FragmentAdapter(@NonNull FragmentManager fm, int number) {
        super(fm, number);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentAdd();
            case 1: return new FragmentSearch();
            case 2: return new FragmentList();
            default:return new FragmentAdd();
        }
    }
    @Override
    public int getCount() {
        return numberPage;
    }

}
