package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.Users;

@Projection(types = Users.class)
public interface CustomUser {
    Integer getId();

    String getEmail();

    String getPhoneNumber();

    String getLastName();

    String getFirstName();

    Attachment getPhoto();
}
