package com.example.examennovembre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {

    private EditText editText;
    private SeekBar textSizeSeekBar;
    private Button buttonUpdateText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.first_fragment, container, false);

        editText = rootView.findViewById(R.id.editText);
        textSizeSeekBar = rootView.findViewById(R.id.textSizeSeekBar);
        buttonUpdateText = rootView.findViewById(R.id.buttonUpdateText);


        textSizeSeekBar.setMax(20);
        textSizeSeekBar.setProgress(10);


        buttonUpdateText.setOnClickListener(v -> {
            String newText = editText.getText().toString();
            int newTextSize = textSizeSeekBar.getProgress() + 10;


            Bundle bundle = new Bundle();
            bundle.putString("text", newText);
            bundle.putInt("textSize", newTextSize);

            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);


            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView2, secondFragment);
            transaction.commit();
        });

        return rootView;
    }
}
