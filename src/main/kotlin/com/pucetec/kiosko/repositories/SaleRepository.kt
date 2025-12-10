package com.pucetec.kiosko.repositories

import com.pucetec.kiosko.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository : JpaRepository<Sale, Long>