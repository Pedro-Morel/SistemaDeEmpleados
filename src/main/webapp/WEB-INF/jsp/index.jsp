<%@ include file="common/header.jsp"%>
<%@ include file="common/nav.jsp"%>

<div class="container">
    <div class="text-center" style="margin. 30px">
        <h3>Sistema de Empleados</h3>
    </div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Salario</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="empleado" items="${empleados}">
                <tr>
                    <th scope="row">${empleado.idEmpleado}</th>
                    <td>${empleado.nombreEmpleado}</td>
                    <td>${empleado.departamento}</td>
                    <td>
                        <fmt:setLocale value="en_US"/>
                        <fmt:formatNumber type="currency" value="${empleado.salario}" currencySymbol="$"/>
                    </td>
                    <td class="text-center">
                        <a href="editar?idEmpleado=${empleado.idEmpleado}"
                           class="btn btn-warning btn-sm me-3">Editar</a>
                        <a href="eliminar?idEmpleado=${empleado.idEmpleado}"
                           class="btn btn-danger btn-sm">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<%@ include file="common/footer.jsp"%>