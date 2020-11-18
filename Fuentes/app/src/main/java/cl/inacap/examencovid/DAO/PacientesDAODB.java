package cl.inacap.examencovid.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examencovid.DTO.Paciente;
import cl.inacap.examencovid.helpers.PacientesDBOpenHelper;

public class PacientesDAODB implements PacientesDAO{

    private PacientesDBOpenHelper db;

    public PacientesDAODB(Context contexto) {
        this.db = new PacientesDBOpenHelper(contexto, "DBPacientes", null, 1);
    }

    @Override
    public Paciente add(Paciente p) {
        SQLiteDatabase writer = this.db.getWritableDatabase();
        String sql = String.format("INSERT INTO paciente(" + "rut,nombre,apellido, fechaExamen, areaTrabajo, covid, temperatura, tos, presion) " +
                "VALUES('%s','%s','%s','%s','%s', %b, %d, %b, %d)", p.getRut(), p.getNombre(), p.getApellido(), p.getFecha(), p.getArea_Trabajo(), p.isSintoma(), p.getTemperatura(), p.isTos(), p.getArterial());
        writer.execSQL(sql);
        writer.close();
        return p;
    }

    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.db.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try {
            if (reader != null) {
                Cursor c = reader.rawQuery("SELECT * " +
                        "FROM paciente", null);
                if (c.moveToFirst()) {
                    do {
                        Paciente p = new Paciente();
                        p.setId(c.getInt(0));
                        p.setRut(c.getString(1));
                        p.setNombre(c.getString(2));
                        p.setApellido(c.getString(3));
                        p.setFecha(c.getString(4));
                        p.setArea_Trabajo(c.getString(5));
                        p.setSintoma(Boolean.valueOf(c.getString(6)));
                        p.setTemperatura(c.getDouble(7));
                        p.setTos(Boolean.valueOf(c.getString(8)));
                        p.setArterial(c.getInt(9));
                        pacientes.add(p);
                    } while (c.moveToNext());
                }
                reader.close();
            }

        } catch (Exception ex) {
            pacientes = null;
        }
        return pacientes;
    }
}
