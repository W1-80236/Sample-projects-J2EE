package com.sunbeam.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.pojos.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieDao movieDao;

	public List<Movie> findAllMovies() {
		List<Movie> list = movieDao.findAll();
		return list;
	}
}