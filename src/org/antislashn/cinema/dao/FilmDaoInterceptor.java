package org.antislashn.cinema.dao;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

import org.antislashn.cinema.bo.Caddy;
@Singleton
@Interceptors(FilmDaoInterceptor.class)
public class FilmDaoInterceptor {
	
	private static final Logger LOG = Logger.getLogger(Caddy.class.getName());
	@PostConstruct
	public void init (InvocationContext ctx) {
		LOG.info("===> @PostConstruct de " +ctx.getTarget());
		
	}
	
	@PreDestroy
	public void destroy (InvocationContext ctx) {
		LOG.info("===> @PreDestroy de " +ctx.getTarget());
		
	}
	@AroundInvoke
	public Object foo (InvocationContext ctx) throws Exception {
		LOG.info("méthode invoquée : " +ctx.getMethod().getName());
		Object result = ctx.proceed();
		return result ;		
		}
	}
