package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.xdevapi.JsonArray;

import org.springframework.http.MediaType;


import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import vttp2022.paf.assessment.eshop.models.Customer;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;

@RestController


@RequestMapping(path = "/findCustomerByName")
public class CustomerRestController {

    @Autowired
    private CustomerRepository cusRepo;

    @GetMapping()
    public ResponseEntity<String> getCustomer(@RequestParam(required = false) String q) {
        
        Optional<Customer> cus = cusRepo.findCustomerByName(q);

         if (cus.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{'error': Customer " + q + " not found'}");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(q.toString() + "exist");

    }

}











    

