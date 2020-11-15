package cl.inacap.examencovid.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.inacap.examencovid.DTO.Paciente;

public class PacientesDAOLista implements PacientesDAO {

    private List<Paciente> pacientes = new ArrayList<>();
    private static PacientesDAOLista instancia;

    private PacientesDAOLista(){
        Paciente p=new Paciente();
        p.setRut("19655234-0");
        p.setNombre("Luis");
        p.setApellido("Rodriguez");
        p.setFecha(null);
        p.setArea_Trabajo("Construccion");
        p.setSintoma(true);
        p.setTemperatura(42);
        p.setTos(false);
        p.setArterial(70);
        pacientes.add(p);
        p=new Paciente();
        p.setRut("18209446-3");
        p.setNombre("Karen");
        p.setApellido("briceño");
        p.setFecha(null);
        p.setArea_Trabajo("Vendedora");
        p.setSintoma(true);
        p.setTemperatura(42);
        p.setTos(false);
        p.setArterial(70);
        pacientes.add(p);

    }
    public static PacientesDAOLista getInstance(){
        if(instancia==null){
            instancia=new PacientesDAOLista();
        }
        return instancia;
    }

    @Override
    public Paciente add(Paciente p) {
        pacientes.add(p);
        return p;
    }

    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }
}
