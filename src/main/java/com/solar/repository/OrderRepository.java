package com.solar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solar.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long>{

}
