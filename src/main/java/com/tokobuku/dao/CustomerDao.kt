package com.tokobuku.dao

import com.tokobuku.model.Customer

interface CustomerDao {

    fun insert(customer: Customer)

    fun findByCustomerId(custId: Int): Customer?

    fun update(customer: Customer)

    fun delete(custId: Int)

}
