package hr.algebra.hardwerebackend.controller

import hr.algebra.hardwerebackend.model.dto.ReviewDTO
import hr.algebra.hardwerebackend.services.ReviewService
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("review")
//@CrossOrigin(origins = ["http://localhost:4200"])
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping
    fun getAllReviews() = reviewService.findAll()

    @GetMapping(params = ["hardwareCode"])
    fun getAllReviewsByHardwareCode(@RequestParam hardwareCode: String) =
        ResponseEntity.ok(reviewService.findAllByHardwareCode(hardwareCode))

    @PostMapping
    fun addReview(@RequestBody reviewDTO: ReviewDTO) =
     ResponseEntity.ok(reviewService.addReview(reviewDTO))

    @PutMapping()
    fun updateReview(@RequestBody reviewDTO: ReviewDTO) =
        ResponseEntity.ok(reviewService.updateReview(reviewDTO))

    @DeleteMapping("/{uid}")
    fun deleteReview(@PathVariable uid: String) =
        ResponseEntity.ok(reviewService.deleteReview(uid))

}

