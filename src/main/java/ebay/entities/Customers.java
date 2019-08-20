package ebay.entities;

import ebay.entity.Customer;
import ebay.entity.property.file.FileCustomer;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface Customers<E extends Customer> extends Entities<E, List<?>> {

    default Customer nonRegistered() {
        return new FileCustomer(
            String.format(
                "%s %s",
                randomFirstName(),
                randomLastName()
            )
        );
    }

    default String randomFirstName() {
        return getFaker().name().firstName();
    }

    default String randomLastName() {
        return getFaker().name().lastName();
    }
}
