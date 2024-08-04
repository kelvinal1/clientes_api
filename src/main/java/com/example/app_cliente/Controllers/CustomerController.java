package com.example.app_cliente.Controllers;

import com.example.app_cliente.Models.Customer;
import com.example.app_cliente.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CrossOrigin({"http://192.168.68.189:8281"})
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

@CrossOrigin("*")


public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("customer")
    public Customer postCustomer( @RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @GetMapping("/customers")
    private List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer  customer = customerService.getCustomerById(id);
        if(customer == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/customer-up/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer  existingCustomer = customerService.getCustomerById(id);
        if(existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updateCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/customer-dl/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        Customer existingCostomer = customerService.getCustomerById(id);
        if(existingCostomer == null)
            return ResponseEntity.notFound().build();
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }


}

