package com.adi.projet2023.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.adi.projet2023.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

public class LoginActivity extends Activity implements Serializable {

    private final String PATH_USER_DATABASE= "Users";
    private final String PATH_PRESENCE_PERSONNE= "test/presence_personne";

    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseUser firebaseUser;

    TextView txtPasswordOublie;
    EditText txtMailLogin, txtPasswordLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);
//        lancerNotification();

        //initialisation des différents composants de l'interface graphique
        init();



        /**
         * Click sur le button login pour se connecter
         */
        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mail= txtMailLogin.getText().toString();
                        String password= txtPasswordLogin.getText().toString();

                        loginMethod(mail, password);

                    }
                }
        );

        /**
         * Click sur le lien "mot de passe oublié"
         * pour recevoir un lien de réinitialisation de mot de passe
         */
        txtPasswordOublie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mail= txtMailLogin.getText().toString();
                    }
                }
        );
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        lancerNotification();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        lancerNotification();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        lancerNotification();
    }


    /**
     * Initialisation des différents composants de l'interface graphique
     */
    private void init(){
        //Initialisation Firebase Auth
        mAuth= FirebaseAuth.getInstance();

        firebaseFirestore = FirebaseFirestore.getInstance();

        btnLogin= findViewById(R.id.btnLoginAdmin);
        txtPasswordOublie= findViewById(R.id.txtPasswordOublieAdmin);

        txtMailLogin=findViewById(R.id.txtMailLoginAdmin);
        txtPasswordLogin= findViewById(R.id.txtPasswordLoginAdmin);
    }


    /**
     * Cette méthode permet à
     * un quelconque utilisateur
     * de se connecter au système
     * grâce à son mail et password
     * @param mail
     * @param password
     */
    private void loginMethod(String mail, String password){

        if (mail==null || mail.equals("")){
            txtMailLogin.setError("Veuillez saisir votre email");
            return;
        }
        if (password==null || password.equals("")){
            txtPasswordLogin.setError("Veuillez saisir votre mot de passe");
            return;
        }


        if (mail==null || password==null || mail.equals("") || password.equals("")){
            Toast.makeText(LoginActivity.this, "Veuillez saisir tous les champs", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(mail, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            firebaseUser= mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, "Reussi", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ChoixLocalActivity.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Données non correspondants", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }



}