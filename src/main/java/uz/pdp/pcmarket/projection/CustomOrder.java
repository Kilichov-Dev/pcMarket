package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.entity.Users;

import java.util.Date;
import java.util.List;

@Projection(types = Orders.class)
public interface CustomOrder {
    Integer getId();

    Users getCustomer();

    Date getDate();

    List<Product> getProduct();
}
