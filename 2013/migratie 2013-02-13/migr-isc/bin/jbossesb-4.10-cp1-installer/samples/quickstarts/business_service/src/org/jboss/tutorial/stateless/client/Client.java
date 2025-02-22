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
package org.jboss.tutorial.stateless.client;

import org.jboss.tutorial.stateless.bean.HelloWorld;
import org.jboss.tutorial.stateless.bean.HelloWorldBean;

import javax.naming.InitialContext;

public class Client
{
   public static void main(String[] args) throws Exception
   {
      // Store a reference to the calculator interface
      HelloWorld hw = null;

      // Decide whether to use a POJO or connect to an EJB
      if (args.length != 1)
      {
        System.err.println("Usage: java org.jboss.tutorial.client.Client [-pojo|-ejb]");
        System.exit(1);
      }
      else if (args[0].equals("-pojo"))
      {
        // Simply create a new POJO to act as the HelloWorld
        System.out.println("Creating a new HelloWorldBean POJO");
        hw = new HelloWorldBean();
      }
      else if (args[0].equals("-ejb"))
      {
        // Obtain an initial context
        InitialContext ctx = new InitialContext();
        
        // Look up a remote interface to a calculator EJB
        System.out.println("Obtaining a reference to a remote HelloWorldBean EJB");
        hw = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
      }
      else
      {
        System.err.println("Usage: java org.jboss.tutorial.client.Client [-pojo|-ejb]");
        System.exit(1);        
      }

      if (hw != null)
      {
        System.out.println("[Client] " + hw.sayHello("JBoss"));        
      }
   }
}
