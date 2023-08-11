package de.tum.in.ase.eist.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO 1 Add a new class ECommerceFacade in the package ecommerce.
//TODO 2 Implement all public methods of the OrderController in the facade.
public class OrderController {

    private static final int MAX_POPCORN_PRICE = 12;
    private static final int MAX_BOOK_PRICE = 10;
    private static final int MAX_NUMBER_OF_GENERATED_ITEMS = 3;

    public void processOrder(Order order) {
        System.out.println("Payment transaction completed.");
        createReceipt(order);
    }

    public void processOrder(Order order, String phoneNumber) {
        if (isPhoneNumberValid(phoneNumber)) {
            System.out.println("The customer gets a SMS for a successful transaction.");
        } else {
            System.out.println("The order couldn't be processed, as the phoneNumber " + phoneNumber + "  was incorrect.");
            return;
        }
        System.out.println("Payment transaction completed.");
        createReceipt(order);
    }

    public Order retrieveLatestOrder(int id) {
        if (id % 2 == 0) {
            System.out.println("Retrieve latest order for cinema " + id);
            return new Order(generateRandomItemList("popcorn", MAX_POPCORN_PRICE));
        } else {
            System.out.println("Retrieve latest order for book store " + id);
            return new Order(generateRandomItemList("book", MAX_BOOK_PRICE));
        }
    }

    private void createReceipt(Order order) {
        System.out.println("Creating receipt for order " + order.getId() + ".");
        System.out.println("Customer has paid $" + String.format("%1$,.2f", order.getPrice()) + " for order "
                + order.getId() + '.');
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private List<Item> generateRandomItemList(String product, double maxPrice) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER_OF_GENERATED_ITEMS; i++) {
            items.add(new Item(product + " " + i, Math.random() * maxPrice));
        }
        return items;
    }

    // similar to
    // https://stackoverflow.com/questions/42104546/java-regular-expressions-to-validate-phone-numbers
    private boolean isPhoneNumberValid(String phoneNumber) {
        String regex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{2,10}?";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(phoneNumber);
        return m.matches();
    }

}
