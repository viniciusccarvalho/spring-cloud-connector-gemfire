package org.springframework.cloud.gemfire;

import java.net.URI;

import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

public class GemfireClientCacheConnectorCreator extends AbstractServiceConnectorCreator<ClientCache, GemfireLocatorServiceInfo> {
	
	final ClientCacheFactory factory;
	
	public GemfireClientCacheConnectorCreator(ClientCacheFactory factory) {
		this.factory = factory;
	}

	public GemfireClientCacheConnectorCreator() {
		this.factory  = new ClientCacheFactory();
	}
	
	@Override
	public ClientCache create(GemfireLocatorServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
		
		for(URI locator: serviceInfo.getLocators()){
			factory.addPoolLocator(locator.getHost(), locator.getPort());
		}
		return factory.create();
	}

}
