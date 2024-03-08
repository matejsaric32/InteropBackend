package hr.algebra.hardwerebackend.utils

import hr.algebra.hardwerebackend.model.Hardware
import hr.algebra.hardwerebackend.model.Review
import hr.algebra.hardwerebackend.model.dto.HardwareDTO
import hr.algebra.hardwerebackend.model.dto.ReviewDTO

fun HardwareDTO.toEntity(): Hardware {
    return Hardware(
        name = name,
        type = type,
        code = code,
        stock = stock,
        price = price
    )
}

fun Hardware.toDTO(): HardwareDTO {
    return HardwareDTO(
        name = name,
        type = type,
        code = code,
        stock = stock,
        price = price
    )
}

fun ReviewDTO.toEntity(): Review {
    return Review(
        title = title,
        text = text,
        rating = rating,
        hardware = hardware.toEntity()
    )
}

fun Review.toDTO(): ReviewDTO {
    return ReviewDTO(
        UID = UID,
        title = title,
        text = text,
        rating = rating,
        hardware = hardware.toDTO()
    )
}

