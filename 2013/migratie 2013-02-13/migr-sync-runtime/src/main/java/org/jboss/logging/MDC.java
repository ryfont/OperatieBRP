/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

//CHECKSTYLE:OFF - Externe code
/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2010 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.logging;

import java.util.Map;

public final class MDC {

    private MDC() {
    }

    public static Object put(final String key, final Object val) {
        return LoggerProviders.PROVIDER.putMdc(key, val);
    }

    public static Object get(final String key) {
        return LoggerProviders.PROVIDER.getMdc(key);
    }

    public static void remove(final String key) {
        LoggerProviders.PROVIDER.removeMdc(key);
    }

    public static Map<String, Object> getMap() {
        return LoggerProviders.PROVIDER.getMdcMap();
    }
}
