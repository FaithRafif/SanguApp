package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSangu extends RecyclerView.Adapter<AdapterSangu.SanguViewHolder> {
    ArrayList<SanguModel> sanguModels;
    private onSanguClick listener;


    public AdapterSangu(ArrayList<SanguModel> sanguModels, onSanguClick listener) {
        this.sanguModels = sanguModels;
        this.listener = listener;
    }

    public interface onSanguClick{
        void onSanguClick(SanguModel sanguModel);
    }

    public static class SanguViewHolder extends RecyclerView.ViewHolder {

        public SanguViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public SanguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SanguViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sanguModels.size();
    }
}
