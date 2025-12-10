package com.pucetec.kiosko.controllers

import com.pucetec.kiosko.entities.Product
import com.pucetec.kiosko.services.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun listarProductos(): List<Product> {
        return productService.getAllProducts()
    }

    @PostMapping
    fun guardarProducto(@RequestBody product: Product): Product {
        return productService.createProduct(product)
    }
}