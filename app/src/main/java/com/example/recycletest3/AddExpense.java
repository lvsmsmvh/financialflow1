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

public class AddExpense extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // спиннер для валют
        final Spinner spinner = findViewById(R.id.spinnerExpenseCur);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // спиннер для выбора типа траты
        final Spinner spinnerTypeExp = findViewById(R.id.spinnerTypeExp);
        ArrayAdapter<CharSequence> adapterTypeExp = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapterTypeExp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeExp.setAdapter(adapterTypeExp);
        spinnerTypeExp.setOnItemSelectedListener(this);


        // иниц. кнопок и полей ввода
        Button save = findViewById(R.id.buttonAddExp);
        Button switchToInOut = findViewById(R.id.buttonSwitch);
        final EditText etDesc = findViewById(R.id.editDesc);
        final EditText etMoney = findViewById(R.id.editTextMoneyExp);


        // обработчики нажатий
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

        switchToInOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
