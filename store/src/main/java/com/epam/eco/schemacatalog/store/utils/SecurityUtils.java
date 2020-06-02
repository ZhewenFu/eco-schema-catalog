/*
 * Copyright 2020 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.epam.eco.schemacatalog.store.utils;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Andrei_Tytsik
 */
public abstract class SecurityUtils {

    private SecurityUtils() {
    }

    public static Principal getPrincipal() {
        Principal principal = getPrincipalFromSecurityContext();
        if (principal == null) {
            throw new RuntimeException("No principal associated with the current thread!");
        }

        return principal;
    }

    private static Principal getPrincipalFromSecurityContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context != null ? context.getAuthentication() : null;
    }

}
