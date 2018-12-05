package br.com.digitalnews.digitalnews;

<<<<<<< HEAD
import android.annotation.SuppressLint;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
=======

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
>>>>>>> develop
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {
=======
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
>>>>>>> develop

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    FirebaseAuth firebaseAuth;
    GoogleApiClient mGoogleApiClient;
    private SignInButton signInButton;
    private static final int RC_SIGN_IN = 9001;
    private TextView register;
    private LoginButton btnLogin;
    


<<<<<<< HEAD
=======
    @RequiresApi(api = Build.VERSION_CODES.N)
>>>>>>> develop
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
<<<<<<< HEAD
        btnLogin = (LoginButton)findViewById(R.id.btn_login);
=======
        btnLogin = findViewById(R.id.btn_login);
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        firebaseAuth = FirebaseAuth.getInstance();

        GoogleSignInOptions gso = new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
>>>>>>> develop


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(LoginActivity.this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

<<<<<<< HEAD
        CallbackManager callbackManager = CallbackManager.Factory.create();

        btnLogin.setReadPermissions("email");
        
        // Callback registration
        btnLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
=======
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

    }

    private void signIn() {
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                authWithGoogle(account);
            }
        }
    }

    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
>>>>>>> develop
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Auth Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


        
        
    }

<<<<<<< HEAD

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        PreferenceManager.OnActivityResultListener callbackManager;
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
=======
    @Override
    public void onConnectionFailed (@NonNull ConnectionResult connectionResult){
        Toast.makeText(getApplicationContext(), "Falha na conexão", Toast.LENGTH_SHORT).show();
>>>>>>> develop
    }

}
