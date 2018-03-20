package lt.akademija.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.akademija.model.entity.Services;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO implements Serializable{
    private static Logger logger = Logger.getLogger(ServiceDTO.class);
    private Long id;
    private String name;
    private byte[] picture;
    private String category;
    private String description;

    public void init()
    {
        logger.info("Constructed");
    }

    public void destroy()
    {
        logger.info("Destroyed");
    }


    public ServiceDTO(Services servs)
    {
        BeanUtils.copyProperties(servs,this);

    }

}
