package hr.algebra.hardwerebackend.model.dto

import jakarta.validation.constraints.*
import lombok.Data

@Data
data class ReviewDTO(
    val UID: String?,

    @field:NotBlank(message = "Name must not be empty")
    @field:Size(max = 200, message = "Name can't have more than 200 characters")
    var title: String,

    @field:NotNull(message = "Text must not be empty")
    @field:Size(max = 200, message = "Name can't have more than 200 characters")
    val text: String,

    @field:NotNull(message = "Rating must be set to 1, 2, 3, 4 or 5")
    @field:Min(0)
    @field:Max(5)
    val rating: Int,

    @field:NotNull(message = "Hardware must not be empty")
    var hardware: HardwareDTO
)