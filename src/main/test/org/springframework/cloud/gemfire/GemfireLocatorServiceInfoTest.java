package org.springframework.cloud.gemfire;

import org.junit.Assert;
import org.junit.Test;

public class GemfireLocatorServiceInfoTest {

	@Test
	public void testValidLocatorIP(){
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "10.0.0.1[1044]");
		Assert.assertEquals(1, info.getLocators().length);
		Assert.assertEquals("10.0.0.1", info.getLocators()[0].getHost());
		Assert.assertEquals(1044, info.getLocators()[0].getPort());
	}
	
	@Test
	public void testValidLocatorHost(){
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "localhost[1044]");
		Assert.assertEquals(1, info.getLocators().length);
		Assert.assertEquals("localhost", info.getLocators()[0].getHost());
		Assert.assertEquals(1044, info.getLocators()[0].getPort());
	}
	
	@Test
	public void testValidLocators(){
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "localhost[1044]","10.0.0.1[1044]");
		Assert.assertEquals(2, info.getLocators().length);
		Assert.assertEquals("localhost", info.getLocators()[0].getHost());
		Assert.assertEquals(1044, info.getLocators()[0].getPort());
		Assert.assertEquals("10.0.0.1", info.getLocators()[1].getHost());
		Assert.assertEquals(1044, info.getLocators()[1].getPort());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidLocators(){
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "localhost[1044],10.0.0.1[1044]");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidFormat(){
		GemfireLocatorServiceInfo info = new GemfireLocatorServiceInfo("gemfire", "localhost:1044");
	}
}
