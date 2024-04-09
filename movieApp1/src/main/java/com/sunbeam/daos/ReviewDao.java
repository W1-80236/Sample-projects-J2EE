package com.sunbeam.daos;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;
@Repository
public class ReviewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ReviewRowMapper reviewRowMapper;
	
	public List<Review> findAll() {
		String sql = "SELECT * FROM reviews";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper);
		return list;
	}

	public List<Review> findByUserId(int userId) {
		String sql = "SELECT * FROM reviews WHERE user_id=?";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper, userId);
		return list;
	}

	public Review findById(int reviewId) {
		String sql = "SELECT * FROM reviews WHERE id=?";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper, reviewId);
		return list.isEmpty() ? null : list.get(0);
	}
	public int save(Review review) {
				String sql = "INSERT INTO reviews (review,rating,user_id,movie_id,modified) VALUES(?,?,?,?,NOW())";
				int count = jdbcTemplate.update(sql, review.getReview(), review.getRating(), review.getUserId(), review.getMovieId());
				return count;
			}
	public int deleteById(int reviewId) {
				String sql = "DELETE FROM reviews WHERE id=?";
				int count = jdbcTemplate.update(sql, reviewId);
				return count;
			}
	
	 public int editById(Review review) {
		 
			String sql ="UPDATE reviews SET movie_id=?, review=?, rating=?, user_id=?, modified=NOW() WHERE id=?";
			int count = jdbcTemplate.update(sql, review.getMovieId(),review.getReview(), review.getRating(), review.getUserId(), review.getId());
			return count;
	    }


	 public int shareReviewById(int reviewId, int userId) {
			String sql = "insert into shares  (review_id,user_id) values (? , ?) ";
			int count = jdbcTemplate.update(sql, reviewId, userId);
			return count;
		}
		
		
		public List<Review> findsharedreviews(int userId) {
			String sql = "SELECT r.* FROM reviews r INNER JOIN shares s ON r.id=s.review_id WHERE s.user_id=? ORDER BY modified DESC";
			List<Review> list = jdbcTemplate.query(sql, reviewRowMapper, userId);
			return list.isEmpty() ? null : list;
		}
}
