package ebay.entities.file;

import com.fasterxml.jackson.core.type.TypeReference;
import ebay.entities.Customers;
import ebay.entity.property.file.FileCustomer;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileCustomers extends FileEntities<FileCustomer> implements Customers<FileCustomer> {

    public FileCustomers() {
        super("customers.json", new TypeReference<List<FileCustomer>>(){});
    }
}
