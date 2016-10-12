package com.santiagoosorio.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class PerfilActivity extends AppCompatActivity {
    TextView eusuario,eemail,econtraseña;
    String usuario,contrasena,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        eusuario = (EditText)findViewById(R.id.eUsuario);
        econtraseña = (EditText)findViewById(R.id.eContraseña);
        eemail = (EditText)findViewById(R.id.eemail);


        Bundle extras = getIntent().getExtras();
        usuario = (String.valueOf(extras.getString("usuario")));
        contrasena =(String.valueOf(extras.getString("contrasena")));
        email =(String.valueOf(extras.getString("email")));

        eusuario.setText("Usuario: "+usuario);
        econtraseña.setText("Contraseña: "+contrasena);
        eemail.setText("Email: "+email);
        eusuario.setTextSize(25);
        econtraseña.setTextSize(25);
        eemail.setTextSize(25);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_main){
            Intent i = new Intent(PerfilActivity.this,MainActivity.class);
            i.putExtra("usuario",usuario);
            i.putExtra("contrasena",contrasena);
            i.putExtra("email",email);
            startActivity(i);
        }
        if (id == R.id.menu_fragment){
            Intent i = new Intent(PerfilActivity.this,Main2Activity.class);
            i.putExtra("usuario",usuario);
            i.putExtra("contrasena",contrasena);
            i.putExtra("email",email);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
