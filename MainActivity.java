package com.santiagoosorio.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    Menu mMenu,mMenu3;
     private String usuario,contrasena,email;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu = (Menu)findViewById(R.id.menu_perfil);



        Bundle extras = getIntent().getExtras();
        usuario = (String.valueOf(extras.getString("usuario")));
        contrasena =(String.valueOf(extras.getString("contrasena")));
        email =(String.valueOf(extras.getString("email")));

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.menu_perfil){
            Intent intent = new Intent(MainActivity.this,PerfilActivity.class);
            intent.putExtra("usuario", usuario);
            intent.putExtra("contrasena", contrasena);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        if(id == R.id.menu_fragment){
            Intent intent = new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("usuario", usuario);
            intent.putExtra("contrasena", contrasena);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
