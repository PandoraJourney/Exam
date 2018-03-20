package lt.akademija.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "User")
@Table(name = "User")
public class User {
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "User_Services",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Services> orders;

//
//    @ElementCollection
////    @CollectionTable(name = "Merch", joinColumns = @JoinColumn(name = "BUERS_ID"))
////    @MapKeyJoinColumn(name = "Just_ID")
////    @JsonIgnore
//    @OneToMany
//    private Map<Services,PriceQuantity> cart = new HashMap();
}
