package com.bbva.pglu;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pglu.dto.elastic.customer.CustomerDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPGLUTCCM01PETransaction extends AbstractTransaction {

	public AbstractPGLUTCCM01PETransaction(){
	}


	/**
	 * Return value for input parameter CustomerDTO
	 */
	protected CustomerDTO getCustomerdto(){
		return (CustomerDTO)this.getParameter("CustomerDTO");
	}
	protected void setResponse(final String field){this.addParameter("response" , field);}
}
