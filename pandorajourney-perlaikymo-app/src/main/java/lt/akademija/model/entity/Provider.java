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
    @Column(name = "Title", unique = true)
    private String name;
    private Long code;
    private Long grade;
    @Enumerated
    private Type type;

    @ElementCollection
    private Map<Services,Double> services = new HashMap<>();

    public void addService(Services service, Double price)
    {
        services.put(service,price);
    }

    public void removeService(Services service)
    {
        services.remove(service);
    }

    enum Type{
        LTD,PRIVATEPERSON,GOVERMENT
    }

    public void setType(String type){
        this.type = Type.valueOf(type);
    }

    public String getType(){
        return this.type.name();
    }
//    public String getType(){
//        this.type;
//    }

    //    @ElementCollection
////    @CollectionTable(name = "Merch", joinColumns = @JoinColumn(name = "BUERS_ID"))
////    @MapKeyJoinColumn(name = "Just_ID")
////    @JsonIgnore
//    @OneToMany
//    private Map<Services,PriceQuantity> cart = new HashMap();
}
