package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.projection.CustomOrder;

@RepositoryRestResource(path = "order", collectionResourceRel = "list", excerptProjection = CustomOrder.class)

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
