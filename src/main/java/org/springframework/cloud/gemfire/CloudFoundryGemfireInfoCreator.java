package org.springframework.cloud.gemfire;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class CloudFoundryGemfireInfoCreator extends CloudFoundryServiceInfoCreator<GemfireLocatorServiceInfo> {

	public CloudFoundryGemfireInfoCreator(){
		super(new Tags("gemfire"));
	}
	
	public CloudFoundryGemfireInfoCreator(Tags tags) {
		super(tags);
	}

	@Override
	public GemfireLocatorServiceInfo createServiceInfo(Map<String, Object> serviceData) {
		String id = (String) serviceData.get("name");
		Map<String,Object> credentials = (Map<String, Object>) serviceData.get("credentials");
		List<String>locators = (List<String>) credentials.get("locators");
		return new GemfireLocatorServiceInfo(id, locators.toArray(new String[]{}));
	}

}
