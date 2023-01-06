package vttp2022.paf.assessment.eshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.models.OrderStatus;
import vttp2022.paf.assessment.eshop.respositories.OrderStatusRepository;

@Service
public class WarehouseService {

    @Autowired
	private OrderStatusRepository orderstsrepo;

	// You cannot change the method's signature
	// You may add one or more checked exceptions
	public OrderStatus dispatch(OrderStatus orderStatus) throws Exception{


		






		return null;

		// TODO: Task 4

	}

	public List<OrderStatus> getCustomerByOrderID(String orderid) {
		return orderstsrepo.getOrderbyOrderID(orderid);


	}
}
