package hr.algebra.hardwerebackend.repository

import hr.algebra.hardwerebackend.model.Hardware
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface HardwareRepository : JpaRepository<Hardware, Long> {

    @Query("SELECT h FROM Hardware h WHERE h.code = :code")
    fun findByCode(code: String): Hardware?

    @Transactional
    @Modifying
    @Query("DELETE FROM Hardware h WHERE h.code = :code")
    fun deleteByCode(code: String)

}