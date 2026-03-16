package Food.test;

import Food.model.*;
import Food.exception.*;
import Food.service.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    @Test
    void testCalculateTotalPrice() {

        Order order = new Order("An");

        MenuItem burger = new Food("F01","Burger",50000,10);
        MenuItem coke   = new Drink("D01","Coke",20000,10, Size.M);

        order.getItems().put(burger,2);
        order.getItems().put(coke,1);

        double total = order.getTotalPrice();

        assertEquals(120000,total);
    }
    @Test
    void testInvalidOrderId() {

        OrderService orderService = new OrderService(new ArrayList<>());

        assertThrows(InvalidOrderIdException.class, () -> {

            orderService.payOrder("ORD999");

        });
    }
}
