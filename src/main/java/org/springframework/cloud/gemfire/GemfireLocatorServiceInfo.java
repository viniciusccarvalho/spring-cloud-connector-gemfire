package org.springframework.cloud.gemfire;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("gemfire")
public class GemfireLocatorServiceInfo extends BaseServiceInfo {
	
	final Pattern p = Pattern.compile("(.*)\\[(\\d*)\\]");
	private URI[] locators;
	
	public GemfireLocatorServiceInfo(String id, String... addresses ) {
		super(id);
		this.locators = new URI[addresses.length];
		for(int i=0;i<addresses.length;i++){
			locators[i] = parseLocators(addresses[i]);
		}
	}
	
	URI parseLocators(String locator) throws IllegalArgumentException {
		Matcher m = p.matcher(locator);
		URI uri = null;
		if(!m.find()){
			throw new IllegalArgumentException("Could not parse locator url. Expected format host[port], received: " + locator);
		}else{
			if(m.groupCount() != 2){
				throw new IllegalArgumentException("Could not parse locator url. Expected format host[port], received: " + locator);
			}
			try {
				uri = new URI("locator://"+m.group(1)+":"+m.group(2));
			} catch (URISyntaxException e) {
				throw new IllegalArgumentException("Malformed URL " +locator);
			}
		}
		return uri;
	}


	public URI[] getLocators() {
		return locators;
	}
	

}
