package cl.inacap.examencovid.DTO;

import java.io.Serializable;

public class Paciente  implements Serializable {

    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private String fecha;
    private String area_Trabajo;
    private boolean sintoma;
    private double temperatura;
    private boolean tos;
    private int arterial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apelido) {
        this.apellido = apelido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
