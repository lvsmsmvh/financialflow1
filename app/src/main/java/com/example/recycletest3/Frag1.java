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

public class Frag1 extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<ActionItem> listOfItems;


    public Frag1(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frag1_layout, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycleView);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(), listOfItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listOfItems = new ArrayList<>();
        listOfItems.add(new ActionItem("Bank", "21.01.2020", "OshadBank", "+200.00 UAH"));
        listOfItems.add(new ActionItem("Food", "22.01.2020", "PrivatBank", "-110.00 UAH"));
        listOfItems.add(new ActionItem("Internet", "22.01.2020", "PrivatBank", "-35.00 UAH"));
    }
}
