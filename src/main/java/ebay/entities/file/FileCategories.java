package ebay.entities.file;

import com.fasterxml.jackson.core.type.TypeReference;
import ebay.entities.Categories;
import ebay.entity.property.file.FileCategory;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileCategories extends FileEntities<FileCategory> implements Categories<FileCategory> {

    public FileCategories() {
        super("categories.json", new TypeReference<List<FileCategory>>(){});
    }
}
