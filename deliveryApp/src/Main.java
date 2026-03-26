import com.delivery.enums.PaymentMode;
import com.delivery.model.*;
import com.delivery.service.PaymentServiceResolver;
import com.delivery.service.impl.DeliveryServiceImpl;
import com.delivery.service.impl.OrderServiceImpl;
import com.delivery.service.impl.RestaurantServiceImpl;
import com.delivery.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 🔹 Initialize Services
        UserServiceImpl userService = new UserServiceImpl();
        RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();
        DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();
        PaymentServiceResolver paymentResolver = new PaymentServiceResolver();

        OrderServiceImpl orderService = new OrderServiceImpl(
                userService,
                restaurantService,
                deliveryService,
                paymentResolver
        );

        // 🔹 Create User
        User user = userService.registerUser("Rajesh", "9999999999");

        Address address = new Address("A1", "Bangalore", "KA", "560001");
        userService.addAddress(user.getId(), address);

        // 🔹 Create Food Items
        FoodItem item1 = new FoodItem("F1", "Burger", 100);
        FoodItem item2 = new FoodItem("F2", "Pizza", 200);

        Menu menu = new Menu("M1", Arrays.asList(item1, item2));

        // 🔹 Create Restaurant
        Restaurant restaurant = new Restaurant("R1", "Food Hub", menu);
        restaurant.setCity("Bangalore");

        // Add restaurant to map
        restaurantService.addRestaurant(restaurant);

        // 🔹 Create Delivery Partner
        DeliveryPartner partner = new DeliveryPartner("D1", "Ravi", "8888888888");
        deliveryService.addDeliveryPartner(partner);

        // 🔹 Create Order Items
        OrderItem orderItem1 = new OrderItem("OI1", item1, 2);
        OrderItem orderItem2 = new OrderItem("OI2", item2, 1);

        List<OrderItem> orderItems = Arrays.asList(orderItem1, orderItem2);

        // 🔹 Place Order
        Order order = orderService.placeOrder(
                user.getId(),
                restaurant.getId(),
                orderItems,
                address.getId(),
                PaymentMode.UPI
        );

        // 🔹 Print Output
        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Payment Status: " + order.getPayment().getStatus());
        System.out.println("Delivery Partner: " + order.getDeliveryPartner().getName());
    }
}