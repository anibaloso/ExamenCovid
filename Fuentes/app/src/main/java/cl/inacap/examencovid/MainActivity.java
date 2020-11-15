package cl.inacap.examencovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import cl.inacap.examencovid.DAO.PacientesDAO;
import cl.inacap.examencovid.DAO.PacientesDAOLista;
import cl.inacap.examencovid.DTO.Paciente;
import cl.inacap.examencovid.adapters.PacientesListAdapter;

public class MainActivity extends AppCompatActivity {

    private List<Paciente> pacientes;
    private PacientesDAO pacientesDAO = PacientesDAOLista.getInstance();
    private ListView pacientesLV;
    private PacientesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.pacientes =this.pacientesDAO.getAll();
        this.pacientesLV =findViewById(R.id.pacientes_lv);
        this.adapter =new PacientesListAdapter(this,R.layout.pacientes_list,this.pacientes);
        this.pacientesLV.setAdapter(this.adapter);
    }
}