package com.example.examennovembre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView textView;

    private String currentText = "Texto por defecto";
    private int currentTextSize = 16;
    private String currentColor = "#000000";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.second_fragment, container, false);

        textView = rootView.findViewById(R.id.textView);

        if (getArguments() != null) {
            String newText = getArguments().getString("text", null);
            if (newText != null) {
                currentText = newText; //
                textView.setText(currentText);
            }


            int newTextSize = getArguments().getInt("textSize", -1);
            if (newTextSize != -1) {
                currentTextSize = newTextSize;
                textView.setTextSize(currentTextSize);
            }


            String hexColor = getArguments().getString("hexColor", "#000000");
            if (hexColor != null) {
                currentColor = hexColor;
                textView.setTextColor(android.graphics.Color.parseColor(currentColor));
            }
        } else {

            textView.setText(currentText);
            textView.setTextSize(currentTextSize);
            textView.setTextColor(android.graphics.Color.parseColor(currentColor));
        }

        return rootView;
    }

    // Métodos para actualizar las variables
    public void updateText(String newText) {
        currentText = newText;
        textView.setText(newText);
    }

    public void updateTextSize(int newSize) {
        currentTextSize = newSize;
        textView.setTextSize(newSize);
    }

    public void updateColor(String hexColor) {
        currentColor = hexColor;
        textView.setTextColor(android.graphics.Color.parseColor(hexColor));
    }
}
