package com.example.bmollj.getdrunk.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.bmollj.getdrunk.Detail;
import com.example.bmollj.getdrunk.R;
import com.example.bmollj.getdrunk.model.Bar;

import java.util.ArrayList;

public class BarListAdapter extends RecyclerView.Adapter<BarListAdapter.BarViewHolder> implements View.OnClickListener {
    private ArrayList<Bar> bars = new ArrayList<>();
    CustomItemClickListener clickListener;

    Context context;

    public BarListAdapter(ArrayList<Bar> bars) {
        this.bars = bars;
    }

    @NonNull
    @Override
    public BarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View barView = inflater.inflate(R.layout.list_item, parent, false);

        BarViewHolder barViewHolder = new BarViewHolder(barView);
        return barViewHolder;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBindViewHolder(@NonNull BarViewHolder barViewHolder, int position) {
        Bar bar = bars.get(position);
        TextView barName = barViewHolder.barName;
        barName.setText(bar.getName());
        TextView isOpen = barViewHolder.isOpen;
        isOpen.setText(bar.isOpen());
        RatingBar barRating = barViewHolder.barRating;
        barRating.setRating(new Float(bar.getBewertung()));
        clickListener = new CustomItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(v.getContext(), Detail.class);
                Bar selected = bars.get(position);
                intent.putExtra("id", selected.getId());
                intent.putExtra("name", selected.getName());
                intent.putExtra("bewertung", selected.getBewertung());

                v.getContext().startActivity(intent);
            }
        };

    }

    @Override
    public int getItemCount() {
        return bars.size();
    }

    public void setClickListener(CustomItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public class BarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView barName;
        TextView isOpen;

        RatingBar barRating;
        private Context context;

        public BarViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            barName = (TextView) itemView.findViewById(R.id.name);
            isOpen = (TextView) itemView.findViewById(R.id.open);
            barRating = (RatingBar) itemView.findViewById(R.id.bewertung);
        }


        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());


        }


    }


}

