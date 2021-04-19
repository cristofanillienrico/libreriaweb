package it.prova.libreriaweb.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.libreriaweb.model.Libro;

/**
 * Servlet implementation class ExecuteAddLibroServlet
 */
@WebServlet("/ExecuteAddLibroServlet")
public class ExecuteAddLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteAddLibroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titoloParameter = request.getParameter("titoloInput");
		String genereParameter = request.getParameter("genereInput");
		String pagineParameter = request.getParameter("pagineInput");

		RequestDispatcher rd;

		if (titoloParameter != null && !titoloParameter.isEmpty() && genereParameter != null
				&& !genereParameter.isEmpty() && pagineParameter != null && !pagineParameter.isEmpty() && pagineParameter.matches("[0-9]+")) {
			
			ExecuteRicercaLibroServlet.listaLibri.add(new Libro(titoloParameter, genereParameter, pagineParameter));
			System.out.println(ExecuteRicercaLibroServlet.listaLibri.toString());

			rd = request.getRequestDispatcher("operazioneEffettuata.jsp");
			
		}else {
			request.setAttribute("parametro-vuoto-attribute","Riempi tutti i campi" );
			request.setAttribute("crea-libro-attribute", "");
			rd = request.getRequestDispatcher("risultatoNegativo.jsp");
		}
		
		rd.forward(request, response);

	}

}
