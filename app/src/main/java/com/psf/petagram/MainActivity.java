package com.psf.petagram;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.psf.petagram.adapters.PageAdapter;
import com.psf.petagram.views.activities.TopMascotas;
import com.psf.petagram.views.fragments.HomeFragment;
import com.psf.petagram.views.fragments.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private Resources resources;

    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        if(mainActionbar != null) setSupportActionBar(mainActionbar);

        resources = getResources();

        tab_layout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.view_pager);

        setupViewPager();
    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    };

    private void setupViewPager() {
        view_pager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tab_layout.setupWithViewPager(view_pager);

        try {
            tab_layout.getTabAt(0).setIcon(R.drawable.ic_home_24dp);
            tab_layout.getTabAt(1).setIcon(R.drawable.ic_dog_24);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnPhotoAction(View view) {
        Snackbar.make(view, resources.getString(R.string.label_take_photo), Snackbar.LENGTH_LONG)
                .setAction(resources.getString(R.string.label_fav_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Click en snackbar");
                    }
                })
                .setActionTextColor(resources.getColor(R.color.colorPrimary))
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_topmascotas:
                Intent iTop = new Intent(MainActivity.this, TopMascotas.class);
                startActivity(iTop);
                break;
            case R.id.menu_contact:
                Intent iContact = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(iContact);
                break;
            case R.id.menu_about:
                Intent iAbout = new Intent(MainActivity.this, Acercade.class);
                startActivity(iAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
