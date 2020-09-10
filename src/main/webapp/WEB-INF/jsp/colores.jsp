<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">+
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home</title>
<%@ include file="parts/header.jsp" %>
</head>
<body>
<%@ include file="parts/menu.jsp" %>

<main role="main" class="container">

  <div class="starter-template">
    <br><br>
    <button type="button" class="btn btn-success btn-lg btn-block" id="btnNuevoRegistro">Agregar tipo de pago</button>
    <br>
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
          <th scope="col">Estatus</th>
          <th scope="col">Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${registros}" var="registro">
            <tr>
                <td><c:out value="${registro.id}"/></td>
                <td><c:out value="${registro.nombre}"/></td>
                <td><c:out value="${registro.estatus}"/></td>
                <td>
                    <button type="button" class="btn btn btn-primary btn-sm editar" data-id='<c:out value="${registro.id}"/>'>Editar</button>
                  <c:choose>
                     <c:when test = "${registro.estatus == 'A'}">
                        <button type="button" class="btn btn btn-danger btn-sm deshabilitar" data-id='<c:out value="${registro.id}"/>'>Deshabilitar</button>
                     </c:when>
                     <c:otherwise>
                        <button type="button" class="btn btn btn-success btn-sm habilitar" data-id='<c:out value="${registro.id}"/>'>Habilitar</button>
                     </c:otherwise>
                  </c:choose>
                </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</main>
<div class="modal" tabindex="-1" id="modalEdicion">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="tituloModal"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
            <input type="hidden" id="accion">
            <input type="hidden" id="id">
          <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre">
          </div>
        </form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary" id="btnAceptarModal">Aceptar</button>
      </div>
    </div>
  </div>
</div>
<%@ include file="parts/footer.jsp" %>
<script type="text/javascript" src="js/colores.js"></script>
</body>
</html>