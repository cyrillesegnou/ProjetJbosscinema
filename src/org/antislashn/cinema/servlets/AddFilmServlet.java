package org.antislashn.cinema.servlets;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.cinema.bo.Caddy;
import org.antislashn.cinema.entities.Film;
import org.antislashn.cinema.services.CinemaService;

/**
 * Servlet implementation class AddFilmServlet
 */
@WebServlet("/AddFilmServlet")
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("CINEMA");
	@EJB private CinemaService service;
//	@EJB private Caddy caddy ;
	@Inject private Caddy caddy ;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	Caddy caddy = (Caddy) request.getSession().getAttribute("caddy");
		String id = request.getParameter("id");
		try {
			long idFilm = Long.parseLong(id);
			Optional<Film> opt = service.findFilmById(idFilm);
			opt.ifPresent(caddy::add);
		}catch (Exception e) {
			LOGGER.log(Level.WARNING, ">>> identifiant mal formé : "+id,e);
		}
		String jimmy = "/ShowAllFilms";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jimmy);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
