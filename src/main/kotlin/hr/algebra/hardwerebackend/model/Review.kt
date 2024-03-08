package hr.algebra.hardwerebackend.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
open class Review (
    @Id
    @Column(name = "REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(name = "UID")
    open var UID: String = "",

    @Column(name = "TITLE")
    open var title: String = "",

    @Column(name = "TEXT")
    open var text: String = "",

    @Column(name = "RATING")
    open var rating: Int = 0,

    @ManyToOne
    @JoinColumn(name = "HARDWARE_ID", referencedColumnName = "ID")
    open var hardware: Hardware
)