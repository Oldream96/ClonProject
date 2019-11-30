package pe.com.hatunsol.hatunsolmovil.modules.login.ui;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.LogDescriptor;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.UUID;

import pe.com.hatunsol.hatunsolmovil.R;
import pe.com.hatunsol.hatunsolmovil.modules.login.domain.usecase.SaveSessionUser;
import pe.com.hatunsol.hatunsolmovil.modules.main.ui.MainActivity;
import pe.com.hatunsol.hatunsolmovil.services.entities.SessionUser;
import pe.com.hatunsol.hatunsolmovil.services.entities.Usuario;


public class ActivityLogin extends AppCompatActivity {

    EditText user, password;
    Button btlogin, btnSignGoogle, btnRegistrarse;
    private SaveSessionUser saveSessionUser;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    static final int GOOGLE_SIGN = 123;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        FlowManager.init(this);
        user = findViewById(R.id.etLogin);
        password = findViewById(R.id.etpassword);
        btlogin = findViewById(R.id.btnLogin);
        btnSignGoogle = findViewById(R.id.btnGoogleSing);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        user.setFocusableInTouchMode(true);
        password.setFocusableInTouchMode(true);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Error("Actualmente no está disponible la creación de usuarios!").show();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        btnSignGoogle.setOnClickListener(v -> SingInGoogle());

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (ValidarUsuario()) {
                    mAuth.signInWithEmailAndPassword(user.getText().toString().toLowerCase().trim(), password.getText().toString())
                            .addOnCompleteListener(ActivityLogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                                        Usuario usuario = new Usuario();
                                        usuario.setEmpleadoNombre(user.getText().toString());
                                        if (user.getText().toString().toLowerCase().trim().equals("administrador@ejemplo.com"))
                                            usuario.setCargoNombre("Administrador");
                                        else
                                            usuario.setCargoNombre("Cliente");
                                        onSaveSessionUser(usuario);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(ActivityLogin.this, "Datos incorrectos!", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });

                } else {
                    Toast.makeText(ActivityLogin.this, "Informacion imcompleta o no registrado", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if (mAuth.getCurrentUser() != null) {
            FirebaseUser user = mAuth.getCurrentUser();
            UpdateUI(user);

        }


    }


    void SingInGoogle() {
        Intent SingIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(SingIntent, GOOGLE_SIGN);
    }

    private Boolean ValidarUsuario() {
        String usuario = user.getText().toString();
        String contraseña = this.password.getText().toString();

        if (usuario.isEmpty()) return false;
        if (contraseña.isEmpty()) return false;
        if (contraseña.length() < 6) return false;
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_SIGN) {
            Task<GoogleSignInAccount> task = GoogleSignIn
                    .getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if (account != null) firebaseWithGoogleAuth(account);

            } catch (ApiException e) {
                e.printStackTrace();
            }

        }
    }

    private void onSaveSessionUser(Usuario usuario) {
        saveUserSession(usuario);
    }


    void firebaseWithGoogleAuth(GoogleSignInAccount account) {
        Log.d("tag", "firebaseWithGoogleAuth: " + account.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d("TAG   ", "SING CORRECTO: ");
                        FirebaseUser user = mAuth.getCurrentUser();
                        UpdateUI(user);
                        Usuario usuario = new Usuario();
                        usuario.setEmpleadoNombre(this.user.getText().toString());
                        if (this.user.getText().toString().toLowerCase().trim().equals("administrador@ejemplo.com")) {
                            usuario.setCargoNombre("Administrador");
                        }
                        else {
                            usuario.setCargoNombre("Cliente");
                        }
                        usuario.setEmpleadoNombre(user.getEmail());
                        usuario.setFoto(user.getPhotoUrl().toString());
                        onSaveSessionUser(usuario);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Log.w("TAG", "Sing In Failed: ", task.getException());
                        Toast.makeText(this, "Error Sing", Toast.LENGTH_SHORT).show();
                        UpdateUI(null);
                    }


                });
    }

    private void UpdateUI(FirebaseUser user) {

        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            String foto = String.valueOf(user.getPhotoUrl());
        }
    }


    public AlertDialog Error(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_error, null);
        builder.setView(view);
        Button btConfirmacion = view.findViewById(R.id.btConfirmacion);
        TextView Mensaje = view.findViewById(R.id.tvMensaje);
        Mensaje.setText(mensaje);
        final AlertDialog dialog = builder.create();
        btConfirmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;

    }


    public boolean saveUserSession(Usuario usuario) {

        SessionUser sessionUser = new SessionUser();
        sessionUser.setNombrePersona(usuario.getEmpleadoNombre());
        sessionUser.setPersonaId(1);
        if (usuario.getCargoNombre().equals("Administrador"))
            sessionUser.setUsuarioId(1);
        else sessionUser.setUsuarioId(2);
        sessionUser.setState(true);
        sessionUser.setCargoId(1);
        sessionUser.setLocalId(1);
        sessionUser.setZonaId(1);
        sessionUser.setFoto(usuario.getFoto());
        sessionUser.setEmpleadoId(1);
        sessionUser.save();
        usuario.save();
        return true;
    }


}
