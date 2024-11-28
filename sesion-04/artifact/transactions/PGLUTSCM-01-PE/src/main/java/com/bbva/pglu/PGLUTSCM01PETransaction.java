package com.bbva.pglu;

import com.bbva.pglu.dto.elastic.customer.CustomerDTO;
import com.bbva.pglu.lib.rccm.PGLURCCM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Search Customer
 *
 */
public class PGLUTSCM01PETransaction extends AbstractPGLUTSCM01PETransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(PGLUTSCM01PETransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		PGLURCCM pgluRCCM = this.getServiceLibrary(PGLURCCM.class);
		LOGGER.info("LLAMANDO LA TRANSACCION");
		CustomerDTO customerDTO = pgluRCCM.executeSearchCustomer(this.getClienteId());
		this.setClienteDTO(customerDTO);
	}

}
