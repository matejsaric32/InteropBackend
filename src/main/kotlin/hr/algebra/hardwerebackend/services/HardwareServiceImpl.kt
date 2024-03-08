package hr.algebra.hardwerebackend.services

import hr.algebra.hardwerebackend.exceptions.EntityAlreadyExists
import hr.algebra.hardwerebackend.model.dto.HardwareDTO
import hr.algebra.hardwerebackend.repository.HardwareRepository
import hr.algebra.hardwerebackend.utils.toDTO
import hr.algebra.hardwerebackend.utils.toEntity
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class HardwareServiceImpl(
    private val hardwareRepository: HardwareRepository
) : HardwareService {

    override fun findAll(): List<HardwareDTO> =
        hardwareRepository.findAll().map { it.toDTO() }

    override fun findByCode(code: String): HardwareDTO? =
        hardwareRepository.findByCode(code)?.let {
            return it.toDTO()
        } ?: throw EntityNotFoundException("Hardware with code $code not found")

    override fun save(hardwareDTO: HardwareDTO): HardwareDTO? {
        hardwareRepository.findByCode(hardwareDTO.code)?.let {
            throw EntityAlreadyExists("Hardware with code ${hardwareDTO.code} already exists")
        }
        return hardwareRepository.save(hardwareDTO.toEntity()).toDTO()
    }

    override fun update(hardwareDTO: HardwareDTO): HardwareDTO? {
        hardwareRepository.findByCode(hardwareDTO.code)?.apply {
            name = hardwareDTO.name
            type = hardwareDTO.type
            stock = hardwareDTO.stock
            price = hardwareDTO.price
        }?.let {
            return hardwareRepository.save(it).toDTO()
        } ?: throw EntityNotFoundException("Hardware with code ${hardwareDTO.code} not found")
    }

    override fun deleteByCode(code: String) =
        hardwareRepository.deleteByCode(code)


}