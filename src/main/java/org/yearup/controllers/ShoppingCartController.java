package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
/*@Component
@RestController // convert this class to a REST controller
@RequestMapping("/api/shopping-cart") // only logged in users should have access to these actions*/
public class ShoppingCartController {

    private ShoppingCartDao shoppingCartDao;
    private UserDao userDao;
    private ProductDao productDao;

/*    @Autowired
    public ShoppingCartController(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.userDao = userDao;
        this.productDao = productDao;
    }*/

    @GetMapping
    @PreAuthorize("hasRole('Role_USER')")// each method in this controller requires a Principal object as a parameter
    public ShoppingCart getCart(Principal principal) {
        try {
            // get the currently logged in username
            String userName = principal.getName();
            // find database user by userId
            User user = userDao.getByUserName(userName);
            int userId = user.getId();

            ShoppingCart cart = shoppingCartDao.getByUserId(userId); // use the shoppingcartDao to get all items in the cart and return the cart
            return cart;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // add a POST method to add a product to the cart - the url should be
   /* @PostMapping("/products/{productId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ShoppingCart addProductToCart(@PathVariable int productId, Principal principal) {
        try {
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            int userId = user.getId();
            ShoppingCart updatedCart = shoppingCartDao.getByUserId(userId);

            if (updatedCart.contains(productId)) {
                ShoppingCartItem item = updatedCart.get(productId);
                int currentQuantity = item.getQuantity();
                int newQuantity = currentQuantity + 1;

                shoppingCartDao.addItem(productId, userId);
            }
            return shoppingCartDao.getByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // add a PUT method to update an existing product in the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added
    @PutMapping("/products/{productId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ShoppingCart updateCartItem(@PathVariable int productId, @RequestParam int quantity,
                                       Principal principal) {
        try {
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            int userId = user.getId();

            shoppingCartDao.updateItem(userId, productId, quantity);

            return shoppingCartDao.getByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }

        // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
        // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated
    }

    // add a DELETE method to clear all products from the current users cart
    @DeleteMapping(path = "/products/{productId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ShoppingCart clearCart(Principal principal) {
        try {
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            int userId = user.getId();

            shoppingCartDao.clearCart(userId);

            return shoppingCartDao.getByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }*/
}
// https://localhost:8080/cart


