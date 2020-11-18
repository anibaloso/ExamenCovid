package cl.inacap.examencovid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import cl.inacap.examencovid.DTO.Paciente;

public class VistaPacienteActivity extends AppCompatActivity{

    Toolbar toolbar;
    private TextView rut, nombre, apellido, fecha, area_Trabajo, sintoma, temperatura, tos, arterial;
    private Paciente paciente;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_paciente);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.rut = findViewById(R.id.txtRut);
        this.nombre = findViewById(R.id.txtNombre);
        this.apellido = findViewById(R.id.txtApellido);
        this.fecha = findViewById(R.id.txtFecha);
        this.area_Trabajo = findViewById(R.id.txtArea);
        this.sintoma = findViewById(R.id.txtSintomas);
        this.temperatura = findViewById(R.id.txtTemperatura);
        this.tos = findViewById(R.id.txtTos);
        this.arterial = findViewById(R.id.txtPresion);


        if (getIntent().getExtras() != null) {
            this.paciente = (Paciente) getIntent().getSerializableExtra("paciente");
            this.rut.setText(paciente.getRut());
            this.nombre.setText(paciente.getNombre());
            this.apellido.setText(paciente.getApellido());
            this.fecha.setText(paciente.getFecha());
            this.area_Trabajo.setText(paciente.getArea_Trabajo());
            if(paciente.isSintoma()){
                this.sintoma.setText("Tiene Corana Virus");
            }else{
                this.sintoma.setText("No tiene Corana Virus");
            }
            this.temperatura.setText(String.valueOf(paciente.getTemperatura()));
            if(paciente.isTos()){
                this.tos.setText("Tiene Tos");
            }else{
                this.tos.setText("No tiene Tos");
            }
            this.arterial.setText(String.valueOf(paciente.getArterial()));
        }
    }

}
