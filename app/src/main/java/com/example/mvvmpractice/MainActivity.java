package com.example.mvvmpractice;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.mvvmpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener {

   private ActivityMainBinding binding;
   private HeroVM heroVM;
   private RecyclerViewAdapter adapter;
   RecyclerViewAdapter.ClickListener clickListener;


   private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clickListener = this;

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHero(heroVM);
        context = MainActivity.this;

       ;


        heroVM = ViewModelProviders.of(this).get(HeroVM.class);
      /*  heroVM.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<HeroVM>>() {
            @Override
            public void onChanged(@Nullable ArrayList<HeroVM> heroVMS) {
                if (!heroVM.status.get().isEmpty())
                {
                    if (heroVM.status.get().equalsIgnoreCase("success"))
                    {
                        adapter = new RecyclerViewAdapter(MainActivity.this, heroVMS, clickListener);
                        binding.recyclerView.setAdapter(adapter);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Error - Outside the success", Toast.LENGTH_LONG).show();
                    }
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_LONG).show();
                }

            }
        });*/

      heroVM.getHeroVMMutableLiveData().observe(this, new Observer<HeroVM>() {
          @Override
          public void onChanged(@Nullable HeroVM heroVM) {

              adapter = new RecyclerViewAdapter(context, heroVM.categoryList.get(), clickListener);
              binding.recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
              binding.recyclerView.setAdapter(adapter);


          }
      });



    }

    @Override
    public void adapterClick(int position , String name) {

        Toast.makeText(MainActivity.this,"You Clicked :" + name,Toast.LENGTH_LONG).show();




    }
}
