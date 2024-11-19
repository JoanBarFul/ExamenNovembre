package com.example.examennovembre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ThirdFragment extends Fragment {

    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private Button buttonChangeColor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.third_fragment, container, false);

        // Inicializar los SeekBars para RGB
        seekBarRed = rootView.findViewById(R.id.seekBarRed);
        seekBarGreen = rootView.findViewById(R.id.seekBarGreen);
        seekBarBlue = rootView.findViewById(R.id.seekBarBlue);
        buttonChangeColor = rootView.findViewById(R.id.buttonChangeColor);

        // Establecer el rango de los SeekBars (0-255)
        seekBarRed.setMax(255);
        seekBarGreen.setMax(255);
        seekBarBlue.setMax(255);

        // Configurar el botón para cambiar solo el color
        buttonChangeColor.setOnClickListener(v -> {
            int red = seekBarRed.getProgress();
            int green = seekBarGreen.getProgress();
            int blue = seekBarBlue.getProgress();

            String hexColor = String.format("#%02X%02X%02X", red, green, blue);

            Bundle bundle = new Bundle();
            bundle.putString("hexColor", hexColor);

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);

            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView2, secondFragment);
            transaction.commit();
        });

        return rootView;
    }
}
