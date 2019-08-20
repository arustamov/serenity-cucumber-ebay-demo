package ebay.entity;

public interface Item extends Entity {

    String getTitle();

    String getPrice();

    String getShippingPrice();

    String getCategory();
}
