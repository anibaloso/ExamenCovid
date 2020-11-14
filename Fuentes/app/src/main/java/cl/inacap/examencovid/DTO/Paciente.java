package cl.inacap.examencovid.DTO;

import java.io.Serializable;
import java.util.Date;

public class Paciente  implements Serializable {

    private String rut;
    private String nombre;
    private String apelido;
    private Date fecha;
    private String area_Trabajo;
    private boolean sintoma;
    private double temperatura;
    private boolean tos;
    private int arterial;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArea_Trabajo() {
        return area_Trabajo;
    }

    public void setArea_Trabajo(String area_Trabajo) {
        this.area_Trabajo = area_Trabajo;
    }

    public boolean isSintoma() {
        return sintoma;
    }

    public void setSintoma(boolean sintoma) {
        this.sintoma = sintoma;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isTos() {
        return tos;
    }

    public void setTos(boolean tos) {
        this.tos = tos;
    }

    public int getArterial() {
        return arterial;
    }

    public void setArterial(int arterial) {
        this.arterial = arterial;
    }
}
