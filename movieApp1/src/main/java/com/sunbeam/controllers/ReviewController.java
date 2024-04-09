package com.sunbeam.controllers;

import java.util.List; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.css.CSSUnknownRule;

import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;
import com.sunbeam.services.MovieService;
import com.sunbeam.services.ReviewService;
import com.sunbeam.services.UserService;


@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/allreviews")
	public String getAllReviews(Model model) {
		List<Review> list = reviewService.findAllReviews();
		model.addAttribute("reviewList", list);
		model.addAttribute("title", "All Reviews");
		return "reviews";
	}

	@RequestMapping("/myreviews")
	public String getMyReviews(Model model, HttpSession session) {
		User user = (User) session.getAttribute("curUser");
		int userId = user.getId(); 
		List<Review> list = reviewService.findReviewsByUserId(userId);
		model.addAttribute("reviewList", list);
		model.addAttribute("title", "My Reviews");
		return "reviews";
	}
	
	@RequestMapping("/newreview")
	public String newReview(Model model) {
		List<Movie> list = movieService.findAllMovies();
		model.addAttribute("movieList", list);
		return "addreview";
	}
	
	@RequestMapping("/savereview")
	public String saveReview(Review review, HttpSession session) {
		User user = (User) session.getAttribute("curUser");
		review.setUserId( user.getId() );
		int count = reviewService.saveReview(review);
		return "redirect:/allreviews";
	}
	
	@RequestMapping("/delreview")
	public String deleteReview(@RequestParam("id") int reviewId) {
		int count = reviewService.deleteReviewById(reviewId);
		return "redirect:/allreviews";
	}
	
	@GetMapping("/editreview")
	 public String editReview(@RequestParam("id") int reviewId,HttpSession session) {
		Review review = reviewService.findReviewById(reviewId);
		session.setAttribute("review", review);
		return "editreview";
	}
	
	@PostMapping("/editreview")
	 public String editReview1(Review r,HttpSession session) {
		Review r1=(Review) session.getAttribute("review");
		r.setMovieId(r1.getMovieId());
		r.setUserId(r1.getUserId());
		int count = reviewService.editReviewById(r);
		return "redirect:/allreviews";
	}
	

//	@RequestMapping("/sharereview")
//	public String sharedReview(@RequestParam("id") int reviewId , HttpSession session,Model model) {
//		User user = (User) session.getAttribute("curUser");
//		List<User> list = userservice.getAllUser();
//		System.out.println(list);
//		model.addAttribute("userList", list);
//		model.addAttribute("reviewId",reviewId);
//		return "sharereview";
//		
//	}
//	@RequestMapping("/sharedreviews")
//	public String getsharedReviews(@RequestParam("id") int reviewId, Model model, int userId) {
//      int count = reviewService.shareReviewbyID(userId, reviewId);
//		model.addAttribute("title", "My Reviews");
//		return "redirect:/allreviews";
//	}
//	
	@RequestMapping("/sharereview")
	public String shareReview(Model model,@RequestParam("id") int reviewId, HttpSession session)
	{   
		User user = (User) session.getAttribute("curUser");
		List<User> list = userservice.getAllUser();
		System.out.println(list);
		model.addAttribute("userList", list);
		model.addAttribute("reviewId",reviewId);
		return "sharereview";
		
	}
		@RequestMapping("/sendreview")
		public String sendReview(Model model,@RequestParam("id") int ReviewId , int userId)
		{
			System.out.println(userId);
			int count = reviewService.shareReviewbyID(userId,ReviewId);
			return "redirect:/allreviews";
		}
		
		@RequestMapping("/reviewssharedwithme")
		public String reviewsSharedWithMe(Model model,HttpSession session)
		{
			User user =(User)session.getAttribute("curUser");
			int userId = user.getId();
			List<Review> list=reviewService.getSharedReview(userId);
			model.addAttribute("reviewList",list);
			System.out.println(list);
			return "sharedwithme";
		}
	}











