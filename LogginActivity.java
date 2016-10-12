package com.santiagoosorio.addressbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogginActivity extends AppCompatActivity {
    EditText eUsuario,eContraseña;
    Button bRegistro,bEntrar;
SharedPreferences prefs;
    private String Usuario,Contrasena,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

      /*  prefs = getPreferences(MODE_PRIVATE);
        prefs.getInt("loggeo",-1);
        int dato = prefs.getInt("loggeo",-1);
        Log.d("loggeo",String.valueOf(dato));

        if(dato == 1){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("usuario", Usuario);
            intent.putExtra("contrasena", Contrasena);
            intent.putExtra("email", Email);
            startActivity(intent);
            finish();
        }*/

        eUsuario = (EditText)findViewById(R.id.eUsuario);
        eContraseña = (EditText)findViewById(R.id.eContraseña);
        bRegistro = (Button) findViewById(R.id.bRegistro);
        bEntrar= (Button) findViewById(R.id.bEntrar);


        bRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,123);

            }
        });
        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((eUsuario.getText().toString().equals("")) || (eContraseña.getText().toString().equals("")))){

                    if (eContraseña.getText().toString().equals(Contrasena)){
                        //SharedPreferences.Editor editor;
                        //editor = prefs.edit();
                        //editor.putInt("loggeo",1);
                        //editor.commit();
                        Intent intent = new Intent(LogginActivity.this, MainActivity.class);
                        intent.putExtra("usuario", Usuario);
                        intent.putExtra("contrasena", Contrasena);
                        intent.putExtra("email", Email);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LogginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LogginActivity.this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected void onActivityResult (int requestcode, int resultCode, Intent data){
        if(requestcode==123 && resultCode == RESULT_OK){
            Usuario = data.getExtras().getString("usuario");
            Contrasena = data.getExtras().getString("contrasena");
            Email = data.getExtras().getString("email");
        }
        if(requestcode==123 && resultCode == RESULT_CANCELED){

        }
    }
}
