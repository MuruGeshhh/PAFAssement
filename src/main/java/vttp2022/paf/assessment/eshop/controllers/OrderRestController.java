package vttp2022.paf.assessment.eshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;
import vttp2022.paf.assessment.eshop.services.WarehouseService;

@RestController
public class OrderRestController {


    @Autowired
    private OrderRepository ordersvc;

    @Autowired
    private WarehouseService waresvc;

    @PostMapping(path="http://paf.chuklee.com/dipatch/{order_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getOrder(@PathVariable(name="order_id") String order_id) {

       
	 	
		List<OrderStatus> or = waresvc.getCustomerByOrderID(order_id);

        // Build the result
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (OrderStatus c : or)
            arrBuilder.add(c.toJSON());
        JsonArray result = arrBuilder.build();
        System.out.println("" + result.toString());
        if (or.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{'error_code': " + HttpStatus.NOT_FOUND + "'}");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());

    }
	


    @GetMapping(path="/api/order/{name}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomer(@RequestParam String q) {
        
        List<OrderStatus> or = waresvc.getCustomerByOrderID(q);


        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (OrderStatus c : or)
            arrBuilder.add(c.toJSONORDEL());
        JsonArray result = arrBuilder.build();
        

        
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());

    }
    





}

