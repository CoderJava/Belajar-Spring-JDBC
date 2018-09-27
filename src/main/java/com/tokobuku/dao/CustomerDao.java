package com.tokobuku.dao;

import com.tokobuku.model.Customer;

public interface CustomerDao {

    void insert(Customer customer);

    Customer findByCustomerId(int custId);

}
