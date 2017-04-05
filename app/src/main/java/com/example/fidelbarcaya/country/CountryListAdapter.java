package com.example.fidelbarcaya.country;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.fidelbarcaya.country.models.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fidel.barcaya on 4/4/2017.
 */

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {
    private ArrayList<Country> dataset;
    private Context context;
    public CountryListAdapter(Context context){

        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.item_country, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Country country = dataset.get(position);
        holder.nombreTextView.setText(country.getName());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/"+country.getAlpha2Code()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
    public void addCountryList(List<Country> countries){

        dataset.addAll(countries);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImageView;
        private TextView nombreTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);

        }
    }
}
