package ebay.entity.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ebay.entity.Entity;

public abstract class PropertyEntity implements Entity {

    private Integer id;

    public PropertyEntity() {}

//    public PropertyEntity(Integer id) {
//        this.id = id;
//    }

    @Override
    public Integer getId() {
        return id;
    }

    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
