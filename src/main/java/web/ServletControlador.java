/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.ClienteDaoJDBC;
import datos.PaisDaoJDBC;
import dominio.Cliente;
import dominio.Equipo;
import dominio.Pais;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ServletControlador", urlPatterns = { "/ServletControlador" })
public class ServletControlador extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "editar":
				this.editarCliente(request, response);
				break;
			case "eliminar":
				this.eliminarCliente(request, response);
				break;

			default:
				this.accionDefault(request, response);
			}

		} else {
			this.accionDefault(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if (accion != null) {
			switch (accion) {
			case "insertar":
				this.insertarCliente(request, response);
				break;

			case "modificar":
				this.modificarCliente(request, response);
				break;
			case "eliminar":
				this.eliminarCliente(request, response);
				break;

			default:
				this.accionDefault(request, response);
			}

		} else {
			this.accionDefault(request, response);
		}
	}

	protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Object[]> equipos = new ClienteDaoJDBC().listar();
		System.out.println("equipo = " + equipos);
		
		List<Pais> pais=new PaisDaoJDBC().listar();
		System.out.println("pais = " + pais);
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("equipo", equipos);
		sesion.setAttribute("pais", pais);
		
		response.sendRedirect("clientes.jsp");
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));

		Equipo equipo = new ClienteDaoJDBC().buscar(new Equipo(idEquipo));
		System.out.print("equipos"+equipo);
		request.setAttribute("equipo", equipo);
		String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);
	}

	protected void modificarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
		int idpais = Integer.parseInt(request.getParameter("idpais"));
		int idmarca = Integer.parseInt(request.getParameter("idmarca"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");

		Equipo equipo = new Equipo(idEquipo,idpais, idmarca, nombre, descripcion, estado);
		int resgistrosModificados = new ClienteDaoJDBC().actualizar(equipo);
		this.accionDefault(request, response);

	}

	protected void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
		Equipo equipo = new Equipo(idEquipo);
		int registrosModificados = new ClienteDaoJDBC().eliminar(equipo);
		this.accionDefault(request, response);
	}

	protected void insertarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int idCliente=Integer.parseInt(request.getParameter("idCliente"));
		int idpais = Integer.parseInt(request.getParameter("idpais"));
		int idmarca = Integer.parseInt(request.getParameter("idmarca"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String estado = request.getParameter("estado");

		Equipo equipo = new Equipo(idpais, idmarca, nombre, descripcion, estado);
		int resgistrosModificados = new ClienteDaoJDBC().insertar(equipo);
		this.accionDefault(request, response);

	}
}