package com.h5190048.rabia_kose_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190048.rabia_kose_final.R;
import com.h5190048.rabia_kose_final.model.AgacModel;
import com.h5190048.rabia_kose_final.util.GlideUtil;


import java.util.List;

public class AgacAdaptor extends RecyclerView.Adapter<AgacViewHolder> {

    List<AgacModel> agaclar;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClik(int position);
    }
    public AgacAdaptor(List<AgacModel> agaclar, Context context, OnItemClickListener listener) {
        this.agaclar = agaclar;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public AgacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_agac,parent,false);
        return new AgacViewHolder(itemView,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull AgacViewHolder viewHolder, int position) {
        viewHolder.txtAgacAdi.setText(agaclar.get(position).getAdi());
        viewHolder.txtAilesicv.setText(agaclar.get(position).getAilesi());
        viewHolder.txtBilimselAdicv.setText(agaclar.get(position).getBilimselAdi());

        GlideUtil.resmiIndiripGoster(context,agaclar.get(position).getKucukFotoUrl(),viewHolder.imgAgacLogo);
    }
    @Override
    public int getItemCount() {
        return agaclar.size();
    }
}