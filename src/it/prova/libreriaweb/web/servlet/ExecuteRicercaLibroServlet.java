package it.prova.libreriaweb.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.libreriaweb.model.Libro;

/**
 * Servlet implementation class ExecuteRicercaLibroServlet
 */
@WebServlet("/ExecuteRicercaLibroServlet")
public class ExecuteRicercaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<Libro> listaLibri = new ArrayList<Libro>();
	static {
		listaLibri.add(new Libro("Dune", "Fantasy", "500"));
		listaLibri.add(new Libro("Grammatica del Disegno", "Arte", "150"));
		listaLibri.add(new Libro("I Malavoglia", "Classici", "250"));

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteRicercaLibroServlet() {
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
		boolean flag = false;

		if (titoloParameter != null && !titoloParameter.isEmpty() && genereParameter != null
				&& !genereParameter.isEmpty() && pagineParameter != null && !pagineParameter.isEmpty() && pagineParameter.matches("[0-9]+")) {

			for (Libro libroItem : listaLibri) {

				if (libroItem.getTitolo().equalsIgnoreCase(titoloParameter)
						&& libroItem.getGenere().equalsIgnoreCase(genereParameter)
						&& libroItem.getPagine().equalsIgnoreCase(pagineParameter)) {

					flag = true;
				}
				if (flag) {
					break;
				}

			}

		}

		if (flag) {
			request.setAttribute("libro-attribute", new Libro(titoloParameter, genereParameter, pagineParameter));
			rd = request.getRequestDispatcher("risultatoPositivo.jsp");
		} else {
			rd = request.getRequestDispatcher("risultatoNegativo.jsp");
			request.setAttribute("crea-libro-attribute", "Vuoi creare un nuovo libro?");
			request.setAttribute("parametro-vuoto-attribute","" );

		}
		rd.forward(request, response);

	}

}
