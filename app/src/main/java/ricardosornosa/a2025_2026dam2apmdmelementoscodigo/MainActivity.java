package ricardosornosa.a2025_2026dam2apmdmelementoscodigo;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.databinding.ActivityMainBinding;
import ricardosornosa.a2025_2026dam2apmdmelementoscodigo.models.AlumnoModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> cALauncher;
    private ArrayList<AlumnoModel> aList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        aList = new ArrayList<>();
        inicializarLaunchers();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        CrearAlumnoActivity.class
                );
                cALauncher.launch(intent);
            }
        });
    }

    private void inicializarLaunchers() {
        cALauncher = registerForActivityResult(
                new ActivityResultContracts
                        .StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == RESULT_OK) {
                            if (o.getData() != null) {
                                Intent intent = o.getData();
                                Bundle bundle = intent.getExtras();
                                AlumnoModel a = (AlumnoModel) bundle.getSerializable(
                                        "AL"
                                );
                                if (a != null) {
                                    aList.add(a);
                                    mostrarAlumnos();
                                }
                            }
                        }
                    }
                });
    }

    private void mostrarAlumnos() {
        binding.contentMain.contenedorMain.removeAllViews();
        for (AlumnoModel a : aList) {
            LayoutInflater li = LayoutInflater.from(MainActivity.this);
            View alumnoView = li.inflate(R.layout.alumno_model_view, null);
            TextView lblNombre =
                    alumnoView.findViewById(R.id.lblNombreAlumnoView);
            TextView lblApellidos =
                    alumnoView.findViewById(R.id.lblApellidosAlumnoView);
            TextView lblCiclo =
                    alumnoView.findViewById(R.id.lblCicloAlumnoView);
            TextView lblGrupo =
                    alumnoView.findViewById(R.id.lblGrupoAlumnoView);
            lblNombre.setText(a.getNombre());
            lblApellidos.setText(a.getApellidos());
            lblCiclo.setText(a.getCiclo());
            lblGrupo.setText(String.valueOf(a.getGrupo()));
            binding.contentMain.contenedorMain.addView(alumnoView);
        }
    }
}