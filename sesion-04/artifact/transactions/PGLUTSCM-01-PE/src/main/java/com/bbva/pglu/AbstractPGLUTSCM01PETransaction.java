package com.bbva.pglu;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.pglu.dto.elastic.customer.CustomerDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractPGLUTSCM01PETransaction extends AbstractTransaction {

	public AbstractPGLUTSCM01PETransaction(){
	}

	protected CustomerDTO getCustomerdto(){
		return (CustomerDTO)this.getParameter("CustomerDTO");
	}
	protected void setClienteDTO(final CustomerDTO field){this.addParameter("CustomerDTO" , field);}
	protected String getClienteId(){return (String)this.getParameter("clienteId");}

}
