package com.seunome.weatherapp.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.seunome.weatherapp.fragments.WeatherFragment;
import com.seunome.weatherapp.fragments.MapFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new WeatherFragment();
            case 1:
                return new MapFragment();
            default:
                return new WeatherFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Duas abas: Previsão e Mapa
    }
}