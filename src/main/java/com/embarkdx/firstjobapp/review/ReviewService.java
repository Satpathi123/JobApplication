package com.embarkdx.firstjobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyID);

    boolean addReview (Long companyId,Review review);

    Review getReview(Long companyId,Long reviewID);

     boolean updateReview(Long companyId, Long reviewID, Review review) ;

    boolean deleteReview(Long companyId, Long reviewId);
}
