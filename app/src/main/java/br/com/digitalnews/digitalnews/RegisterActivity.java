package br.com.digitalnews.digitalnews;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

import br.com.digitalnews.digitalnews.data.local.database.ConfigFirebase;
import br.com.digitalnews.digitalnews.data.local.database.Preferencias;
import br.com.digitalnews.digitalnews.home.model.User;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_register;
    private TextInputLayout name;
    private TextInputLayout email;
    private TextInputLayout password;
    private TextInputLayout repeat;
    private FirebaseAuth autenticacao;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        btn_register = findViewById( R.id.btn_register_now );
        name = findViewById( R.id.text_input_name );
        email = findViewById( R.id.text_input_email );
        password = findViewById( R.id.text_input_password );
        repeat = findViewById( R.id.text_input_repeate_password );

        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getEditText().getText().toString().equals( repeat.getEditText().getText().toString() )) {

                    user = new User();
                    user.setEmail( email.getEditText().getText().toString() );
                    user.setSenha( password.getEditText().getText().toString() );


                } else {
                    Toast.makeText( RegisterActivity.this, "As senhas precisam ser iguais", Toast.LENGTH_SHORT ).show();

                }

                cadastrarUsuario();
                abrirLoginUsuario();

            }


        } );
    }


    public void cadastrarUsuario() {

        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getSenha()
        ).addOnCompleteListener( RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText( RegisterActivity.this, "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT ).show();
                    //String identificadorUser = Base64Custom.codificarBase64( user.getEmail() );
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    user.setId( usuarioFirebase.getUid() );
                    user.salvar();

                    Preferencias preferencias = new Preferencias( RegisterActivity.this );
                    preferencias.salvarPreferenciasUsuarios( user.getId(), user.getNome() );

                    abrirLoginUsuario();


               } //else {
//                    String erroException = "";
//
//                    try {
//
//                        throw task.getException();
//
//                    } catch (FirebaseAuthWeakPasswordException e) {
//                        erroException = "Senha muito fraca";
//                    } catch (FirebaseAuthInvalidCredentialsException e) {
//                        erroException = "O e-mail digitado é inválido";
//                    } catch (FirebaseAuthUserCollisionException e) {
//                        erroException = "E-mail já cadastrado";
//                    } catch (Exception e) {
//                        erroException = "Erro ao efetuar o cadastro";
//                        e.printStackTrace();
//                    }
//                    Toast.makeText( RegisterActivity.this, "Erro" + erroException, Toast.LENGTH_SHORT ).show();
//                }
            }
        } );
    }

    public void abrirLoginUsuario() {
        Intent intent = new Intent( RegisterActivity.this, LoginActivity.class );
        startActivity( intent );
        finish();
    }


}

