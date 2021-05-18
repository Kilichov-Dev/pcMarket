package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Detail;
import uz.pdp.pcmarket.projection.CustomBlog;
import uz.pdp.pcmarket.projection.CustomInvoice;

@RepositoryRestResource(path = "invoice",collectionResourceRel = "list",excerptProjection = CustomInvoice.class)
public interface InvoiceRepository extends JpaRepository<Detail,Integer> {
}
