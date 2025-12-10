package com.pucetec.kiosko.controllers

import com.pucetec.kiosko.entities.Sale
import com.pucetec.kiosko.services.SaleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/sales")
class SaleController(
    private val saleService: SaleService
) {

    @PostMapping
    fun registrarVenta(@RequestBody sale: Sale): Sale {
        return saleService.createSale(sale)
    }

    @GetMapping
    fun listarVentas(): List<Sale> {
        return saleService.getAllSales()
    }
}