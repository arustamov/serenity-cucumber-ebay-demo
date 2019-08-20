package ebay.entities.file;

import com.fasterxml.jackson.core.type.TypeReference;
import ebay.entities.Items;
import ebay.entity.Category;
import ebay.entity.property.file.FileItem;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class FileItems extends FileEntities<FileItem> implements Items<FileItem> {

    public FileItems() {
        super("items.json", new TypeReference<List<FileItem>>(){});
    }

    @Override
    public Stream<FileItem> ofTheCategory(Category category) {
        return getAll()
            .filter(item -> category.getName().equals(item.getCategory()));
    }
}
