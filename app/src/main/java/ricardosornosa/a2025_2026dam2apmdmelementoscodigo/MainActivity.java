package ricardosornosa.a2025_2026dam2apmdmelementoscodigo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}