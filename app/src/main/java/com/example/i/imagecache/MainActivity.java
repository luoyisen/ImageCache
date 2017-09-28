package com.example.i.imagecache;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.i.imagecache.bean.GankEntity;
import com.example.i.imagecache.ui.WallpaperFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<GankEntity> welFareList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WallpaperFragment wallpaperFragment = new WallpaperFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container_main, wallpaperFragment).commit();
    }

    public void setPicList(List<GankEntity> welFareList) {
        this.welFareList = welFareList;
    }
}
