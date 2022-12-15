<div class="modal fade" id="agregarClienteModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">

			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Agregar Equipos</h5>
				<button clase="clse" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>

			<form
				action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
				method="POST" class="was-validated">
				<div class="modal-body">

					<div class="form-group">
						<label for="Pais">Pais</label> 
						${paiss}
						<select class="form-select" name="idpais" aria-label="Default select example">
						<c:forEach var="paiss" items="${pais}" varStatus="status">
>								<option value="${paiss.idpais}">${paiss.codigo}</option>
						 </c:forEach>
							
						</select>
					</div>
					<div class="form-group">
						<label for="Pais">Marca</label> <select class="form-select"
							name="idmarca" aria-label="Default select example">
							<option value="1">LG</option>
							<option value="2">Dell</option>
							<option value="3">Levono</option>

						</select>
					</div>
					<div class="form-group">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" name="nombre" required>
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion</label> <input type="text"
							class="form-control" name="descripcion" required>
					</div>
					<!-- comment -->
					<div class="form-group">
						<label for="estado">Estado</label> <input type="text"
							class="form-control" name="estado" required>
					</div>

				</div>
				<div class="modal-footer">
					<button class="btn-primary" type="submit">Guardar Equipo</button>

				</div>

			</form>

		</div>
	</div>

</div>