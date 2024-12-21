package pedro.empleados.controller;

import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pedro.empleados.model.Empleado;
import pedro.empleados.service.EmpleadoService;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/")
    public String iniciar(ModelMap model){
        List<Empleado> empleados = empleadoService.listarEmpleado();
        empleados.forEach(empleado -> logger.info(empleado.toString()));
        model.put("empleados", empleados);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "add";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap model){
        Empleado empleado = empleadoService.buscarEmpleadoPorID(idEmpleado);
        logger.info("Empleado a editar: " + empleado);
        model.put("empleado", empleado);
        return "edit";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
        logger.info("Empleado a guardar " + empleado);
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        empleadoService.eliminarEmpleado(empleado);
        return "redirect:/";
    }
}
