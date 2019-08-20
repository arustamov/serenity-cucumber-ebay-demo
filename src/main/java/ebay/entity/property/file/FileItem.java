package ebay.entity.property.file;

import ebay.entity.Item;
import ebay.entity.property.PropertyEntity;

public class FileItem extends PropertyEntity implements Item {

   private String title;
   private String price;
   private String shipping;
   private String category;

   public FileItem() {}

   public FileItem(String title) {
      this.title = title;
   }

   @Override
   public String getTitle() {
      return title;
   }

   @Override
   public String getPrice() {
      return price;
   }

   @Override
   public String getShippingPrice() {
      return shipping;
   }

   @Override
   public String getCategory() {
      return category;
   }
}
