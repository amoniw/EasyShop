package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

@RestController // add REST controller
public class CategoriesController {
    private  CategoryDao categoryDao;

    @Autowired
    public CategoriesController (CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        List<Category> categories = categoryDao.getAllCategories();
        return categories;

    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
        public Category getCategoryById(@PathVariable int categoryId){
            return categoryDao.getById(categoryId);

    }

        @RequestMapping(path = "/categories", method = RequestMethod.POST)
        @ResponseStatus(value = HttpStatus.CREATED)
        public Category addCategory(@RequestBody Category category) {
            return categoryDao.insert(category);
    }
    // add the annotation to make this controller the endpoint for the following url
    //  http://localhost:8080/categories
    // add annotation to allow cross site origin requests


    }

    @Autowired // create an Autowired controller to inject the categoryDao and ProductDao
  public CategoriesController(CategoryDao ProductDao) {

        private CategoryDao categoryDao;
        private ProductDao productDao;


     // add the appropriate annotation for a get action
     @RequestMapping(path = "/categoryDao/{productDao}", method = RequestMethod.GET)
         // find and return all categories
     }


    // get the category by id
    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId)

        // get a list of product by categoryId
        return null;

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function

public Category addCategory(@RequestBody Category category) {
        @RequestMapping(path = "/category", method = RequestMethod.POST)
        return categoryDao.insert(category);
        // insert the category
        return null;
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.PUT)
    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    public void updateCategory(@PathVariable int id, @RequestBody Category category)

        public void updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        categoryDao.update(categoryId, category);
         // update the category by id
    }


    public void delete(int id ) {
        @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.DELETE)
        // add annotation to call this method for a DELETE action - the url path must include the categoryId
    }
     // add annotation to ensure that only an ADMIN can call this function
    public void deleteCategory(@PathVariable int id)

        public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(categoryId);
    }   // delete the category by id

    public CategoryDao getCategoryDao() {
        return categoryDao;

