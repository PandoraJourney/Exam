package lt.akademija.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.logging.log4j.core.tools.Generate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Product_Type")
@Data
public class AbstractProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @JsonIgnore
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<PriceQuantity> price = new ArrayList<>();
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "cart", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private List<SimpleUser> users = new ArrayList<>();

//    public void addSimpleUser(SimpleUser user)
//    {
//        users.add(user);
//    }
//
//    public void removeSimpleUser(SimpleUser user)
//    {
//        users.remove(user);
//    }
}
