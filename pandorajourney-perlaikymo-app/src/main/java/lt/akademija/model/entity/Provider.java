package lt.akademija.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
//@DiscriminatorValue(value = "tablet")
@Data
@Table(name = "PROVIDER")
public class Provider {

    @Id
    @GeneratedValue
    private Long iD;
    private String name;
    private Long code;
    private Long grade;

    @ElementCollection
    private Map<Services,Double> services = new HashMap<>();

    //    @ElementCollection
////    @CollectionTable(name = "Merch", joinColumns = @JoinColumn(name = "BUERS_ID"))
////    @MapKeyJoinColumn(name = "Just_ID")
////    @JsonIgnore
//    @OneToMany
//    private Map<Services,PriceQuantity> cart = new HashMap();
}
