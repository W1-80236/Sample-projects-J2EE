package com.sunbeam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.pojos.Movie;
@RestController
public class MovieRestController {
	@Autowired
	private MovieDao moviedao;
	
	@GetMapping("/movies")
	public Map<String, Object> getMovies() {
				Map<String, Object> reply = new HashMap<>();
				try {
					List<Movie> list = moviedao.findAll();
					reply.put("status", "success");
					reply.put("data", list);			
				}
				catch (Exception e) {
					reply.put("status", "error");
					reply.put("error", e.getMessage());			
				}
				return reply;
	}
	@GetMapping("/movies/{id}")
	public Map<String, Object> getMovie(@PathVariable("id") int id) {
				Map<String, Object> reply = new HashMap<>();
				try {
					Movie m = moviedao.findById(id);
					reply.put("status", "success");
					reply.put("data", m);			
				}
				catch (Exception e) {
					reply.put("status", "error");
					reply.put("error", e.getMessage());			
				}
				return reply;
		}
	@PostMapping("/movies")
		public Map<String, Object> saveMovie(@RequestBody Movie m) {
			Map<String, Object> reply = new HashMap<>();
			try {
				int count = moviedao.save(m);
				reply.put("status", "success");
				reply.put("rowsAffected", count);
			} catch (Exception e) {
				e.printStackTrace();
				reply.put("status", "error");
				reply.put("rowsAffected", 0);
				reply.put("error", e.getMessage());
			}
			return reply;
		}	
	@DeleteMapping("/movies/{id}")
		public Map<String, Object> deleteMovie(@PathVariable("id") int id) {
			Map<String, Object> reply = new HashMap<>();
			try {
				int count = moviedao.deleteById(id);
				reply.put("status", "success");
				reply.put("rowsAffected", count);
			} catch (Exception e) {
				e.printStackTrace();
				reply.put("status", "error");
				reply.put("rowsAffected", 0);
				reply.put("error", e.getMessage());
			}
			return reply;		
		}
	@PutMapping("/movies/{id}")
		public Map<String, Object> updateMovie(@PathVariable("id") int id, @RequestBody Movie m) {
			m.setId(id);
			Map<String, Object> reply = new HashMap<>();
			try {
				int count = moviedao.update(m);
				reply.put("status", "success");
				reply.put("rowsAffected", count);
			} catch (Exception e) {
				e.printStackTrace();
				reply.put("status", "error");
				reply.put("rowsAffected", 0);
				reply.put("error", e.getMessage());
			}
			return reply;
		}

}
