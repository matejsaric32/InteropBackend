package hr.algebra.hardwerebackend.controller

import hr.algebra.hardwerebackend.model.dto.HardwareDTO
import hr.algebra.hardwerebackend.services.HardwareService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hardware")
//@CrossOrigin(origins = ["http://localhost:4200"])
class HardwareController(private val hardwareService: HardwareService) {

    @GetMapping
    fun getAllHardware() = ResponseEntity.ok(hardwareService.findAll())

    @GetMapping("/{code}")
    fun getHardwareByCode(@PathVariable code: String) = ResponseEntity.ok(hardwareService.findByCode(code))

    @PostMapping
    fun addHardware(@RequestBody hardwareDTO: HardwareDTO) = ResponseEntity.ok(hardwareService.save(hardwareDTO))

    @PutMapping
    fun updateHardware(@RequestBody hardwareDTO: HardwareDTO) = ResponseEntity.ok(hardwareService.update(hardwareDTO))

    @DeleteMapping("/{code}")
    fun deleteHardwareByCode(@PathVariable code: String) = ResponseEntity.ok(hardwareService.deleteByCode(code))

}