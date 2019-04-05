package com.example.mvvmpractice;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmpractice.databinding.HeroAdapterBinding;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Categories> categoriesArrayList;
    private LayoutInflater layoutInflater;
    private ClickListener clickListener;

    public RecyclerViewAdapter(Context context, ArrayList<Categories> categoriesArrayList, ClickListener clickListener) {
        this.context = context;
        this.categoriesArrayList = categoriesArrayList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        HeroAdapterBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.row_adapter, viewGroup, false);

        return new MyViewHolder(binding, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
       /* HeroVM heroVM =categoriesArrayList.get(i);
        myViewHolder.bind(heroVM);*/

       HeroVM heroVM = new HeroVM(categoriesArrayList.get(i));
       myViewHolder.bind(heroVM);

    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private HeroAdapterBinding binding;

        private ClickListener clickListener;

        public MyViewHolder(HeroAdapterBinding binding, ClickListener clickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.clickListener = clickListener;

        }

        public void bind(HeroVM heroVM) {
            this.binding.setHeroMain(heroVM);
            binding.executePendingBindings();

            binding.setIadapterClick(new AdapterClickListener() {
                @Override
                public void onAdapterClicked() {

                   // clickListener.adapterClick(getAdapterPosition(), categoriesArrayList.get(getAdapterPosition()).name.get());

                }
            });
        }

        public HeroAdapterBinding getBinding() {
            return binding;
        }
    }


    public interface ClickListener
    {
          void adapterClick(int position , String name);
    }
}
