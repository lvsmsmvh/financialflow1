package com.example.recycletest3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * class containing inner data of 2nd page
 */
public class Frag2 extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<CardItem> listOfItems;

    /**
     * default constructor
     */
    public Frag2() {

    }

    /**
     * method onCreateView
     * @param inflater inflates the  layout.
     * @param container container
     * @param savedInstanceState saved instance
     * @return view
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag2_layout, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycleView2);
        RecycleViewAdapter2 recycleViewAdapter = new RecycleViewAdapter2(getContext(), listOfItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        return v;
    }
    /**
     * method that fills up recycler view with data
     * @param savedInstanceState saved instance
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listOfItems = new ArrayList<>();
        listOfItems.add(new CardItem("OshadBank", "1000.00 UAH"));
        listOfItems.add(new CardItem("PrivatBank", "1100.00 UAH"));
        listOfItems.add(new CardItem("PUMB", "200.00 UAH"));
    }
}
