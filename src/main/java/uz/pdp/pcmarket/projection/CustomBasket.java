package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Basket;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.entity.Users;

import java.util.List;

@Projection(types = Basket.class)
public interface CustomBasket {

    Integer getId();

    Users getCustom();

    List<Product> getProduct();
}
