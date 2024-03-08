package hr.algebra.hardwerebackend.services

import hr.algebra.hardwerebackend.model.dto.ReviewDTO

interface ReviewService {

    fun findAll(): Set<ReviewDTO>

    fun findAllByHardwareCode(hardwareCode: String): Set<ReviewDTO>

    fun addReview(reviewDTO: ReviewDTO): ReviewDTO

    fun updateReview(reviewDTO: ReviewDTO): ReviewDTO?

    fun deleteReview(uid: String)

}