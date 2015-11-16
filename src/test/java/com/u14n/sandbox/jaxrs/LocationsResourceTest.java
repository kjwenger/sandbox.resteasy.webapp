package com.u14n.sandbox.jaxrs;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.mock.*;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;

public class LocationsResourceTest {

	private static Dispatcher dispatcher;
	private static POJOResourceFactory noDefaults;

	@BeforeClass
	public static void SetUp() throws Exception {
		dispatcher = MockDispatcherFactory.createDispatcher();
		noDefaults = new POJOResourceFactory(LocationsResource.class);
		dispatcher.getRegistry().addResourceFactory(noDefaults);
	}

	@AfterClass
	public static void TearDown() throws Exception {
	}

	@Test
	public void testLocations() throws URISyntaxException {
		MockHttpRequest request = MockHttpRequest.get("/locations");
		MockHttpResponse response = new MockHttpResponse();

		dispatcher.invoke(request, response);

		assertEquals(HttpServletResponse.SC_OK, response.getStatus());
//		assertEquals("basic", response.getContentAsString());
	}

}
