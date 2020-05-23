package com.example.recycletest3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * class containing inner data of 3rd page
 */
public class Frag3 extends Fragment {

    /**
     * method that fills up recycler view with data
     * @param savedInstanceState saved instance
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        return inflater.inflate(R.layout.frag3_layout, container, false);
    }
}
