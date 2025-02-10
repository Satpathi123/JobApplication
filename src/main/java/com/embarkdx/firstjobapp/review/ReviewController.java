package com.embarkdx.firstjobapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {
    @Autowired
     private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewbyCompanyId(@PathVariable Long companyId){

        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long companyId,
                                             @RequestBody Review reviews){
       boolean isreviewsaved= reviewService.addReview(companyId,reviews);
       if (isreviewsaved)

            return new ResponseEntity<>("Review added successfully",HttpStatus.CREATED);
       else
           return new ResponseEntity<>("Review not saved ",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{reviewId}")

    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
                                            @PathVariable Long reviewId){

        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,@RequestBody Review review ){
        boolean upadate= reviewService.updateReview(companyId,reviewId,review);
        if (upadate)
            return new ResponseEntity<>("review has  been updated ", HttpStatus.OK);
        else
            return  new ResponseEntity<>("review not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId){

        boolean isreviewDel=reviewService.deleteReview(companyId,reviewId);
        if (isreviewDel)
            return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Review  Not deleted ",HttpStatus.NOT_FOUND);
    }
}
