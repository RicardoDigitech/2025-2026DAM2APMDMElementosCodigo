package ricardosornosa.a2025_2026dam2apmdmelementoscodigo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.databinding.ActivityCrearAlumnoBinding;
import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.models.AlumnoModel;

public class CrearAlumnoActivity extends AppCompatActivity {
    private ActivityCrearAlumnoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                ActivityCrearAlumnoBinding
                        .inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCancelarCrearAlumno
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setResult(RESULT_CANCELED);
                                finish();
                            }
                        });

        binding.btnCrearCrearAlumno
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                AlumnoModel a = crearAlumno();
                                if (a != null) {
                                    Intent intent = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putSerializable(
                                            "AL", a
                                    );
                                    intent.putExtras(bundle);
                                    setResult(RESULT_OK, intent);
                                    finish();
                                }
                            }
                        });
    }

    private AlumnoModel crearAlumno() {
        if (binding.txtNombreCrearAlumno.getText()
                .toString().isEmpty() &&
                binding.txtApellidosCrearAlumno.getText()
                        .toString().isEmpty()) {
            return null;
        }

        if (binding.spCicloCrearAlumno
                .getSelectedItemPosition() == 0) {
            return null;
        }

        if (!binding.rbGrupoACrearAlumno.isChecked()
                && !binding.rbGrupoBCrearAlumno.isChecked()
                && !binding.rbGrupoCCrearAlumno.isChecked()) {
            return null;
        }

        String nombre = binding.txtNombreCrearAlumno
                .getText().toString();
        String apellido = binding.txtApellidosCrearAlumno
                .getText().toString();
        String ciclo = (String) binding.spCicloCrearAlumno
                .getSelectedItem();
        RadioButton rb =
                findViewById(binding.rgGrupoCrearAlumno
                        .getCheckedRadioButtonId());
        char grupo = rb.getText().charAt(6);
        AlumnoModel a = new AlumnoModel(
                nombre, apellido, ciclo, grupo
        );
        return a;
    }
}