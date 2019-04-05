package com.example.mvvmpractice;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;


import android.arch.lifecycle.ViewModel;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Observable;

public class HeroVM extends ViewModel {


    public ObservableField<String> status = new ObservableField<>();
    public ObservableField<String> msg = new ObservableField<>();
    public  ObservableField<ArrayList<Categories>> categoryList = new ObservableField<>();


    public MutableLiveData<HeroVM> heroVMMutableLiveData= new MutableLiveData<>();

    public ObservableField<String> image_path()
    {
        return image_path;
    }



    @BindingAdapter("bind:image_path")

    public static void loadImage(ImageView imageView, String image_path)
    {
        Picasso.get().load(image_path).placeholder(R.drawable.user).into(imageView);
    }


    public HeroVM()
    {
        HeroRepo heroRepo = new HeroRepo();
        heroVMMutableLiveData = heroRepo.getArrayListMutableLiveData();

    }

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> image_path = new ObservableField<>("");



    public HeroVM(DataPOJO dataPOJO)
    {
        this.status.set(dataPOJO.getStatus());
        this.msg.set(dataPOJO.getMsg());
        this.categoryList.set(dataPOJO.getCategories());
    }


    public HeroVM(Categories categories)
    {
      this.name.set(categories.getName());
      this.image_path.set(categories.getImage_path());
    }


    public MutableLiveData<HeroVM> getHeroVMMutableLiveData() {
        return heroVMMutableLiveData;
    }
}
