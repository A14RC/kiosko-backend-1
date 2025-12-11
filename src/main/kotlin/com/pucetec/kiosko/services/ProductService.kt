package com.pucetec.kiosko.services

import com.pucetec.kiosko.entities.Product
import com.pucetec.kiosko.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    // Obtener todos los productos
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    // Buscar producto por ID
    fun getProductById(id: Long): Product {
        return productRepository.findById(id).orElseThrow { RuntimeException("Producto no encontrado") }
    }

    // Crear un nuevo producto (validando precio)
    fun createProduct(product: Product): Product {
        if (product.precio < 0) {
            throw IllegalArgumentException("El precio no puede ser negativo")
        }
        return productRepository.save(product)
    }

    // Actualizar stock después de una venta
    fun updateStock(id: Long, cantidadVendida: Int) {
        val product = getProductById(id)
        if (product.stockActual < cantidadVendida) {
            throw RuntimeException("Stock insuficiente para el producto: ${product.nombre}")
        }
        product.stockActual -= cantidadVendida
        productRepository.save(product)
    }

    // Actualizar información completa de un producto
    fun updateProduct(id: Long, productDetails: Product): Product {
        val existingProduct = productRepository.findById(id).orElseThrow { RuntimeException("Producto no encontrado") }

        val updatedProduct = existingProduct.copy(
            nombre = productDetails.nombre,
            precio = productDetails.precio,
            stockActual = productDetails.stockActual,
            codigoBarras = productDetails.codigoBarras
        )

        return productRepository.save(updatedProduct)
    }

    // Eliminar producto por ID
    fun deleteProduct(id: Long) {
        if (!productRepository.existsById(id)) {
            throw RuntimeException("Producto no encontrado")
        }
        productRepository.deleteById(id)
    }
}