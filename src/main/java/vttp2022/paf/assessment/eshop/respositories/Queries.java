package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    

    public static final String SQL_SEARCH_CUSTOMERS_BY_NAME = "select name, address, email from customer where name = ?";



    public static String SQL_INSERT_LINE_ITEM = "insert into line_item(item, quantity, order_id) values (?, ?, ?)";


    public static String SQL_INSERT_ORDERS = "insert into purchase_order(order_id, delivery_id, name, address, email, status, order_date) values (?, ?, ?, ?, ?, ?, SYSDATE())";

    public static final String SQL_SEARCH_ORDERS_BY_ORDERID = "select order_id, delivery_id, name, address, email, status, orderdate, from orders where order_id = ?";

    public static final String SQL_SEARCH_ORDERS_BY_NAME = "select order_id, delivery_id, name, address, email, status, orderdate, from orders where name = ?";




}
