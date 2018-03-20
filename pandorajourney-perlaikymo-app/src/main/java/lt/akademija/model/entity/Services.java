package lt.akademija.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Service_Type")
@Data
@Table(name = "SERVICES")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;
    @Column(name = "PICTURE")
    @Lob
    @JsonIgnore
    private byte[] picture;

    @Column(name = "SERVICE_CATEGORY")
//    @Enumerated
//    @JsonIgnore
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

//
//    enum Category {
//        IT, FOOD, TRANSPORTATION, BEAUTY, CHILDCARE;
//    }

}
