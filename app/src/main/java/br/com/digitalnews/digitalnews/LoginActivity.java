package br.com.digitalnews.digitalnews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;

import java.util.Arrays;

import br.com.digitalnews.digitalnews.data.local.database.ConfigFirebase;
import br.com.digitalnews.digitalnews.home.model.User;


public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    FirebaseAuth firebaseAuth;
    GoogleApiClient mGoogleApiClient;
    private TextInputLayout email;
    private TextInputLayout password;
    private SignInButton signInButton;
    private static final int RC_SIGN_IN = 9001;
    private static final int FB_SIGN_IN = 9002;
    private TextView register;
    //private LoginButton btnLoginFacebook;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnLogin2;
    CallbackManager callbackManager;
    ProgressBar barra;
    public static String id;
    FirebaseAuth autenticacao;
    User user;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        register =findViewById( R.id.register );
        email = findViewById( R.id.username );
        password = findViewById( R.id.password);
        btnLogin = findViewById( R.id.btn_login );
        //btnLoginFacebook = findViewById(R.id.btn_facebook);
        btnLogin2 = findViewById( R.id.btn_facebook_2 );
        signInButton = findViewById( R.id.sign_in_button );
        firebaseAuth = FirebaseAuth.getInstance();
        btnRegister = findViewById( R.id.btn_register_now );

        GoogleSignInOptions gso = new Builder( GoogleSignInOptions.DEFAULT_SIGN_IN )
                .requestIdToken( getString( R.string.default_web_client_id ) )
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder( this )
                .enableAutoManage( LoginActivity.this, this )
                .addApi( Auth.GOOGLE_SIGN_IN_API, gso )
                .build();

        signInButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        } );

        callbackManager = CallbackManager.Factory.create();

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( LoginActivity.this, MainActivity.class ) );
            }
        } );

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( LoginActivity.this, RegisterActivity.class ) );
            }
        } );

        btnLogin2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions( LoginActivity.this, Arrays.asList( "public_profile" ) );
                LoginManager.getInstance().registerCallback( callbackManager,
                        new FacebookCallback<LoginResult>() {
                            @Override
                            public void onSuccess(LoginResult loginResult) {
                                Log.i( "LOG", "LoginResult:" + loginResult );
                                gotoHome();
                            }

                            @Override
                            public void onCancel() {
                                Toast.makeText( LoginActivity.this, "Canceled", Toast.LENGTH_SHORT ).show();
                            }

                            @Override
                            public void onError(FacebookException exception) {
                                Log.i( "LOG", "Login Error: " + exception.getMessage() );
                            }
                        } );
            }
        } );

//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
//        if (isLoggedIn) {
//            gotoHome();
//        }
    }

    private void gotoHome() {
        Toast.makeText( LoginActivity.this, "Logou", Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent( getApplicationContext(), MainActivity.class );
        startActivity( intent );
        finish();
    }

    private void signIn() {
        Intent signIntent = Auth.GoogleSignInApi.getSignInIntent( mGoogleApiClient );
        startActivityForResult( signIntent, RC_SIGN_IN );
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent( data );
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                authWithGoogle( account );
            }
        } else {
            callbackManager.onActivityResult( requestCode, resultCode, data );
        }
    }

    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential( account.getIdToken(), null );
        firebaseAuth.signInWithCredential( credential ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity( new Intent( getApplicationContext(), MainActivity.class ) );
                    finish();
                } else {
                    Toast.makeText( getApplicationContext(), "Auth Error", Toast.LENGTH_SHORT ).show();
                }
            }
        } );




    btnLogin.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!email.getEditText().getText().toString().equals( "" ) && !password.getEditText().getText().toString().equals( "" )){

                user = new User();
                user.setEmail( email.getEditText().getText().toString());
                user.setSenha( password.getEditText().getText().toString() );
                validarLogin();

                barra.setVisibility(View.VISIBLE);
            }else{
                Toast.makeText(LoginActivity.this,"Preencha seus dados",Toast.LENGTH_SHORT).show();

                barra.setVisibility(View.GONE);
            }
        }
    } );





}
    private void validarLogin(){
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword( user.getEmail(),user.getSenha() ).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    abrirTelaSearch();
                    if (task.getResult() != null && task.getResult().getUser() != null) {
                        id = task.getResult().getUser().getUid();
                    }

                }else{
                    Toast.makeText( LoginActivity.this,"Deu errado",Toast.LENGTH_SHORT ).show();
                    barra.setVisibility(View.GONE);
                }

            }
        } );


    }
    private void abrirTelaSearch(){

        Intent intent = new Intent( getApplicationContext(),MainActivity.class );
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText( getApplicationContext(), "Falha na conexão", Toast.LENGTH_SHORT ).show();

    }

}
