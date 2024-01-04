package org.abc.dao.order;

import org.abc.authentication.model.User;
import org.abc.model.order.Order;

import java.util.List;

/**
 * <p>
 * Provides service for the OrderDAO.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public interface OrderDAO {

    /**
     * <p>
     * Adds the order placed by the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @param order Refers the {@link Order} to be added.
     */
    void addOrder(final int userId, final Order order);

    /**
     * <p>
     * Gets all the orders placed by the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @return  all the {@link Order} of the user.
     */
    List<Order> getOrders(final int userId);

    /**
     * <p>
     * Cancels the order placed by the user.
     * </p>
     *
     * @param order Refers the {@link Order} to be cancelled.
     */
    void cancelOrder(final Order order);

    /**
     * <p>
     * Adds the address of the user.
     * </p>
     *
     * @param user Refers the current {@link User} .
     * @param address Refers the address to be added.
     */
    void addAddress(final User user, final String address);

    /**
     * <p>
     * Gets all the addresses of the user.
     * </p>
     *
     * @param user Refers the current {@link User}.
     * @return the list of all the address.
     */
    List<String> getAllAddresses(final User user);
}
