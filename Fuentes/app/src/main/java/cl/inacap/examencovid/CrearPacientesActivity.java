package cl.inacap.examencovid;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cl.inacap.examencovid.DAO.PacientesDAO;
import cl.inacap.examencovid.DAO.PacientesDAODB;
import cl.inacap.examencovid.DTO.Paciente;
import cl.inacap.examencovid.adapters.PacientesListAdapter;

public class CrearPacientesActivity extends AppCompatActivity{

    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    java.util.Date fechaActual = new Date();
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();
    Toolbar toolbar;
    private TextView rut, nombre, apellido, fecha, temperatura, arterial;
    private Spinner area_Trabajo;
    private Switch sintoma, tos;
    private Paciente paciente;
    private Button btnGuardar;
    private PacientesDAO pacientesDAO = new PacientesDAODB(this);

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_paciente);
        this.toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.rut = findViewById(R.id.rutPaciente);
        this.nombre = findViewById(R.id.nombrePaciente);
        this.apellido = findViewById(R.id.apellidoPaciente);
        this.fecha = findViewById(R.id.etFecha);
        fecha.setOnClickListener(view -> showDialog(DATE_ID));

        this.area_Trabajo = findViewById(R.id.spinner_area_trabajo);
        this.sintoma = findViewById(R.id.switch_sintomas);
        this.temperatura = findViewById(R.id.temperatura);
        this.tos = findViewById(R.id.switch_tos);
        this.arterial = findViewById(R.id.presion_arterial);
        this.btnGuardar = findViewById(R.id.btn_agregar);

        this.btnGuardar.setOnClickListener(view -> {
            List<String> errores = new ArrayList<>();
            if(rut.getText().toString().isEmpty()) {
                errores.add("Rut no debe estar vacio");
            }else {
                char extracto = rut.getText().toString().charAt(rut.getText().toString().length() - 2);
                if(rut.getText().toString().length() == 9 || rut.getText().toString().length() == 10 && extracto == '-'){
                }else{
                    errores.add("Ingrese un rut valido");
                }
            }
            if(nombre.getText().toString().isEmpty()){
                errores.add("Nombre no debe estar vacio");
            }
            if(apellido.getText().toString().isEmpty()){
                errores.add("Apellido no debe estar vacio");
            }
            if(temperatura.getText().toString().isEmpty()){
                errores.add("Temperatura no debe estar vacio");
            }else{
                if(Double.parseDouble(temperatura.getText().toString()) < 20.0 ){
                    errores.add("Temperatura no puede ser menor a 20°, no sea longi ya esta muerto");
                }
            }
            if(arterial.getText().toString().isEmpty()) {
                errores.add("Presion alterial no debe estar vacio");
            }

            Date fechaCompara = StringAfecha(fecha.getText().toString());
            if(fechaCompara.before(fechaActual) && !fechaCompara.equals(fechaActual) ){
                errores.add("Fecha debe ser igual o mayor a Hoy");
            }

            if(errores.isEmpty()){
                Paciente p = new Paciente();
                p.setRut(rut.getText().toString());
                p.setNombre(nombre.getText().toString());
                p.setApellido(apellido.getText().toString());
                p.setFecha(fecha.getText().toString());
                p.setArea_Trabajo(area_Trabajo.getSelectedItem().toString());
                p.setSintoma(sintoma.isChecked());
                p.setTemperatura(Double.parseDouble(temperatura.getText().toString()));
                p.setTos(tos.isChecked());
                p.setArterial(Integer.parseInt(arterial.getText().toString()));
                pacientesDAO.add(p);
                Toast.makeText(CrearPacientesActivity.this, "Se ha creado correctamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CrearPacientesActivity.this, ListarPacientesActivity.class));
            }else {
                mostrarErrores(errores);
            }
        });
    }
    private void mostrarErrores(List<String> errores) {
        String mensaje = "";
        for (String e : errores) {
            mensaje += "-" + e + "\n";
        }
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(CrearPacientesActivity.this);
        alertBuilder.setTitle("Error de validación")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", null)
                .create()
                .show();
    }

    private void colocar_fecha() {
        fecha.setText( mDayIni+ "/" + (mMonthIni + 1) + "/" + mYearIni+" ");
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();
                }
            };

   @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }


    // TODO metodo para convertir las fechas de String a Date
    public static Date StringAfecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

}