<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/3556f97ea7.js"
	crossorigin="anonymous"></script>


<title>EDITAR EQUIPOS</title>
</head>
<body>
	<jsp:include page="../comunes/cabecero.jsp" />

	<form
		action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idEquipo=${equipo.idequipo}"
		method="POST" class="was-validated">
		<jsp:include page="../comunes/botonesNavegacionEdicion.jsp" />
		<section id="details">
			<div class="container">
				<div class="row">
					<div class="col">
						<div class="card">
							<div class="card-header">
								<h4>Editar Equipos</h4>
							</div>
							<div class="card-body">
								<div class="form-group">
									<label for="Pais">Pais</label> 
									<select class="form-select"
										name="idpais" aria-label="Default select example">
										<option value="${equipo.idpais}">${equipo.idpais}</option>
										<option value="1">Peru</option>
										<option value="2">Ecuador</option>
										<option value="3">Argentina</option>
									</select>
								</div>
								<div class="form-group">
									<label for="Pais">Marca</label> <select class="form-select"
										name="idmarca" aria-label="Default select example">
										<option value="${equipo.idmarca}">${equipo.idmarca}</option>
										<option value="2">Dell</option>
										<option value="3">Levono</option>

									</select>
								</div>
								<div class="form-group">
									<label for="nombre">Nombre</label> <input type="text"
										class="form-control" name="nombre" required value="${equipo.nombre}">
								</div>
								<div class="form-group">
									<label for="descripcion">Descripcion</label> <input type="text"
										class="form-control" name="descripcion" required value="${equipo.descripcion}">
								</div>
								<!-- comment -->
								<div class="form-group">
									<label for="estado">Estado</label> <input type="text"
										class="form-control" name="estado" required value="${equipo.estado}">
								</div>
							</div>
							<!-- comment -->
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>

</body>
</html>
