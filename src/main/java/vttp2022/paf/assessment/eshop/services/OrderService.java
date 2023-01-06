package vttp2022.paf.assessment.eshop.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2022.paf.assessment.eshop.exception.OrderException;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.respositories.CustomerRepository;
import vttp2022.paf.assessment.eshop.respositories.LineItemRepository;
import vttp2022.paf.assessment.eshop.respositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private LineItemRepository liRepo;

    @Autowired
    private OrderRepository orderRepo;


    public List<Order> getCustomerByName(String name) {
        return orderRepo.getCustomerbyName(name);
    }



    public List<Order> getCustomerByOrderID(String orderid) {
        return orderRepo.getCustomerbyOrderID(orderid);
    }

    @Transactional(rollbackFor = OrderException.class)
    public void createNewOrder(Order order) throws OrderException {

        // Generate orderId
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        System.out.printf(">>>> OrderId: %s\n", orderId);

        order.setOrderId(orderId);

        // Create the purchaseOrder
        orderRepo.insertPurchaseOrder(order);
        System.out.printf(">>>> order quantity: %s\n", order.getLineItems().size());
        if (order.getLineItems().size() > 5)
            throw new OrderException("Cannot order more than 5 items");
        // Create the associated line items
        liRepo.addLineItems(order.getLineItems(), orderId);

    }

    





    
}
