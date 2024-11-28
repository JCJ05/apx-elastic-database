package com.bbva.pglu;

import com.bbva.pglu.dto.elastic.customer.CustomerDTO;
import com.bbva.pglu.lib.rccm.PGLURCCM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create Customer
 *
 */
public class PGLUTCCM01PETransaction extends AbstractPGLUTCCM01PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(PGLUTCCM01PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {

		PGLURCCM pglurccm = this.getServiceLibrary(PGLURCCM.class);
		LOGGER.info("LLAMANDO LA TRANSACCION");
		CustomerDTO customerDTO = this.getCustomerdto();
		String respuesta = pglurccm.executeCreateCustomer(customerDTO);
		this.setResponse(respuesta);

	}

}
