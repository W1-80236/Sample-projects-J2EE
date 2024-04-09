//package com.sunbeam.controllers;
//
//import java.util.List;
//
//import org.apache.catalina.connector.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.sunbeam.daos.MovieDao;
//import com.sunbeam.pojos.Movie;
//
//public class NewMoviesRestController {
//	@Autowired
//	private MovieDao movieDao;
//	
//	@GetMapping(value="json/movies", produces="application/json")
//	private Response<?> findAllJsonMovies(){
//		List<Movie> list = movieDao.findAll();
//		return Response.success(list);
//		
//	}
//	@GetMapping(value="/xml/movies", produces="text/xml")
//	private Response <?> findaAllXmlMovies(){
//		List<E> <Movie> list = movieDao.findAll();
//	    return Response.success(list);	
//	}
//
//}
