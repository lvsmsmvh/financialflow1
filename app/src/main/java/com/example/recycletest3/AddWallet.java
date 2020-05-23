package com.example.recycletest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * class for adding a wallet
 */
public class AddWallet extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * method onCreate
     * @param savedInstanceState saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wallet);


        /**
         * initialization of all button and edit texts
         */
        Button save = findViewById(R.id.button);
        final EditText etName = findViewById(R.id.editTextName);
        final EditText etMoney = findViewById(R.id.editTextMoney);


        /**
         * onClickListener for Save button
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String money = etMoney.getText().toString();
                Toast.makeText(getApplicationContext(), name + " "+ money, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * method that reacts when item is selected on spinner
     * @param parent parent view.
     * @param view view.
     * @param position position.
     * @param id id.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * method that reacts if nothing selected
     * @param parent parent view.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
