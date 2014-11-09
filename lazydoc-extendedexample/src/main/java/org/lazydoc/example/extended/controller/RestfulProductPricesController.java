package org.lazydoc.example.extended.controller;

import com.google.common.collect.ImmutableList;
import org.lazydoc.annotation.*;
import org.lazydoc.example.extended.controller.exception.ProductNotFoundException;
import org.lazydoc.example.extended.entity.ProductPrice;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@DomainDescription(order = 2, name = "Products", description="Operations for product management",
        subDomain = @SubDomainDescription(order = 2, name = "Product-Prices", description = "The prices of the defined product"))
public class RestfulProductPricesController {


    @RequestMapping(value = "/products/{productId}/productprices", method = RequestMethod.GET)
    @OperationDescription(description = "Returns all productprices")
    @ParameterDescription({
            @Parameter(name="productId", description = "The id of the product of the product price")})
    @ResponseDescription(description = "A list of all productprices")
    public @ResponseBody List<ProductPrice> getProductPrices() {
        return ImmutableList.of(new ProductPrice());
    }

    @RequestMapping(value = "/products/{productId}/productprices/{productPriceId}", method = RequestMethod.GET)
    @OperationDescription(description = "Returns the product price for the given id")
    @ParameterDescription({
            @Parameter(name="productId", description = "The id of the product of the product price"),
            @Parameter(name="productPriceId", description = "The id of the product price to be returned")})
    @ResponseDescription(description = "The product requested by id")
    public @ResponseBody ProductPrice getProductPrice(@PathVariable long productId, @PathVariable long productPriceId) {
        return new ProductPrice();
    }

    @RequestMapping(value = "/products/{productId}/productprices", method = RequestMethod.POST)
    @OperationDescription(description = "Creates a new product price")
    @ParameterDescription({
            @Parameter(name="productId", description = "The id of the product of the product price"),
            @Parameter(name="requestBody", description = "The data of the product to be created")})
    @ResponseDescription(description = "The newly created product price")
    public @ResponseBody ProductPrice createProductPrice(@PathVariable long productId, @RequestBody ProductPrice productPrice) {
        return new ProductPrice();
    }

    @RequestMapping(value = "/products/{productId}/productprices/{productPriceId}", method = RequestMethod.PUT)
    @OperationDescription(description = "Updates a product price specified by the id")
    @ParameterDescription({
            @Parameter(name = "productId", description = "The id of the product of the product price"),
            @Parameter(name = "productPriceId", description = "The id of the product price to be updated"),
            @Parameter(name = "requestBody", description = "The data of the product to be created")})
    @ResponseDescription(description = "The updated product price")
    public @ResponseBody ProductPrice updateProductPrice(@PathVariable long productId, @PathVariable long productPriceId, @RequestBody ProductPrice product) {
        return new ProductPrice();
    }

    @RequestMapping(value = "/products/{productId}/productprices/{productPriceId}", method = RequestMethod.DELETE)
    @OperationDescription(description = "Deletes the product price for the given id")
    @ParameterDescription({
            @Parameter(name = "productId", description = "The id of the product of the product price"),
            @Parameter(name = "productPriceId", description = "The id of the product price to be deleted")})
    @ResponseDescription(description = "This operation returns 200 if the product could be deleted")
    public @ResponseBody void deleteProductPrice(@PathVariable long productId, @PathVariable long productPriceId) {
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ErrorDescription(description = "This error occurs if the customer was not found")
    public @ResponseBody
    String handleException(Exception ex) {
        return "The customer was not found";
    }

}
