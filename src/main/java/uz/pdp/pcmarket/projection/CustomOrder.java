package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Order;
import uz.pdp.pcmarket.entity.Users;

import java.util.Date;

@Projection(types = Order.class)
public interface CustomOrder {
    Integer getId();

    Users getCustomer();

    Date getDate();
}
