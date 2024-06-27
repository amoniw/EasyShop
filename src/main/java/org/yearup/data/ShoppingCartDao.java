package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao {
    ShoppingCart getByUserId(int UserId);

    // add additional method signatures here
    void addItem(int productId, int userId);

    void updateItem(int productId, int userId, int quantity);

    void removeItem(int productId, int userId);

    void clearCart(int userId);
}

