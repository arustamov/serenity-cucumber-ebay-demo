package ebay.entities;

import ebay.entity.Category;
import ebay.entity.Item;
import ebay.entity.property.file.FileItem;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface Categories<E extends Category> extends Entities<E, List<?>> {

    default Item newItem() {
        return new FileItem("Something");
    }
}
