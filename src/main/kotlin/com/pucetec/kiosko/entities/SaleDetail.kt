package com.pucetec.kiosko.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "sale_details")
data class SaleDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonIgnore // Para evitar ciclos infinitos al convertir a JSON
    var sale: Sale? = null,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product,

    val cantidad: Int,

    @Column(name = "precio_unitario_momento")
    val precioUnitarioMomento: Double // Guardamos el precio histórico
)