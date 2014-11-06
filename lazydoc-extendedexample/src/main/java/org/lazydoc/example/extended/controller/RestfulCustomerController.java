package org.lazydoc.example.extended.controller;

import com.google.common.collect.ImmutableList;
import org.lazydoc.annotation.*;
import org.lazydoc.example.extended.controller.exception.CustomerNotFoundException;
import org.lazydoc.example.extended.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@DomainDescription(order = 1, name = "Customer", description="Operations for customer management")
public class RestfulCustomerController {


    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @OperationDescription(description = "Returns all customers")
    @ResponseDescription(description = "A list of all customers")
    public @ResponseBody List<Customer> getCustomers() {
        return ImmutableList.of(new Customer());
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    @OperationDescription(description = "Returns the customer for the given id")
    @ParameterDescription({@Parameter(name="customerId", description = "The id of the customer to be returned")})
    @ResponseDescription(description = "The customer requested by id")
    public @ResponseBody Customer getCustomer(@PathVariable long customerId) {
        return new Customer();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @OperationDescription(description = "Creates a new customer")
    @ParameterDescription({@Parameter(name="requestBody", description = "The data of the customer to be created")})
    @ResponseDescription(description = "The newly created customer")
    public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
        return new Customer();
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    @OperationDescription(description = "Updates a customer specified by the id")
    @ParameterDescription({
            @Parameter(name = "customerId", description = "The id of the customer to be updated"),
            @Parameter(name="requestBody", description = "The data of the customer to be created")})
    @ResponseDescription(description = "The updated customer")
    public @ResponseBody Customer updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) {
        return new Customer();
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    @OperationDescription(description = "Deletes the customer for the given id")
    @ParameterDescription({@Parameter(name="customerId", description = "The id of the customer to be deleted")})
    @ResponseDescription(description = "This operation returns 200 if the customer could be deleted")
    public @ResponseBody void deleteCustomer(@PathVariable long customerId) {
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ErrorDescription(description = "This error occurs if the customer was not found")
    public @ResponseBody
    String handleException(Exception ex) {
        return "The customer was not found";
    }

}
