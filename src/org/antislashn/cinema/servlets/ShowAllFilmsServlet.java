package org.antislashn.cinema.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.cinema.entities.Film;
import org.antislashn.cinema.services.CinemaService;

/**
 * Servlet implementation class ShowAllFilmsServlet
 */
@WebServlet({ "/ShowAllFilmsServlet", "/ShowAllFilms" })
public class ShowAllFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private CinemaService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Film> films = service.findAllFilms();
		request.setAttribute("films", films);
		request.setAttribute("titre", "Liste des films");
		
		String jimmy = "/show-films.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jimmy);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
