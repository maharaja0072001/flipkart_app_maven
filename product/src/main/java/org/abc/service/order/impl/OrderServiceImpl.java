package org.abc.service.order.impl;

import org.abc.OrderStatus;
import org.abc.authentication.model.User;
import org.abc.model.order.Order;
import org.abc.service.order.OrderService;

import java.util.*;

/**
 * <p>
 * Provides the service for the Order.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class OrderServiceImpl implements OrderService {

    private static OrderService orderService;
    private static final Map<Integer, List<Order>> ORDERS = new HashMap<>();

    /**
     * <p>
     * Default constructor of the OrderServiceImpl class. Kept private to restrict from creating object from outside of this class.
     * </p>
     */
    private OrderServiceImpl() {}

    /**
     * <p>
     * Creates a single object of OrderServiceImpl Class and returns it.
     * </p>
     *
     * @return returns the single instance of OrderServiceImpl Class.
     */
    public static OrderService getInstance() {
        return Objects.isNull(orderService) ? orderService = new OrderServiceImpl() : orderService;
    }

    /**
     * <p>
     * Adds the order of the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @param order Refers the {@link Order} to be added.
     */
    @Override
    public void addOrder(final int userId, final Order order) {
        if (ORDERS.containsKey(userId)) {
            final List<Order> existingOrders = ORDERS.get(userId);

            existingOrders.add(order);
        } else {
            final List<Order> newOrders = new ArrayList<>();

            ORDERS.put(userId, newOrders);
            newOrders.add(order);
        }
    }

    /**
     * <p>
     * Gets all the orders placed by the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @return  all the {@link Order} of the user.
     */
    @Override
    public List<Order> getOrders(final int userId) {
        return ORDERS.get(userId);
    }

    /**
     * <p>
     * Cancels the order placed by the user.
     * </p>
     *
     * @param order Refers the {@link Order} to be cancelled.
     */
    @Override
    public void cancelOrder(final Order order) {
        order.setOrderStatus(OrderStatus.CANCELLED);
    }

    /**
     * <p>
     * Adds the address of the user.
     * </p>
     *
     * @param user Refers the current {@link User} .
     * @param address Refers the address to be added.
     */
    @Override
    public void addAddress(final User user, final String address) {
        user.addAddress(address);
    }

    /**
     * <p>
     * Gets all the addresses of the user.
     * </p>
     *
     * @param user Refers the current {@link User}.
     * @return the list of all the address.
     */
    @Override
    public List<String> getAllAddresses(final User user) {
        return user.getAddresses();
    }
}
