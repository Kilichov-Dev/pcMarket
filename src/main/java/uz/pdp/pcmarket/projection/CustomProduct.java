package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.entity.Product;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();

    String getName();

    Double getPrice();

    String getDescription();

    Category getCategory();

    List<Attachment> getPhoto();
}
