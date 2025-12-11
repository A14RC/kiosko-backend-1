package com.pucetec.kiosko.entities

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false)
    val precio: Double,

    @Column(name = "stock_actual", nullable = false)
    var stockActual: Int, // 'var' porque el stock cambia al vender

    @Column(name = "codigo_barras")
    val codigoBarras: String? = null
)