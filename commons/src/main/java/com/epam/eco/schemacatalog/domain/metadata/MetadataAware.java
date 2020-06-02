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
package com.epam.eco.schemacatalog.domain.metadata;

import java.util.HashMap;
import java.util.Map;

import com.epam.eco.schemacatalog.domain.metadata.format.PartFormatter;
import com.epam.eco.schemacatalog.domain.schema.SchemaInfo;
import com.epam.eco.schemacatalog.domain.schema.Schemafull;

/**
 * @author Andrei_Tytsik
 */
public interface MetadataAware<T extends SchemaInfo & Schemafull & MetadataAware<T>> {
    Map<MetadataKey, MetadataValue> getMetadata();
    MetadataBrowser<T> getMetadataBrowser();
    T toSchemaWithFormattedMetadata(PartFormatter partFormatter);

    default Map<MetadataKey, MetadataValue> formatMetadata(PartFormatter partFormatter){
        Map<MetadataKey, MetadataValue> formattedMetadata = new HashMap<>();
        getMetadata().keySet()
                .forEach(key ->formattedMetadata.put(key, getMetadata().get(key).format(partFormatter)));
        return formattedMetadata;
    }
}
