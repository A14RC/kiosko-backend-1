package com.pucetec.kiosko.services

import com.pucetec.kiosko.entities.Product
import com.pucetec.kiosko.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    fun getProductById(id: Long): Product {
        return productRepository.findById(id).orElseThrow { RuntimeException("Producto no encontrado") }
    }

    fun createProduct(product: Product): Product {
        if (product.precio < 0) {
            throw IllegalArgumentException("El precio no puede ser negativo")
        }
        return productRepository.save(product)
    }


    fun updateStock(id: Long, cantidadVendida: Int) {
        val product = getProductById(id)
        if (product.stockActual < cantidadVendida) {
            throw RuntimeException("Stock insuficiente para el producto: ${product.nombre}")
        }
        product.stockActual -= cantidadVendida
        productRepository.save(product)
    }
}