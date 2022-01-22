package com.wendy.wendyec3;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.wendy.wendyec3.network.ClothesEntry;

public class ClothesGrid  extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater , ViewGroup container,
            Bundle savedInstanceStace

    ){
        View view = inflater.inflate(R.layout.clothes_grid, container, false);

        setUpToolbar(view);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        ClothesCardRecyclerViewAdapter adapter = new ClothesCardRecyclerViewAdapter(
                ClothesEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.clothes_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.clothes_grid_spacing_small);
        recyclerView.addItemDecoration(new ClothesGridItemDecoration(largePadding, smallPadding));

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            view.findViewById(R.id.clothes_grid).setBackgroundResource(R.drawable.clothes_shape);
        }
        MaterialButton buttonProfile=view.findViewById(R.id.button_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),MainActivity2.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null) {
            activity.setSupportActionBar(toolbar);
        }
        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(getContext(),
                view.findViewById(R.id.clothes_grid),
                new AccelerateDecelerateInterpolator(),
                getContext().getResources().getDrawable(R.drawable.menu_2),
                getContext().getResources().getDrawable(R.drawable.close)

                ));
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
