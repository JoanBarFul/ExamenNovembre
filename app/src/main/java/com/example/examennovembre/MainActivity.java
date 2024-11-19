package com.example.examennovembre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos el ConstraintLayout y el ImageView
        View constraintLayout2 = findViewById(R.id.constraintLayout2);
        View imageView = findViewById(R.id.imageView);
        View fondo = findViewById(R.id.fondo);

        // Inicialización de variables dentro de un objeto final
        final int[] posSol = {850};    // Usamos un array para hacer que la variable sea efectivamente final
        final int[] posFondo = {-2200}; // Usamos un array para hacer que la variable sea efectivamente final
        final boolean[] dia = {true};  // Usamos un array para hacer que la variable sea efectivamente final

        constraintLayout2.setOnClickListener(v -> {
            // Alternancia entre día y noche
            if (dia[0]) {
                posSol[0] = 850;
                posFondo[0] = -2200;
            } else {
                posSol[0] = -850;
                posFondo[0] = 2200;
            }
            dia[0] = !dia[0]; // Alternar entre día y noche

            // Animación del ImageView (sol)
            imageView.animate()
                    .translationYBy(posSol[0]) // Mover hacia abajo 850 píxeles
                    .setDuration(3000)   // Duración de 3 segundos
                    .start();

            // Animación del fondo
            fondo.animate()
                    .translationYBy(posFondo[0]) // Mover hacia arriba o abajo 2200 píxeles
                    .setDuration(3000)   // Duración de 3 segundos
                    .start();
        });

        // Obtenemos el botón para abrir la segunda actividad
        ImageButton buttonSecond = findViewById(R.id.buttonSecond);
        buttonSecond.setOnClickListener(v -> {
            // Abrir la segunda actividad
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
