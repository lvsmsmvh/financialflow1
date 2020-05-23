package com.example.recycletest3;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * class for adding an expense / an income
 */
public class AddExpense extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    /**
     * method onCreate
     * @param savedInstanceState saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        /**
         * spinner for selection a currency
         */
        final Spinner spinner = findViewById(R.id.spinnerExpenseCur);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        /**
         * spinner for selection a type of an expense
         */
        final Spinner spinnerTypeExp = findViewById(R.id.spinnerTypeExp);
        ArrayAdapter<CharSequence> adapterTypeExp = ArrayAdapter.createFromResource(this, R.array.type_exp, android.R.layout.simple_spinner_item);
        adapterTypeExp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeExp.setAdapter(adapterTypeExp);
        spinnerTypeExp.setOnItemSelectedListener(this);


        /**
         * initialization of all button and edittexts
         */
        final Button save = findViewById(R.id.buttonAddExp);
        final Button switchToInOut = findViewById(R.id.buttonSwitch);
        final EditText etDesc = findViewById(R.id.editDesc);
        final EditText etMoney = findViewById(R.id.editTextMoneyExp);
        final                     TextView tvMainText = findViewById(R.id.textViewExp);



        /**
         * onClickListener for Save button
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String desc = etDesc.getText().toString();
                String money = etMoney.getText().toString();
                String spinnerCurText = spinner.getSelectedItem().toString();
                String spinnerTypeText = spinnerTypeExp.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), desc + " "+ money + " " + spinnerCurText + " " + spinnerTypeText, Toast.LENGTH_SHORT).show();
            }
        });


        /**
         * onClickListener for switch button
         */
        switchToInOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = switchToInOut.getText().toString();

                if (a.equals("Income")) {
                    spinnerTypeExp.setVisibility(View.GONE);
                    //Toast.makeText(getApplicationContext(), "Switched to expense.", Toast.LENGTH_SHORT).show();
                    tvMainText.setText("INCOME:");
                    switchToInOut.setText("Expense");
                }

                if (a.equals("Expense")) {
                    spinnerTypeExp.setVisibility(View.VISIBLE);
                    //Toast.makeText(getApplicationContext(), "Switched to income.", Toast.LENGTH_SHORT).show();
                    tvMainText.setText("EXPENSE:");
                    switchToInOut.setText("Income");
                }
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
