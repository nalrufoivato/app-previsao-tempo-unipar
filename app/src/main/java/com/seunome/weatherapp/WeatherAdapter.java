package com.seunome.weatherapp;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.seunome.weatherapp.models.WeatherResponse;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherResponse.Forecast> forecastList;

    public WeatherAdapter(List<WeatherResponse.Forecast> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Cria TextView programaticamente - SEM R
        TextView textView = new TextView(parent.getContext());

        // Layout params
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(30, 15, 30, 15);
        textView.setLayoutParams(params);

        // Estilo do card
        textView.setPadding(40, 30, 40, 30);
        textView.setTextSize(16);
        textView.setBackgroundColor(0xFFFFFFFF); // Branco
        textView.setElevation(8f); // Sombra

        return new WeatherViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherResponse.Forecast forecast = forecastList.get(position);
        holder.bind(forecast);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WeatherViewHolder(@NonNull TextView itemView) {
            super(itemView);
            this.textView = itemView;
        }

        public void bind(WeatherResponse.Forecast forecast) {
            String weatherText = "📅 " + forecast.getWeekday() +
                    "\n🌡️ " + forecast.getMaxTemp() + "°C" +
                    "\n📝 " + forecast.getDescription();
            textView.setText(weatherText);
        }
    }
}