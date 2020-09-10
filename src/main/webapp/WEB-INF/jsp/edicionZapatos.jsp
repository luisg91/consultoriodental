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
    <a href="/zapatos" class="btn btn-success btn-lg btn-block" role="button" aria-pressed="true">Ver listado</a>
    <br>
    <form method="POST" action='<c:out value="${accion}"/>'>
      <div class="form-group">
        <label for="nombre">Nombre</label>
        <input type="text" class="form-control" id="nombre" name="nombre" value='<c:out value="${zapato.nombre}"/>'>
      </div>
      <div class="form-group">
        <label for="descripcion">Descripcion</label>
        <textarea class="form-control" id="descripcion" name="descripcion" rows="3"><c:out value="${zapato.descripcion}"/></textarea>
      </div>
      <div class="form-group">
        <label for="nombre">Costo</label>
        <input type="text" class="form-control" id="costo" name="costo" value='<c:out value="${zapato.costo}"/>'>
      </div>
      <div class="form-group">
        <label for="nombre">Precio</label>
        <input type="text" class="form-control" id="precio" name="precio" value='<c:out value="${zapato.precio}"/>'>
      </div>
      <div class="form-group">
        <label for="color">Color</label>
        <select class="form-control" id="color" name="color">
            <option value='0'>Selecione una opcion</option>
            <c:forEach items="${colores}" var="color">
                <option value='<c:out value="${color.id}"/>' <c:if test="${color.id == zapato.color.id}">selected</c:if> >
                    <c:out value="${color.nombre}"/>
                </option>
            </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="tallas">Example multiple select</label>
        <select multiple class="form-control" id="tallas" name="tallas">
            <c:forEach items="${tallas}" var="talla">
                <option value='<c:out value="${talla.id}"/>'>
                    <c:out value="${talla.nombre}"/>
                </option>
            </c:forEach>
        </select>
      </div>
    <button type="submit" class="btn btn-primary">Aceptar</button>
    <a href="/zapatos" class="btn btn-danger" role="button" aria-pressed="true">Cancelar</a>
    </form>
    <br><br>
  </div>

</main>
<%@ include file="parts/footer.jsp" %>
</body>
</html>