package com.example.navigationparametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NavHostFragment navHostFragment;

    NavController navController;

    int curPag=0;

    String[] textos = {"Fragment1","Fragmento2","Fragmento3"};

    int[] actions = new int[]{R.id.action_fragment1_to_fragment2,R.id.action_fragment2_to_fragment3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navHostFragment =(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        navController =navHostFragment.getNavController();
        Bundle bundle = new Bundle();
        bundle.putString(fragment1.ARG_PARAM1,textos[0]);
        navController.navigate(R.id.fragment1,bundle);
    }



    public void siguiente(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(fragment1.ARG_PARAM1,textos[curPag+1]);

        navController.navigate(actions[curPag++],bundle);
    }
}