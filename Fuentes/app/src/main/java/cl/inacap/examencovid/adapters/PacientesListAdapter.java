package cl.inacap.examencovid.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.examencovid.DAO.PacientesDAO;
import cl.inacap.examencovid.DTO.Paciente;
import cl.inacap.examencovid.R;

public class PacientesListAdapter extends ArrayAdapter<Paciente> {

    private List<Paciente> pacientes;
    private Activity activity;

    public PacientesListAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.pacientes=objects;
        this.activity=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.activity.getLayoutInflater();
        View fila =inflater.inflate(R.layout.pacientes_list,null,true);
        TextView txtRut= fila.findViewById(R.id.txtRut);
        TextView txtNombre=fila.findViewById(R.id.txtNombre);
        TextView txtApellido=fila.findViewById(R.id.txtApellido);
        TextView txtFecha=fila.findViewById(R.id.txtFecha);
        Paciente actual=pacientes.get(position);
        txtRut.setText(actual.getRut());
        txtNombre.setText(actual.getNombre());
        txtApellido.setText(actual.getApellido());
        txtFecha.setText(actual.getFecha());
        return fila;
    }
}
