package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Comment;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.entity.Users;

import java.util.Date;

@Projection(types = Comment.class)
public interface CustomComment {

    Integer getId();

    String getMessage();

    Date getDate();

    Users getCustom();

    double getMark();

    Product getProduct();

}
