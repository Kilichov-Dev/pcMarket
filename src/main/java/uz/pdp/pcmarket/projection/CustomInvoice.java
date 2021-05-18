package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Invoice;
import uz.pdp.pcmarket.entity.Orders;
import uz.pdp.pcmarket.entity.Users;

import java.util.Date;

@Projection(types = Invoice.class)
public interface CustomInvoice {

    Integer getId();

    Users getCustomer();

    Orders getOrders();

    double getPrice();

    Date getCreate();

    Date getDueDate();

}
