package com.example.recycletest3;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * class for signing up
 */
public class SignUp extends AppCompatActivity {

    /**
     * onCreate method
     * @param savedInstanceState default.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /**
         * initializing of all needed parameters.
         */
        final EditText etName = findViewById(R.id.et_name_reg);
        final EditText etEmail = findViewById(R.id.et_email_reg);
        final EditText etPass = findViewById(R.id.et_pass_reg);
        Button btnSignup = findViewById(R.id.btn_reg);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser(
                        etName.getText().toString().trim(), etEmail.getText().toString().trim(),
                        etPass.getText().toString().trim());
            }
        });
    }

    /**
     * method that signs up a user.
     * @param name name.
     * @param email email.
     * @param password password.
     */
    public void registerUser(final String name, final String email, final String password) {


        /**
         * method that validates with php scripts
         */
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), SignIn.class));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        /**
         * biulding a request queue with given string.
         */
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

}
