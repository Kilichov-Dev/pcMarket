package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Charachter;
import uz.pdp.pcmarket.projection.CustomCharachters;

@RepositoryRestResource(path = "charachters",collectionResourceRel = "list",excerptProjection = CustomCharachters.class)
public interface CharachterRepository extends JpaRepository<Charachter,Integer> {
}
