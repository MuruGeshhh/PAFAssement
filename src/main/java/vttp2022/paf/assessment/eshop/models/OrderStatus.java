package vttp2022.paf.assessment.eshop.models;

import java.io.ByteArrayInputStream;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

// DO NOT CHANGE THIS CLASS
public class OrderStatus {

	private String orderId;
	private String deliveryId = "";
	private String status = "pending"; // or "dispatched"

	public String getOrderId() { return this.orderId; }
	public void setOrderId(String orderId) { this.orderId = orderId; }

	public String getDeliveryId() { return this.deliveryId; }
	public void setDeliveryId(String deliveryId) { this.deliveryId = deliveryId; }

	public String getStatus() { return this.status; }
	public void setStatus(String status) { this.status = status; }




public static OrderStatus create(SqlRowSet rs) {
	OrderStatus r = new OrderStatus();
	r.setOrderId(rs.getString("order_id"));
	r.setDeliveryId(rs.getString("delivery_id"));
    r.setStatus(rs.getString("status"));	
	return r;
}

public static OrderStatus create(String jsonStr) throws Exception {
	JsonReader reader = Json.createReader(
			new ByteArrayInputStream(jsonStr.getBytes()));
	return create(reader.readObject());
}

private static OrderStatus create(JsonObject readObject) {
	final OrderStatus or = new OrderStatus();
	or.setOrderId(readObject.getString("order_id"));
	or.setDeliveryId(readObject.getString("delivery_id"));
    or.setStatus(readObject.getString("status"));
	
	return or;
}

public JsonObject toJSON() {
	return Json.createObjectBuilder()
			.add("orderID", getOrderId())
			.add("deliveryId", getDeliveryId())
			.add("status", getStatus())
			.build();
}


public JsonObject toJSONORDEL() {
	return Json.createObjectBuilder()
			.add("orderID", getOrderId())
			.add("deliveryId", getDeliveryId())
			.build();
}


}