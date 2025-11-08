package com.seunome.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.seunome.weatherapp.fragments.WeatherFragment;
import com.seunome.weatherapp.fragments.MapFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayoutProgrammatically();
    }

    private void createLayoutProgrammatically() {
        // Layout principal
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));

        // Toolbar
        androidx.appcompat.widget.Toolbar toolbar = new androidx.appcompat.widget.Toolbar(this);
        LinearLayout.LayoutParams toolbarParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        toolbar.setLayoutParams(toolbarParams);
        toolbar.setBackgroundColor(0xFF2196F3); // Azul vibrante
        toolbar.setTitle("Previsão do Tempo");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        // TabLayout
        tabLayout = new TabLayout(this);
        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        tabLayout.setLayoutParams(tabParams);
        tabLayout.setBackgroundColor(0xFF2196F3); // Azul vibrante

        // ViewPager2
        viewPager = new ViewPager2(this);
        LinearLayout.LayoutParams viewPagerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0
        );
        viewPagerParams.weight = 1;
        viewPager.setLayoutParams(viewPagerParams);

        // Adiciona componentes ao layout principal
        mainLayout.addView(toolbar);
        mainLayout.addView(tabLayout);
        mainLayout.addView(viewPager);

        setContentView(mainLayout);
        setSupportActionBar(toolbar);

        // Configura as abas e ViewPager
        setupViewPager();
        setupTabLayout();
    }

    private void setupViewPager() {
        // Adapter programático
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @Override
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return new WeatherFragment();
                } else {
                    return new MapFragment();
                }
            }
        });
    }

    private void setupTabLayout() {
        // Cria as abas programaticamente
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("PREVISÃO");
                    } else {
                        tab.setText("MAPA");
                    }
                }
        ).attach();

        // Configura cores das abas
        tabLayout.setTabTextColors(0xFFE3F2FD, 0xFFFFFFFF); // Azul claro / Branco
        tabLayout.setSelectedTabIndicatorColor(0xFFFFFFFF); // Indicador branco
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu 100% programático - SEM R
        MenuItem aboutItem = menu.add(0, 1, 0, "Sobre");
        aboutItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) { // ID programático
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}