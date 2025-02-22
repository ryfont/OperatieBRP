/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.test.ws.jaxws.samples.wssecurity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class KeystorePasswordCallback implements CallbackHandler
{

   private Map<String, String> passwords = new HashMap<String, String>();

   public KeystorePasswordCallback()
   {
      passwords.put("alice", "password");
      passwords.put("bob", "password");
   }

   /**
    * It attempts to get the password from the private 
    * alias/passwords map.
    */
   public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
   {
      for (int i = 0; i < callbacks.length; i++)
      {
         WSPasswordCallback pc = (WSPasswordCallback)callbacks[i];

         String pass = passwords.get(pc.getIdentifer());
         if (pass != null)
         {
            pc.setPassword(pass);
            return;
         }
      }
   }

   /**
    * Add an alias/password pair to the callback mechanism.
    */
   public void setAliasPassword(String alias, String password)
   {
      passwords.put(alias, password);
   }
}
