/*
 * JBoss, Home of Professional Open Source
 * Copyright 2006, JBoss Inc., and others contributors as indicated 
 * by the @authors tag. All rights reserved. 
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors. 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 * 
 * (C) 2005-2009
 */
package org.jboss.soa.esb.samples.quickstart.webservice_proxy_routed.test;

import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jboss.internal.soa.esb.util.StreamUtils;

/**
 * Sends a simple webservice request to the proxied webservice, printing both the request and the response to the console.
 * 
 * @author dward at jboss.org
 */
public class SendWSMessage
{
	
	private static final String HELLO_SOAP_PRE =
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hello=\"http://webservice_proxy_routed/hello\">" +
			"<soapenv:Header/>" +
			"<soapenv:Body>" +
				"<hello:sayHello>" +
					"<toWhom>";
	
	private static final String HELLO_SOAP_POST =
					"</toWhom>" +
				"</hello:sayHello>" +
			"</soapenv:Body>" +
		"</soapenv:Envelope>";
	
	private static final String GOODBYE_SOAP_PRE =
		"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:goodbye=\"http://webservice_proxy_routed/goodbye\">" +
			"<soapenv:Header/>" +
			"<soapenv:Body>" +
				"<goodbye:sayGoodbye>" +
					"<toWhom>";
	
	private static final String GOODBYE_SOAP_POST =
					"</toWhom>" +
				"</goodbye:sayGoodbye>" +
			"</soapenv:Body>" +
		"</soapenv:Envelope>";
	
	// see product/samples/quickstarts/webservice_proxy_routed/build.xml
	public static void main(String... args) throws Exception
	{
		if (args.length < 3)
		{
			// for testing main method from Eclipse (build.xml passes these args in)
			args = new String[3];
			args[0] = "http://localhost:8080/Quickstart_webservice_proxy_routed/http/Proxy_Routed/Proxy_CBR"; // proxy via http gateway ("ant runhello" or "ant rungoodbye")
			args[1] = System.getProperty("user.name");
			args[2] = "hello";
		}
		
		String url = args[0];
		System.out.println("****  REQUEST  URL: " + url);
		PostMethod method = new PostMethod(url);
		method.setRequestHeader("Content-Type", "text/xml;charset=UTF-8");
		
		// this line should be used for better performance/interop but is not necessary
		// http://www.w3.org/TR/2000/NOTE-SOAP-20000508/#_Toc478383528
		// http://www.ws-i.org/Profiles/BasicProfile-1.1.html#SOAPAction_HTTP_Header
		method.setRequestHeader("SOAPAction", "\"\"");
		
		boolean hello = "hello".equals(args[2]);
		String request = (hello ? HELLO_SOAP_PRE : GOODBYE_SOAP_PRE) + args[1] + (hello ? HELLO_SOAP_POST : GOODBYE_SOAP_POST);
		System.out.println("****  REQUEST BODY: " + request);
		method.setRequestEntity( new StringRequestEntity(request) );
		
		HttpClient client = new HttpClient();
		InputStream response = null;
		try
		{
			int code = client.executeMethod(method);
			System.out.println("**** RESPONSE CODE: " + code);
			
			response = method.getResponseBodyAsStream();
			byte[] bytes = StreamUtils.readStream(response);
			System.out.println("**** RESPONSE BODY: " + new String(bytes, method.getResponseCharSet()));
		}
		finally
		{
			method.releaseConnection();
			if (response != null)
			{
				response.close();
			}
		}
	}

}
