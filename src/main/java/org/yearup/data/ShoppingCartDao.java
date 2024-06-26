package org.yearup.data;

import org.yearup.models.ShoppingCart;

public interface ShoppingCartDao
{
    ShoppingCart getItems(int items);

    ShoppingCart getByUserId(int userId);

    ShoppingCart getByProductId(int productId);

    ShoppingCart getTotal(double total);

    // add additional method signatures here
}
