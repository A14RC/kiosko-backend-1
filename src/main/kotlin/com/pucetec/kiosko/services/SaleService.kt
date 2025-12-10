package com.pucetec.kiosko.services

import com.pucetec.kiosko.entities.Sale
import com.pucetec.kiosko.repositories.SaleRepository
import org.springframework.stereotype.Service

@Service
class SaleService(
    private val saleRepository: SaleRepository,
    // private val productService: ProductService // Descomentar cuando integren ambas ramas
) {

    fun createSale(sale: Sale): Sale {
        // 1. Asignar la venta a cada detalle (relación bidireccional)
        sale.details.forEach { it.sale = sale }

        // 2. Aquí podríamos recalcular el total sumando los detalles para seguridad
        // val calculado = sale.details.sumOf { it.cantidad * it.precioUnitarioMomento }

        // 3. Guardar (El CascadeType.ALL guardará los detalles automáticamente)
        return saleRepository.save(sale)
    }

    fun getAllSales(): List<Sale> {
        return saleRepository.findAll()
    }
}