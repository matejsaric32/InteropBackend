package hr.algebra.hardwerebackend.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigDecimal

@Entity
@Data
open class Hardware(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(name = "NAME")
    open var name: String = "",

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    open var type: Type,

    @Column(name = "CODE")
    open var code: String = "",

    @Column(name = "STOCK")
    open var stock: Int = 0,

    @Column(name = "PRICE")
    open var price: BigDecimal = BigDecimal.ZERO
)