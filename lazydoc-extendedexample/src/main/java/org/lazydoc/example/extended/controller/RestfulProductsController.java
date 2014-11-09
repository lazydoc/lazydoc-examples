package org.lazydoc.example.extended.controller;

import com.google.common.collect.ImmutableList;
import org.lazydoc.annotation.*;
import org.lazydoc.example.extended.controller.exception.ProductNotFoundException;
import org.lazydoc.example.extended.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@DomainDescription(order = 2, name = "Products", description="Operations for product management",
        subDomain = @SubDomainDescription(order = 1, name = "Product", description = "The defined product"))
public class RestfulProductsController {


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @OperationDescription(description = "Returns all products")
    @ResponseDescription(description = "A list of all products")
    public @ResponseBody List<Product> getProducts() {
        return ImmutableList.of(new Product());
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    @OperationDescription(description = "Returns the product for the given id")
    @ParameterDescription({@Parameter(name="productId", description = "The id of the product to be returned")})
    @ResponseDescription(description = "The product requested by id")
    public @ResponseBody Product getProduct(@PathVariable long productId) {
        return new Product();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @OperationDescription(description = "Creates a new product")
    @ParameterDescription({@Parameter(name="requestBody", description = "The data of the product to be created")})
    @ResponseDescription(description = "The newly created product")
    public @ResponseBody Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    @OperationDescription(description = "Updates a product specified by the id")
    @ParameterDescription({
            @Parameter(name = "productId", description = "The id of the product to be updated"),
            @Parameter(name="requestBody", description = "The data of the product to be created")})
    @ResponseDescription(description = "The updated product")
    public @ResponseBody Product updateProduct(@PathVariable long productId, @RequestBody Product product) {
        return new Product();
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    @OperationDescription(description = "Deletes the product for the given id")
    @ParameterDescription({@Parameter(name="productId", description = "The id of the product to be deleted")})
    @ResponseDescription(description = "This operation returns 200 if the product could be deleted")
    public @ResponseBody void deleteProduct(@PathVariable long productId) {
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ErrorDescription(description = "This error occurs if the customer was not found")
    public @ResponseBody
    String handleException(Exception ex) {
        return "The customer was not found";
    }

}
