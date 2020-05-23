package com.example.recycletest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * Class that allows to Sign in
 */

public class SignIn extends AppCompatActivity {

    /**
     * parameter indicating whether user signed in or no
     */
    int RC_SIGN_IN = 0;

    /**
     * button Sign In
     */
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;

    /**
     * method onCreate for SignIn class
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        signInButton = findViewById(R.id.sign_in_button);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        /**
         * onClick listener for sign in button
         */
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // an action
                SignIn();
            }
        });


        /**
         * Intializators for all edit texts and buttons
         */
        final EditText etEmail = findViewById(R.id.et_email);
        final EditText etPass = findViewById(R.id.et_pass);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnSignup = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });
    }

    /**
     * method that is called when a button pressed
     */
    private void SignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    /**
     * method that checks if user signed in
     * @param requestCode requestCode.
     * @param resultCode resultCode.
     * @param data data of intent.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    /**
     * method that tries to log in
     * @param completedTask google task.
     */
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(this, "Signed in! ID=" + account.getId(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        } catch (ApiException e) {
            Log.w("Google Sign In Error", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * method that starts main activity if user logged in
     */
    @Override
    protected void onStart() {

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {
            Toast.makeText(this, "Signed in! ID=" + account.getId(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        super.onStart();
    }
}
