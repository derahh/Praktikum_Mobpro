package com.example.android.pets;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PetViewModel extends AndroidViewModel {

    private PetDao mPetDao;
    private LiveData<List<PetEntity>> mAllPets;

    public PetViewModel(@NonNull Application application) {
        super(application);
        mPetDao = PetRoomDatabase.getDatabase(application).petDao();
        mAllPets = mPetDao.getAllPets();
    }

    public LiveData<List<PetEntity>> getmAllPets(){
        return  mAllPets;
    }

    public PetEntity getPetById(int id){
        return mPetDao.getPetById(id);
    }

    public void insert(PetEntity petEntity){
        mPetDao.insert(petEntity);
    }

    public  void deleteAll(){
        mPetDao.deleteAll();
    }

    public void update(PetEntity petEntity){
        mPetDao.update(petEntity);
    }

    public void delete(PetEntity petEntity){
        mPetDao.delete(petEntity);
    }
}
