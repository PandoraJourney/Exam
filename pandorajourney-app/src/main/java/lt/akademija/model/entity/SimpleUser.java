package lt.akademija.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity(name = "SimpleUser")
@Table(name = "SUser")
public class SimpleUser{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "PERSONAL_ID", nullable = false, unique = true)
    private Long pid;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;


    private String address;

    @ElementCollection
//    @CollectionTable(name = "Merch", joinColumns = @JoinColumn(name = "BUERS_ID"))
//    @MapKeyJoinColumn(name = "Just_ID")
//    @JsonIgnore
    @OneToMany
    private Map<AbstractProduct,PriceQuantity> cart = new HashMap();
}
