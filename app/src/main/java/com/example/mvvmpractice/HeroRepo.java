package com.example.mvvmpractice;
import android.arch.lifecycle.MutableLiveData;
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HeroRepo
{


    private MutableLiveData<HeroVM> heroVMMutableLiveData = new MutableLiveData<>();
       private  ArrayList<HeroVM> arrayList = new ArrayList<>();

       public HeroRepo()
       {

       }



    public MutableLiveData<HeroVM> getArrayListMutableLiveData()
    {
        ApiInterface apiInterface = RetrofitClient.getApiInterface();

        apiInterface.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataPOJO>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DataPOJO dataPOJO) {

                        HeroVM heroVM = new HeroVM(dataPOJO);

                        heroVMMutableLiveData.setValue(heroVM);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return heroVMMutableLiveData;
    }






}


