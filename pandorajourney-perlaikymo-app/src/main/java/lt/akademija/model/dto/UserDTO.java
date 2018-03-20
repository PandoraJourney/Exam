package lt.akademija.model.dto;


import lombok.Data;
import lt.akademija.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data

public class UserDTO {
    private Long id;
    private Long pid;
    private String firstName;
    private String lastName;
    private String address;
    private List<Long> orderIds;

    private static Logger logger = Logger.getLogger(UserDTO.class);


    public void init()
    {
        logger.info("Constructed");
    }

    public void destroy()
    {
        logger.info("Destroyed");
    }


    public UserDTO(User user)
    {
        BeanUtils.copyProperties(user, this);
        for(int i=0; i<user.getOrders().size(); i++)
        {
            orderIds.add(user.getOrders().get(i).getId());
        }
    }
}
