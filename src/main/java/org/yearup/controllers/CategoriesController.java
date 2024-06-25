package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

@RestController
@RequestMapping("categories") // add the annotation to make this controller the endpoint for the following url
// http://localhost:8080/categories
@CrossOrigin // add annotation to allow cross site origin requests
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;


    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    @GetMapping // add the appropriate annotation for a get action
    public List<Category> getAll() {
        // find and return all categories
        return categoryDao.getAllCategories();
    }


    @GetMapping("{id}") // add the appropriate annotation for a get action
    public Category getById(@PathVariable int id) {
        try {
            var category = categoryDao.getById(id);

            if (category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            return category;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {
        // get a list of product by categoryId
        return null;
    }

    @PostMapping // add annotation to call this method for a POST action
    @PreAuthorize("hasRole('ROLE_ADMIN')") // add annotation to ensure that only an ADMIN can call this function
    public Category addCategory(@RequestBody Category category) {

        // insert the category
        return null;
    }

    @PutMapping("{update}")
// add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    @PreAuthorize("hasRole('ROLE_ADMIN')") // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        // update the category by id
    }


    @DeleteMapping("{id}")
// add annotation to call this method for a DELETE action - the url path must include the categoryId
    @PreAuthorize("hasRole('ROLE_ADMIN')") // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id) {
        try {
            var category = categoryDao.getById(id);

            if (category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            categoryDao.delete(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // delete the category by id
    }
}