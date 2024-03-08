package hr.algebra.hardwerebackend.services

import hr.algebra.hardwerebackend.model.dto.HardwareDTO


interface HardwareService {

    fun findAll(): List<HardwareDTO>

    fun findByCode(code: String): HardwareDTO?

    fun save(hardwareDTO: HardwareDTO): HardwareDTO?

    fun update(hardwareDTO: HardwareDTO): HardwareDTO?

    fun deleteByCode(code: String)

}