package com.santiagoosorio.addressbook;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {
    private ViewPager mViewPager;
    private String usuario,contrasena,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        usuario = (String.valueOf(extras.getString("usuario")));
        contrasena =(String.valueOf(extras.getString("contrasena")));
        email =(String.valueOf(extras.getString("email")));

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("Promociones").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Mapas").setTabListener(tabListener);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText("Negocios").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);

            }
        });


     /*   Para Fragmentos Dinámicos
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        SupermanFragment fragment = new SupermanFragment();
        ft.add(android.R.id.content, fragment).commit();*/
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MapasFragment();
                case 1:
                    return new PromocionesFragment();
                case 2:
                    return new NegociosFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
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
            Intent intent = new Intent(Main2Activity.this,PerfilActivity.class);
            intent.putExtra("usuario", usuario);
            intent.putExtra("contrasena", contrasena);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        if(id == R.id.menu_main){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("usuario", usuario);
            intent.putExtra("contrasena", contrasena);
            intent.putExtra("email", email);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
