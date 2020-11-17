package cl.inacap.examencovid;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import cl.inacap.examencovid.adapters.PacientesListAdapter;

public class CrearPacientesActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_paciente);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }


}
