package hr.algebra.hardwerebackend.model.dto

import hr.algebra.hardwerebackend.model.Type
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class UpdateHardwareDTO(
    @field:NotBlank(message = "Name must not be empty")
    @field:Size(max = 200, message = "Name can't have more than 200 characters")
    val name: String,

    @field:NotNull(message = "Type must be set to CPU, GPU, MBO, RAM, STORAGE or OTHER")
    val type: Type,

    @field:PositiveOrZero(message = "Stock must be positive or zero")
    @field:Max(value = 10000, message = "Stock can't be above 10000")
    val stock: Long,

    @field:PositiveOrZero(message = "Price must be positive or zero")
    @field:Digits(integer=5, fraction=2, message = "Price can't be higher than 99999")
    val price: BigDecimal
)
