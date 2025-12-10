package com.pucetec.kiosko.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "sales")
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "fecha_hora")
    val fechaHora: LocalDateTime = LocalDateTime.now(),

    val total: Double = 0.0,

    @Column(name = "metodo_pago")
    val metodoPago: String = "Efectivo",

    @Column(name = "is_synced")
    var isSynced: Boolean = false, // Clave para la sincronización con la App

    @OneToMany(mappedBy = "sale", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var details: List<SaleDetail> = mutableListOf()
)