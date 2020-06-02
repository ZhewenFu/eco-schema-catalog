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
package com.epam.eco.schemacatalog.store.schema.kafka;

import java.util.Objects;

/**
 * @author Andrei_Tytsik
 */
public class SchemaKey extends Key {

    private static final int MAGIC_BYTE = 1;

    private String subject;
    private Integer version;

    public SchemaKey() {
        this(null, null);
    }

    public SchemaKey(String subject, Integer version) {
        super(KeyType.SCHEMA);

        this.subject = subject;
        this.version = version;
        this.magic = MAGIC_BYTE;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Integer getVersion() {
        return version;
    }
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        SchemaKey that = (SchemaKey)obj;
        return
                Objects.equals(this.subject, that.subject) &&
                Objects.equals(this.version, that.version);
    }

    @Override
    public String toString() {
        return
                "{magic: " + magic +
                ", keytype: " + keytype +
                ", subject: " + subject +
                ", version: " + version +
                "}";
    }

}
