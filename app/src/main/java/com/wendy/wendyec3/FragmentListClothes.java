package com.wendy.wendyec3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentListClothes extends Fragment {


    List<WordItem> elements;

    public static FragmentListClothes newInstance() {
        FragmentListClothes fragment = new FragmentListClothes();
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
        View view= inflater.inflate(R.layout.fragment_list_clothes, container, false);
        elements = new ArrayList<>();
        elements.add(new WordItem("T-shirt"));
        elements.add(new WordItem("Blouse"));
        elements.add(new WordItem("Jeans"));
        elements.add(new WordItem("Skirt"));
        elements.add(new WordItem("Coat"));
        elements.add(new WordItem("Sweaters"));
        elements.add(new WordItem("Dress"));
        elements.add(new WordItem("Suit"));

        RecyclerView recyclerView = view.findViewById(R.id.clothes_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false));
        ClothesItemWordAdapter adapter = new ClothesItemWordAdapter(elements);
        recyclerView.setAdapter(adapter);

        return view;
    }
}