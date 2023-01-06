package vttp2022.paf.assessment.eshop.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp2022.paf.assessment.eshop.exception.OrderException;
import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;
import vttp2022.paf.assessment.eshop.services.OrderService;

@Controller
@RequestMapping(path = "/#/status")
public class OrderController {

	@Autowired
	private OrderService orderSvc;
	
	@PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession sess)
            throws OrderException {

        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        if (null == lineItems) {
            
            lineItems = new LinkedList<>();
            sess.setAttribute("cart", lineItems);
        }

        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        lineItems.add(new LineItem(item, quantity));
         Order o = new Order();
        o.setName(form.getFirst("name"));
        for (LineItem li : lineItems)
            System.out.printf("item: %s, quantity: %d\n", li.getItem(), li.getQuantity());
        o.setLineItems(lineItems);

        sess.setAttribute("checkoutCart", o);
        model.addAttribute("lineItems", lineItems);

		sess.invalidate();
        orderSvc.createNewOrder(o);

        return "index";
    }











	//TODO: Task 3

}
