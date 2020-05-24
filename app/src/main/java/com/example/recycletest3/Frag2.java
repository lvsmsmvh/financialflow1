package com.example.recycletest3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * class containing inner data of 2nd page
 */
public class Frag2 extends Fragment {
    View v;
    private RecyclerView recyclerView;
    //private List<CardItem> listOfItems;
    RecycleViewAdapter2 recycleViewAdapter;

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
        recyclerView = v.findViewById(R.id.recycleView2);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }



    private void loadWallets(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_GET_WALLETS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        WalletHolder.clearWallets();
                        try {
                            JSONArray wallets = new JSONArray(response);
                            for (int i = 0; i < wallets.length(); i++){
                                JSONObject walletObject = wallets.getJSONObject(i);
                                int idWallet = walletObject.getInt("id_wallet");
                                int idUser = walletObject.getInt("id_user");
                                String name = walletObject.getString("name");
                                double balance = walletObject.getDouble("balance");

                                CardItem cardItem = new CardItem(idWallet, idUser, name, balance + "");
                                WalletHolder.addWallet(cardItem);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        recycleViewAdapter = new RecycleViewAdapter2(getContext(), WalletHolder.getWalletList());
                        recyclerView.setAdapter(recycleViewAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id_user", User.getInstance(getContext()).getUserId() + "");
                return params;
            }
        };

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
    /**
     * method that fills up recycler view with data
     * @param savedInstanceState saved instance
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadWallets();
    }
}
