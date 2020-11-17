package cl.inacap.examencovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.examencovid.DAO.PacientesDAO;
import cl.inacap.examencovid.DAO.PacientesDAOLista;
import cl.inacap.examencovid.DTO.Paciente;
import cl.inacap.examencovid.adapters.PacientesListAdapter;

public class ListarPacientesActivity extends AppCompatActivity {

    private List<Paciente> pacientes;
    private PacientesDAO pacientesDAO = PacientesDAOLista.getInstance();
    private ListView pacientesLV;
    private PacientesListAdapter adapter;
    private FloatingActionButton btnAgregar;


    protected void onResume(){
        super.onResume();
        this.pacientes =this.pacientesDAO.getAll();
        this.pacientesLV =findViewById(R.id.pacientes_lv);
        this.adapter =new PacientesListAdapter(this,R.layout.pacientes_list,this.pacientes);
        this.pacientesLV.setAdapter(this.adapter);
        this.pacientesLV.setOnItemClickListener((adapterView, view, i, l) -> {
            Paciente paciente = pacientes.get(i);
            Toast.makeText(getApplicationContext(),paciente.getNombre() ,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ListarPacientesActivity.this,VistaPacienteActivity.class);
            //intent.putExtra("producto",producto);
            startActivity(intent);
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.btnAgregar = findViewById(R.id.btn_am);
        this.btnAgregar.setOnClickListener(view -> {
            Intent intent = new Intent(ListarPacientesActivity.this, CrearPacientesActivity.class);
            startActivity(intent);
        });
    }
}
