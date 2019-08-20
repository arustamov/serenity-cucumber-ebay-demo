package ebay.entity.property.file;

import ebay.entity.Category;
import ebay.entity.property.PropertyEntity;

public class FileCategory extends PropertyEntity implements Category {

   private String name;

   public FileCategory() {}

   @Override
   public String getName() {
      return name;
   }
}
