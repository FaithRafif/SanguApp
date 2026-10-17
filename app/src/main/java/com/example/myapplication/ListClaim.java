package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListClaim extends Fragment {
    RecyclerView rvlist;
    private AdapterSangu adapter;
    EditText edSearch;
    ArrayList<SanguModel>sanguModels;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup cotainer, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.claim_list_screen, cotainer, false);
        edSearch = view.findViewById(R.id.edSearch);
        rvlist = view.findViewById(R.id.rvList);
        sanguModels = new ArrayList<>();
        adapter = new AdapterSangu(sanguModels, ListClaim::openDetail);
        rvlist.setAdapter(adapter);
        return view;
    }

    public static void openDetail(SanguModel sanguModel){
        Bundle bundle = new Bundle();
        bundle.putInt("id", sanguModel.getId());
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

    }
}
