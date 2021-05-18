package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Detail;
import uz.pdp.pcmarket.projection.CustomBasket;
import uz.pdp.pcmarket.projection.CustomDetail;

@RepositoryRestResource(path = "basket",collectionResourceRel = "list",excerptProjection = CustomBasket.class)
public interface BasketRepository extends JpaRepository<Detail,Integer> {
}
