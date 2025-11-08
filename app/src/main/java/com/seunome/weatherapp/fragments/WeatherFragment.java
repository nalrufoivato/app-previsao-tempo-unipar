package com.seunome.weatherapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.seunome.weatherapp.WeatherAdapter;
import com.seunome.weatherapp.models.WeatherResponse;
import java.util.ArrayList;
import java.util.List;

public class WeatherFragment extends Fragment {

    private RecyclerView recyclerView;
    private WeatherAdapter adapter;
    private List<WeatherResponse.Forecast> forecastList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // CRIA TUDO PROGRAMATICAMENTE - SEM R
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Título
        TextView title = new TextView(getContext());
        title.setText("🌤️ Previsão do Tempo");
        title.setTextSize(24);
        title.setPadding(50, 50, 50, 30);

        // RecyclerView
        recyclerView = new RecyclerView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0
        );
        params.weight = 1;
        recyclerView.setLayoutParams(params);
        recyclerView.setPadding(20, 0, 20, 0);

        mainLayout.addView(title);
        mainLayout.addView(recyclerView);

        setupRecyclerView();
        loadSampleData();

        return mainLayout;
    }

    private void setupRecyclerView() {
        adapter = new WeatherAdapter(forecastList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void loadSampleData() {
        forecastList.clear();

        // Dados de exemplo
        String[] days = {"Hoje", "Amanhã", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
        int[] maxTemps = {28, 26, 24, 22, 25, 27, 29};
        int[] minTemps = {18, 17, 16, 15, 17, 18, 19};
        String[] conditions = {"Ensolarado", "Parcialmente nublado", "Nublado", "Chuva leve", "Sol", "Parcialmente nublado", "Ensolarado"};
        String[] icons = {"☀️", "⛅", "☁️", "🌧️", "☀️", "⛅", "☀️"};

        for (int i = 0; i < 7; i++) {
            final int index = i;
            WeatherResponse.Forecast forecast = new WeatherResponse.Forecast() {
                @Override
                public String getDate() { return "2024-01-" + (15 + index); }

                @Override
                public String getWeekday() { return days[index]; }

                @Override
                public int getMaxTemp() { return maxTemps[index]; }

                @Override
                public int getMinTemp() { return minTemps[index]; }

                @Override
                public String getDescription() { return icons[index] + " " + conditions[index]; }

                @Override
                public String getCondition() { return conditions[index].toLowerCase(); }
            };
            forecastList.add(forecast);
        }

        adapter.notifyDataSetChanged();
    }
}