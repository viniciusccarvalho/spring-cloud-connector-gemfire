package org.springframework.cloud.gemfire;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
		Map<String,Object> credentials = new HashMap<>();
		credentials.put("locators", Collections.singletonList("localhost[1234]"));
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", credentials);
		when(factory.create()).thenReturn(cache);
		GemfireClientCacheConnectorCreator creator = new GemfireClientCacheConnectorCreator(factory);
		ClientCache cretedCache = creator.create(info, null);
		verify(factory, atLeastOnce()).addPoolLocator("localhost", 1234);
		
	}
	
}
