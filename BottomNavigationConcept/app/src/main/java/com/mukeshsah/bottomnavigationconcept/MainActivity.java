package com.mukeshsah.bottomnavigationconcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);


        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.nav_home){
                    loadFrag(new HomeFragment(),false);
                } else if (id==R.id.nav_search) {
                    loadFrag(new SearchFragment(),false);
                } else if (id==R.id.nav_utilities) {
                    loadFrag(new UtilitiesFragment(),false);
                } else if (id==R.id.nav_contact) {
                    loadFrag(new ContactFragment(),false);
                }else {
                    //Profile
                    loadFrag(new MyProfileFragment(),true);

                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_MyProfile);
    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag)
            ft.add(R.id.containerFl,fragment);
        else
            ft.replace(R.id.containerFl,fragment);
        ft.commit();
    }
}
