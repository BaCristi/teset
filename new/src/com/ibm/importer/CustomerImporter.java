package com.ibm.importer;

import com.ibm.common.RowMapper;
import com.ibm.resources.Customer;

public class CustomerImporter extends FileImporter<Customer>{

	private RowMapper<Customer> rowMapper = new PhoneRowMapper();
	
	private class PhoneRowMapper extends RowMapper<Customer> {

		@Override
		protected Customer doMap() {
			Customer customer = new Customer();
			
			customer.setIdCustomer(nextLong());
			customer.setName(nextString());
			customer.setPhone(nextString());
			 
			return customer;
		}

	}

	@Override
	protected RowMapper<Customer> getRowMapper() {
		return rowMapper;
	}
}
