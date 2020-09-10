<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <br><br><br>
    <a href="/zapatos/nuevo" class="btn btn-success btn-lg btn-block" role="button" aria-pressed="true">Agregar zapato</a>
    <br>
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Nombre</th>
          <th scope="col">Descripcion</th>
          <th scope="col">Color</th>
          <th scope="col">Costo</th>
          <th scope="col">Precio</th>
          <th scope="col">Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${registros}" var="registro">
            <tr>
                <td><c:out value="${registro.id}"/></td>
                <td><c:out value="${registro.nombre}"/></td>
                <td><c:out value="${registro.descripcion}"/></td>
                <td><c:out value="${registro.color.nombre}"/></td>
                <td><c:out value="${registro.costo}"/></td>
                <td><c:out value="${registro.precio}"/></td>
                <td>
                    <button type="button" class="btn btn btn-primary btn-sm editar" data-id='<c:out value="${registro.id}"/>'>Editar</button>
                    <button type="button" class="btn btn btn-danger btn-sm eliminar" data-id='<c:out value="${registro.id}"/>'>Eliminar</button>
                </td>
            </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</main>
<%@ include file="parts/footer.jsp" %>
</body>
</html>