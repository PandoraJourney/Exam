package lt.akademija.model.entity;

import lombok.Data;
import org.springframework.web.util.AbstractUriTemplateHandler;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "tablet")
@Data
public class Tablet extends AbstractProduct {
    private Long screenSize;
}
