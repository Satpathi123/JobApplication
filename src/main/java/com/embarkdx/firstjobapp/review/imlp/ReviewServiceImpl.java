package com.embarkdx.firstjobapp.review.imlp;

import com.embarkdx.firstjobapp.company.Company;
import com.embarkdx.firstjobapp.company.CompanyService;
import com.embarkdx.firstjobapp.review.Review;
import com.embarkdx.firstjobapp.review.ReviewRepository;
import com.embarkdx.firstjobapp.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllReview(Long companyId) {

        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company c=companyService.getCompanybyID(companyId);
        if (c!=null){
            review.setCompany(c);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewID) {
        List<Review> reviews =   reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(r->r.getId().equals(reviewID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewID, Review updatedReview) {
        if (companyService.getCompanybyID(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanybyID(companyId));
            updatedReview.setId(reviewID);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (companyService.getCompanybyID(companyId)!=null && reviewRepository.existsById(reviewId)){
            Review review =reviewRepository.findById(reviewId).orElse(null);
            Company company=review.getCompany();

            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return  true;

        }
        return false;


    }
}
