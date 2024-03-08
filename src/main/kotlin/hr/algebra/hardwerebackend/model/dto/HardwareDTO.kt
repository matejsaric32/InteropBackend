package hr.algebra.hardwerebackend.model.dto

import hr.algebra.hardwerebackend.model.Type
import jakarta.validation.constraints.*
import lombok.Data
import java.math.BigDecimal

@Data
data class HardwareDTO(
    @field:NotBlank(message = "Name must not be empty")
    @field:Size(max = 200, message = "Name can't have more than 200 characters")
    val name: String,

    @field:NotNull(message = "Type must be set to CPU, GPU, MBO, RAM, STORAGE or OTHER")
    val type: Type,

    @field:NotBlank(message = "Code must not be empty")
    @field:Size(min = 7, max = 7, message = "Code must have 7 characters")
    val code: String,

    @field:PositiveOrZero(message = "Stock must be positive or zero")
    @field:Min(value = 0, message = "Stock can't be less then 0")
    @field:Max(value = 10000, message = "Stock can't be above 10000")
    val stock: Int,


    @field:PositiveOrZero(message = "Price must be positive or zero")
    @field:Digits(integer = 5, fraction = 2, message = "Price can't be higher than 99999")
    val price: BigDecimal
)

