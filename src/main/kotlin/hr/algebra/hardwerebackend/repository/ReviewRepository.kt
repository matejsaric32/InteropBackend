package hr.algebra.hardwerebackend.repository

import hr.algebra.hardwerebackend.model.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional


interface ReviewRepository : JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.UID = :UID")
    fun findReviewByUID(@Param("UID") UID: String): Review?

    @Transactional
    @Modifying
    @Query("DELETE FROM Review r WHERE r.hardware.code = :hardwareCode")
    fun deleteAllByHardwareCode(@Param("hardwareCode") hardwareCode: String)

    @Query("SELECT r FROM Review r JOIN Hardware h ON r.hardware.code = :hardwareCode")
    fun findAllByHardwareCode(@Param("hardwareCode") hardwareCode: String): List<Review>

    @Transactional
    @Modifying
    @Query("DELETE FROM Review r WHERE r.UID = :UID")
    fun deleteByUID(UID: String)

}