package lt.akademija.model.entity;


import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue(value = "phone")
@Data
public class MobilePhone extends AbstractProduct {
    private boolean oneSimCard;

}
