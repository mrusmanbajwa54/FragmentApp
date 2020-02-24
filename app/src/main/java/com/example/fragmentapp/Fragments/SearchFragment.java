package com.example.fragmentapp.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SearchFragment extends Fragment {
    private HomeFragment objectHomeFragment;
    private SearchFragment objectSearchFragment;

    private BottomNavigationView objectBottomNavigationView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    private void changeFragment(Fragment objectFragment)
    {
        try
        {
            FragmentTransaction objectTransaction=getSupportFragmentManager()
                    .beginTransaction();

            objectTransaction.replace(R.id.container,objectFragment).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "changeFragment:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeObjects()
    {
        try
        {
            objectHomeFragment=new HomeFragment();
            objectSearchFragment=new SearchFragment();

            objectBottomNavigationView=findViewById(R.id.BNV);
            changeFragment(objectHomeFragment);

            objectBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                            if(item.getItemId()==R.id.menu_home)
                            {
                                changeFragment(objectHomeFragment);
                                return true;
                            }
                            else if(item.getItemId()==R.id.menu_search)
                            {
                                changeFragment(objectSearchFragment);
                                return true;
                            }
                            return false;
                        }
                    }
            );


        }
        catch (Exception e)
        {
            Toast.makeText(this, "initializeObjects:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
