<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />

<section id="clientes">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="form-group">
					<input type="text" class="form-control" name="precio"
						placeholder="Ingresa precio">
					<button class="btn btn-primary">Consultar</button>
				</div>
			</div>

			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h4>Listado de Equipos</h4>
					</div>


					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Cod Pais</th>
								<th>Nombre Pais</th>
								<th>Cod Marca</th>
								<th>Descrp Marca</th>
								<th>Nombre Equipo</th>
								<th>Descrp Equipo</th>
								<th>Estado EQuipo</th>
								<th></th>
							</tr>

						</thead>
						<tbody>

							<c:forEach var="equipos" items="${equipo}" varStatus="status">
								<tr>
									<td>${equipos[0]}</td>
									<td>${equipos[1]}</td>
									<td>${equipos[2]}</td>
									<td>${equipos[3]}</td>
									<td>${equipos[4]}</td>
									<td>${equipos[5]}</td>
									<td>${equipos[6]}</td>
									<td>${equipos[7]}</td>
									<td><a
										href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idEquipo=${equipos[0]}"
										class="btn btn-secondary"> <i
											class="fas fa-angle-double-right"></i> Editar

									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>


			</div>



		</div>
	</div>


</section>
<jsp:include page="agregarCliente.jsp" />