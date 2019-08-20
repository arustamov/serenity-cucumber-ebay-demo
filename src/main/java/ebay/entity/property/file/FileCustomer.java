package ebay.entity.property.file;

import ebay.entity.Customer;
import ebay.entity.property.PropertyEntity;

public class FileCustomer extends PropertyEntity implements Customer {

   private String fullName;

   public FileCustomer() {}

   public FileCustomer(String fullName) {
      this.fullName = fullName;
   }

   @Override
   public String getFullName() {
      return fullName;
   }
}
