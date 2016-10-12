package com.santiagoosorio.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistroActivity extends AppCompatActivity {
    EditText erUsuario, erContraseña, errContraseña, erEmail;
    Button brAceptar, bCancelar;
    //private String usuario,contrasena,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        erUsuario = (EditText) findViewById(R.id.erUsuario);
        erContraseña = (EditText) findViewById(R.id.erContraseña);
        erEmail = (EditText) findViewById(R.id.erEmail);
        errContraseña = (EditText) findViewById(R.id.errContraseña);
        brAceptar = (Button) findViewById(R.id.brAceptar);
        bCancelar = (Button) findViewById(R.id.bCancelar);



        brAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(erUsuario.getText().toString().equals("")) && !(erContraseña.getText().toString().equals(""))
                        && !(errContraseña.getText().toString().equals("")) && !(erEmail.getText().toString().equals(""))){

                    if (erContraseña.getText().toString().equals(errContraseña.getText().toString())){
                        Intent intent = new Intent();
                        intent.putExtra("usuario", erUsuario.getText().toString());
                        intent.putExtra("contrasena", erContraseña.getText().toString());
                        intent.putExtra("email", erEmail.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(RegistroActivity.this, "No coinsiden las contraseñas", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegistroActivity.this, "Digitelas de nuevo ", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistroActivity.this, "hay campos sin llenar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                setResult(RESULT_CANCELED,intent1);
                finish();
            }
        });
    }
}
