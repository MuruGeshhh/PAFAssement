package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

import vttp2022.paf.assessment.eshop.models.OrderStatus;

@Repository
public class OrderStatusRepository {

    @Autowired
    private JdbcTemplate template;


    public List<OrderStatus> getOrderbyOrderID(String orderid) {
        // prevent inheritance
        final List<OrderStatus> or = new LinkedList<>();
        // perform the query
        final SqlRowSet rs = template.queryForRowSet(SQL_SEARCH_ORDERS_BY_ORDERID, orderid);

        while (rs.next()) {
            or.add(OrderStatus.create(rs));
        }
        return or;
    }







    
}
