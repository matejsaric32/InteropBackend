package hr.algebra.hardwerebackend.services

import hr.algebra.hardwerebackend.model.Hardware
import hr.algebra.hardwerebackend.model.dto.ReviewDTO
import hr.algebra.hardwerebackend.repository.HardwareRepository
import hr.algebra.hardwerebackend.repository.ReviewRepository
import hr.algebra.hardwerebackend.utils.UIDFactory
import hr.algebra.hardwerebackend.utils.toDTO
import hr.algebra.hardwerebackend.utils.toEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val hardwareRepository: HardwareRepository
) : ReviewService {

    override fun findAll(): Set<ReviewDTO> =
        reviewRepository.findAll().map { it.toDTO() }.toSet()

    override fun findAllByHardwareCode(hardwareCode: String): Set<ReviewDTO> =
        reviewRepository.findAllByHardwareCode(hardwareCode).map { it.toDTO() }.toSet()

    @Transactional
    @Modifying
    override fun addReview(reviewDTO: ReviewDTO): ReviewDTO {
        val hardware: Hardware = hardwareRepository.findByCode(reviewDTO.hardware.code)
            ?: throw EntityNotFoundException("Hardware with code ${reviewDTO.hardware.code} not found")

        return reviewRepository.save(reviewDTO.toEntity().apply {
            this.hardware = hardware
            this.UID = UIDFactory.generateUID()
        }).toDTO()
    }

    override fun updateReview(reviewDTO: ReviewDTO): ReviewDTO? {
        val hardware: Hardware = hardwareRepository.findByCode(reviewDTO.hardware.code)
            ?: throw EntityNotFoundException("Hardware with code ${reviewDTO.hardware.code} not found")

        reviewDTO.UID?.let {
            reviewRepository.findReviewByUID(it)?.apply {
                this.UID = reviewDTO.UID
                this.title = reviewDTO.title
                this.text = reviewDTO.text
                this.rating = reviewDTO.rating
                this.hardware = hardware
            }?.let {
                return reviewRepository.save(it).toDTO()
            }
        } ?: throw EntityNotFoundException("Review with UID ${reviewDTO.UID} not found")
    }

    override fun deleteReview(uid: String) =
        reviewRepository.deleteByUID(uid)
}

