package vttp2022.paf.assessment.eshop.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Order;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

import java.util.LinkedList;
import java.util.List;




@Repository
public class OrderRepository {


	@Autowired
    private JdbcTemplate template;

    public boolean insertPurchaseOrder(Order order) {
        return template.update(SQL_INSERT_ORDERS,
                order.getOrderId(), order.getDeliveryId() , order.getName(),order.getAddress(), order.getEmail(), order.getStatus(), order.getOrderDate()) > 0;
    }


    public List<Order> getCustomerbyOrderID(String orderid) {
        // prevent inheritance
        final List<Order> or = new LinkedList<>();
        // perform the query
        final SqlRowSet rs = template.queryForRowSet(SQL_SEARCH_ORDERS_BY_ORDERID, orderid);

        while (rs.next()) {
            or.add(Order.create(rs));
        }
        return or;
    }


    public List<Order> getCustomerbyName(String name) {
        // prevent inheritance
        final List<Order> or = new LinkedList<>();
        // perform the query
        final SqlRowSet rs = template.queryForRowSet(SQL_SEARCH_ORDERS_BY_NAME, name);

        while (rs.next()) {
            or.add(Order.create(rs));
        }
        return or;

    }




	// TODO: Task 3
}
