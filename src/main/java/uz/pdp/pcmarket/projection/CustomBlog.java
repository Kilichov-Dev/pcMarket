package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.Blog;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Projection(types = Blog.class)
public interface CustomBlog {

    Integer getId();

    String getTitle();

    String getBody();

    List<Attachment> getPhotos();

}
