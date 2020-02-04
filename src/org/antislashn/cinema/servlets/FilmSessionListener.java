package org.antislashn.cinema.servlets;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.antislashn.cinema.bo.Caddy;

@WebListener
public class FilmSessionListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("caddy", new Caddy());
    }
    


    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
