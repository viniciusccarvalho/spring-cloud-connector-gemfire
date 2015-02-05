package org.springframework.cloud.gemfire;

import org.junit.Test;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;

import static org.mockito.Mockito.*;
public class GemfireClienCacheConnectorCreatorTest {
	
	
	@Test
	public void testcacheCreation() throws Exception {
		ClientCacheFactory factory = mock(ClientCacheFactory.class);
		ClientCache cache = mock(ClientCache.class);
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "localhost[1234]");
		when(factory.create()).thenReturn(cache);
		GemfireClientCacheConnectorCreator creator = new GemfireClientCacheConnectorCreator(factory);
		ClientCache cretedCache = creator.create(info, null);
		verify(factory, atLeastOnce()).addPoolLocator("localhost", 1234);
		
	}
	
}
