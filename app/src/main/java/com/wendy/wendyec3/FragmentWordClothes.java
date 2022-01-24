package com.wendy.wendyec3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentWordClothes extends Fragment {



    public FragmentWordClothes() {
        // Required empty public constructor
    }


    public static FragmentWordClothes newInstance(String param1, String param2) {
        FragmentWordClothes fragment = new FragmentWordClothes();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word_clothes, container, false);
    }
}