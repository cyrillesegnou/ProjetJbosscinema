package org.antislashn.cinema.servlets;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.cinema.bo.Caddy;
import org.antislashn.cinema.entities.Film;

/**
 * Servlet implementation class DelFilmFromCaddy
 */
@WebServlet("/DelFilmFromCaddy")
public class DelFilmFromCaddy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("CINEMA");
	@Inject private Caddy caddy ;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	Caddy caddy = (Caddy) request.getSession().getAttribute("caddy");
		String id = request.getParameter("id");
		try {
			long idFilm = Long.parseLong(id);
			caddy.remove(idFilm);
		}catch (Exception e) {
			LOGGER.log(Level.WARNING, ">>> identifiant mal formé : "+id,e);
		}
		String jimmy = "/show-caddy.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jimmy);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
