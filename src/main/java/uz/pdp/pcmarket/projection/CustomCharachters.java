package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Charachter;
import uz.pdp.pcmarket.entity.Detail;
import uz.pdp.pcmarket.entity.Product;

import java.util.List;

@Projection(types = Charachter.class)
public interface CustomCharachters {
    Integer getId();

    List<Detail> getDetail();

    Product getProduct();
}
