package org.springframework.cloud.gemfire;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CloudFoundryGemfireInfoCreatorTest {
	
	
	private ObjectMapper mapper = new ObjectMapper();
	private Map<String, Object> serviceData;
	
	@Before
	public void loadServiceData() throws Exception{
		Map services = mapper.readValue(CloudFoundryGemfireInfoCreatorTest.class.getClassLoader().getSystemResourceAsStream("service.json"), Map.class);
		serviceData = (Map<String, Object>) ((List)services.get("p-gemfire")).get(0);
	}
	
	@Test
	public void testInfoCreator(){
		CloudFoundryGemfireInfoCreator creator = new CloudFoundryGemfireInfoCreator();
		GemfireLocatorServiceInfo info = creator.createServiceInfo(serviceData);
		Assert.assertNotNull(info);
	}
	
}
