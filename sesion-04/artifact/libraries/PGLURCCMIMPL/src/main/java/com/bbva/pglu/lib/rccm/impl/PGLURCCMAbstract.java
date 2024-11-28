package com.bbva.pglu.lib.rccm.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.pglu.lib.rccm.PGLURCCM;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class PGLURCCMAbstract extends AbstractLibrary implements PGLURCCM {

	protected ApplicationConfigurationService applicationConfigurationService;

	protected APIConnector internalApiConnector;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

	/**
	* @param internalApiConnector the this.internalApiConnector to set
	*/
	public void setInternalApiConnector(APIConnector internalApiConnector) {
		this.internalApiConnector = internalApiConnector;
	}

}