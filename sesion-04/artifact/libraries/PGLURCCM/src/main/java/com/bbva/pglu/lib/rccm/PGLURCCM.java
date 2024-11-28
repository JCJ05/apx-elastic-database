package com.bbva.pglu.lib.rccm;

import com.bbva.pglu.dto.elastic.customer.CustomerDTO;

/**
 * The  interface PGLURCCM class...
 */
public interface PGLURCCM {

	/**
	 * The execute method...
	 */
	void execute();

	CustomerDTO executeSearchCustomer(String customerId);
    String executeCreateCustomer(CustomerDTO customer);


}
