package lt.akademija.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Service_Type")
@Data
@Table(name = "SERVICES")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Galima ji Id daryt, bet error prone
    @Column(name = "NAME", unique = true)
    private String name;
    @Column(name = "PICTURE")
    @Lob
    @JsonIgnore
    private byte[] picture;

    @Column(name = "SERVICE_CATEGORY")
    @Enumerated
    @JsonIgnore
    private Category category;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "orders",fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<User> users;

    public void addUser(User user)
    {
        this.users.add(user);
    }

    public void removeUser(User user)
    {
        this.users.remove(user);
    }


    enum Category {
        IT, FOOD, TRANSPORTATION, BEAUTY, CHILDCARE;
    }

    public void setCategory(String category)
    {
        this.category = Category.valueOf(category);
    }

    public String getCategory()
    {
        return category.name();
    }

}
