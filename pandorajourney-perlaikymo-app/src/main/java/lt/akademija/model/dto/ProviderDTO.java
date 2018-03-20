package lt.akademija.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lt.akademija.model.entity.Provider;
import lt.akademija.model.entity.Services;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ProviderDTO {
    private static Logger logger = Logger.getLogger(ProviderDTO.class);
    private Long iD;
    private String name;
    private Long code;
    private Long grade;
    private String type;
//    private Map<Long,Double> services = new HashMap<>();

    public void init()
    {
        logger.info("Constructed");
    }

    public void destroy()
    {
        logger.info("Destroyed");
    }

    public ProviderDTO(Provider provider)
    {
        BeanUtils.copyProperties(provider,this);
//        for(int i = 0; i<provider.getServices().size(); i++)
//        {
//            Key key =
//            services.ad
//        }
    }

}
