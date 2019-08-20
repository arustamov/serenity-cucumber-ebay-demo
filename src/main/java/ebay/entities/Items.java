package ebay.entities;

import ebay.entity.Category;
import ebay.entity.Item;
import ebay.entity.property.file.FileItem;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public interface Items<E extends Item> extends Entities<E, List<?>> {

    default Item newItem() {
        return new FileItem("Something");
    }

    Stream<E> ofTheCategory(Category category);
}
