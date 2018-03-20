package lt.akademija.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private static Logger logger = Logger.getLogger(ProductDTO.class);
    private Long id;
    private Long screen;
    private Long cartNo;
    private Long priceNo;

    public void init()
    {
        logger.info("ProductDTO constructed");
    }

    public void destroy()
    {
        logger.info("ProductDTO destroyed");
    }
}
