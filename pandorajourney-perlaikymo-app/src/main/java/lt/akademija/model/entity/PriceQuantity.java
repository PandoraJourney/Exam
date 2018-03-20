package lt.akademija.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@Embeddable
public class PriceQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long quantity;
    private Long price;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "buyer_id")
//    private User buyer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Services product;
}
