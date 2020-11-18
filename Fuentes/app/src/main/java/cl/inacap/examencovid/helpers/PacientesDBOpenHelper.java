package cl.inacap.examencovid.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacientesDBOpenHelper extends SQLiteOpenHelper {

    private final String sqlCreate ="CREATE TABLE paciente("+"id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            "rut TEXT,"+
            "nombre TEXT,"+
            "apellido TEXT,"+
            "fechaExamen TEXT,"+
            "areaTrabajo TEXT,"+
            "covid BOOLEAN,"+
            "temperatura FLOAT,"+
            "tos BOOLEAN,"+
            "presion INTEGER)";

    public PacientesDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(this.sqlCreate);
        sqLiteDatabase.execSQL("INSERT INTO paciente(rut,nombre,apellido, fechaExamen, areaTrabajo, covid, temperatura, tos, presion)"+
                "VALUES ('19655234-0'"+
                ",'Luis'" +
                ",'Rodriguez'" +
                ",'15/11/2020'" +
                ",'Otros'" +
                ", false" +
                ", 36.5" +
                ", false"+
                ",110)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS pacientes");
        sqLiteDatabase.execSQL(sqlCreate);
    }

}
