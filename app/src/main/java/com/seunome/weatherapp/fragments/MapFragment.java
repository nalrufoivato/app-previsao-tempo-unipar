package com.seunome.weatherapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapFragment extends Fragment {

    // CONFIGURAÇÃO PARA IVATÉ, PR
    private String cityName = "Ivaté";
    private String state = "PR";
    private double latitude = -23.4072;
    private double longitude = -53.3687;
    private int temperature = 24;
    private String condition = "Parcialmente nublado";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Layout principal
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);
        layout.setBackgroundColor(0xFFF0F8FF);

        // Título
        TextView title = new TextView(getContext());
        title.setText("🗺️ " + cityName + ", " + state);
        title.setTextSize(24);
        title.setTextColor(0xFF2E7D32);
        title.setPadding(0, 0, 0, 30);

        // Informações de Ivaté
        TextView info = new TextView(getContext());
        info.setText("📍 " + cityName + " - Paraná\n\n" +
                "📏 Latitude: " + latitude + "\n" +
                "📏 Longitude: " + longitude + "\n\n" +
                "🌡️ Temperatura atual: " + temperature + "°C\n" +
                "☁️ Condição: " + condition + "\n\n" +
                "🏞️ Cidade do Noroeste Paranaense\n" +
                "👥 População: ~8.000 habitantes\n\n" +
                "📷 QR Code - Em desenvolvimento\n" +
                "💡 Configure as dependências do ZXing");
        info.setTextSize(16);
        info.setTextColor(0xFF37474F);
        info.setPadding(0, 0, 0, 40);

        // FAB para QR Code - centralizado
        LinearLayout fabContainer = new LinearLayout(getContext());
        fabContainer.setOrientation(LinearLayout.VERTICAL);
        fabContainer.setGravity(android.view.Gravity.CENTER_HORIZONTAL);

        FloatingActionButton fab = new FloatingActionButton(getContext());
        fab.setImageResource(android.R.drawable.ic_menu_camera);
        fab.setSize(FloatingActionButton.SIZE_NORMAL);
        fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF2196F3));

        // Texto abaixo do FAB
        TextView fabText = new TextView(getContext());
        fabText.setText("QR Code (Em desenvolvimento)");
        fabText.setTextSize(14);
        fabText.setTextColor(0xFF2196F3);
        fabText.setPadding(0, 20, 0, 0);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQRCodeMessage();
            }
        });

        fabContainer.addView(fab);
        fabContainer.addView(fabText);

        layout.addView(title);
        layout.addView(info);
        layout.addView(fabContainer);

        return layout;
    }

    private void showQRCodeMessage() {
        android.widget.Toast.makeText(getContext(),
                "📷 QR Code Scanner\n\n" +
                        "Para ativar o scanner real:\n" +
                        "1. Adicione as dependências ZXing\n" +
                        "2. Sincronize o projeto\n" +
                        "3. Implemente as permissões de câmera",
                android.widget.Toast.LENGTH_LONG).show();
    }
}