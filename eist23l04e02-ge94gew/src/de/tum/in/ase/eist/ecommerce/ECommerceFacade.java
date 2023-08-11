package de.tum.in.ase.eist.ecommerce;

public class ECommerceFacade {

    // Instanzen
    private OrderController orderController;
    private AdvertisementController advertisementController;

    private ShippingController shippingController;

    public ECommerceFacade() {
        orderController = new OrderController();
        advertisementController = new AdvertisementController();
        shippingController = new ShippingController();
    }

    // Order Controller

    public void processOrder(Order order) {orderController.processOrder(order);}
    public void processOrder(Order order, String phoneNumber) {orderController.processOrder(order, phoneNumber);}
    public Order retrieveLatestOrder(int id) {return orderController.retrieveLatestOrder(id);}

    // Advertisement Controller

    public void playAdvertisement(int ageRestriction) {advertisementController.playAdvertisement(ageRestriction);}

    // Extra Funktionen

    public void shipOrder(Order order, String adress) {
        order.setShipping(shippingController.createShipping(adress));
        shippingController.shipOrder(order);
    }
}
