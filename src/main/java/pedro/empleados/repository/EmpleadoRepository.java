package pedro.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.empleados.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
