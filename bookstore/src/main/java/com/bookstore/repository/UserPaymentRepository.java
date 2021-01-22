package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.UserPayment;
import com.bookstore.domain.UserShipping;

public interface UserPaymentRepository extends CrudRepository<UserPayment,Long>{

	

}
