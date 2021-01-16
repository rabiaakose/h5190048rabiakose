package com.h5190048.rabia_kose_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190048.rabia_kose_final.R;
import com.h5190048.rabia_kose_final.adaptor.AgacAdaptor;


public class AgacViewHolder extends RecyclerView.ViewHolder {
    ImageView imgAgacLogo;
    TextView txtBilimselAdicv, txtAilesicv, txtAgacAdi;
    public AgacViewHolder(@NonNull View cardView, AgacAdaptor.OnItemClickListener listener) {
        super(cardView);
        imgAgacLogo=cardView.findViewById(R.id.imgAgacLogo);
        txtAgacAdi=cardView.findViewById(R.id.txtAgacAdi);
        txtAilesicv=cardView.findViewById(R.id.txtAilesicv);
        txtBilimselAdicv=cardView.findViewById(R.id.txtBilimselAdicv);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}