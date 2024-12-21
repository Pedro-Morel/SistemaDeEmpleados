package pedro.empleados.service;

import pedro.empleados.model.Empleado;

import java.util.List;

public interface IEmpleadoService {

    public List<Empleado> listarEmpleado();

    public Empleado buscarEmpleadoPorID(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}
