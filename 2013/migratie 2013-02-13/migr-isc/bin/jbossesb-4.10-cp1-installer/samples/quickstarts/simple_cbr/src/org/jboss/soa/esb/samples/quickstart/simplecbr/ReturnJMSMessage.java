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
 * (C) 2005-2006,
 * @author JBoss Inc.
 */
package org.jboss.soa.esb.samples.quickstart.simplecbr;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSException;
import javax.jms.QueueConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.jboss.soa.esb.message.Message;

public class ReturnJMSMessage {
       
    public static void sendMessage(Message esbMessage,String newDestination) throws JMSException, NamingException, Exception {
    	if (esbMessage == null || newDestination == null) 
    		throw new Exception("Message and JMS Destination are required");
    
    	QueueConnection conn;
        QueueSession session;
        Queue que;
        
    	InitialContext iniCtx = new InitialContext();
    	Object tmp = iniCtx.lookup("ConnectionFactory");
    	QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
    	conn = qcf.createQueueConnection();
    	que = (Queue) iniCtx.lookup("queue/" + newDestination);
    	session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
    	conn.start();

    	    	   
    	String newMsg = (String) esbMessage.getBody().get();

    	
    	QueueSender send = session.createSender(que);        
        TextMessage tm = session.createTextMessage(newMsg);
        send.send(tm);
        

        session.close();
    	conn.stop();
    	conn.close();
    }    
    
}