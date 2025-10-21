package ricardosornosa.a2025_2026dam2apmdmelementoscodigo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.databinding.ActivityCrearAlumnoBinding;

public class CrearAlumnoActivity extends AppCompatActivity {
    private ActivityCrearAlumnoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                ActivityCrearAlumnoBinding
                        .inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}