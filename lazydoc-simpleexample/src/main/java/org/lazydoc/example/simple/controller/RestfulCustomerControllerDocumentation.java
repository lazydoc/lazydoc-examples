package org.lazydoc.example.simple.controller;

import org.lazydoc.annotation.DomainDescription;
import org.lazydoc.annotation.OperationDescription;
import org.lazydoc.annotation.Parameter;
import org.lazydoc.annotation.ParameterDescription;
import org.lazydoc.example.simple.entity.Customer;

import java.util.List;

@DomainDescription(name = "Customer", description = "Operations for customer management")

public interface RestfulCustomerControllerDocumentation {
    @OperationDescription(description = "This operation returns all customers")
    List<Customer> getCustomers();

    @OperationDescription(description = "This return specific customer")
    @ParameterDescription({@Parameter(name ="customerId", description = "This is the id to get the customer")})
    Customer getCustomer( long customerId);

    @OperationDescription(description = "This return specific customer")
    @ParameterDescription({@Parameter(name ="requestBody", description = "This is the id to get the customer")})
    Customer createCustomer( Customer customer);

    @OperationDescription(description = "This return specific customer")
    @ParameterDescription({@Parameter(name ="customerId", description = "This is the id to get the customer"), @Parameter(name ="requestBody", description = "This is the id to get the customer")})
    Customer updateCustomer( long customerId,  Customer customer);

    @OperationDescription(description = "This return specific customer")
    @ParameterDescription({@Parameter(name ="customerId", description = "This is the id to get the customer")})
    void deleteCustomer( long customerId);
}
