package com.example.review;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public String addReview(String entity) {
        // TODO Auto-generated method stub
        return new String("Review added");
    }

    public String deleteReview(String param) {
        // TODO Auto-generated method stub
        return new String("Review deleted");
    }

    public String updateReview(String id, String entity) {
        // TODO Auto-generated method stub
        return new String("Review updated");
    }

}