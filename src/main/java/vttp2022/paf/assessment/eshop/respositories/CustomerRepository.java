package vttp2022.paf.assessment.eshop.respositories;

import java.lang.StackWalker.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;


import vttp2022.paf.assessment.eshop.models.Customer;

@Repository

public class CustomerRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {

		final List<Customer> rsvps = new LinkedList<>();
        SqlRowSet rs = null;
        // perform the query
        System.out.println("Q>" + name);

	 
        
            rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_CUSTOMERS_BY_NAME);

			
			 

			if(rs == null)
			{

				return Optional.empty();
			}

			else 

			


			return Optional.ofNullable(null);
			
		
        



		// TODO: Task 3 

	}

	






}
