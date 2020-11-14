package cl.inacap.examencovid.DAO;

import java.util.List;

import cl.inacap.examencovid.DTO.Paciente;

public interface PacientesDAO {
    Paciente add(Paciente p);
    List<Paciente> getAll();
}
