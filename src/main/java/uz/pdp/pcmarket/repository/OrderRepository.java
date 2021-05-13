package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.pcmarket.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
