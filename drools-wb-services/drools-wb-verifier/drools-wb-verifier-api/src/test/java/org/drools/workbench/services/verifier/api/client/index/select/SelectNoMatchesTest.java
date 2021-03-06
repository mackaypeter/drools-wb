/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.services.verifier.api.client.index.select;

import java.util.Collection;

import org.drools.workbench.services.verifier.api.client.maps.KeyDefinition;
import org.drools.workbench.services.verifier.api.client.maps.KeyTreeMap;
import org.drools.workbench.services.verifier.api.client.index.keys.Key;
import org.drools.workbench.services.verifier.api.client.index.keys.UUIDKey;
import org.drools.workbench.services.verifier.api.client.AnalyzerConfigurationMock;
import org.drools.workbench.services.verifier.api.client.maps.util.HasKeys;
import org.drools.workbench.services.verifier.api.client.index.matchers.ExactMatcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectNoMatchesTest {

    private Select<Address> select;

    @Before
    public void setUp() throws Exception {
        final KeyDefinition keyDefinition = KeyDefinition.newKeyDefinition().withId( "name" ).build();
        final KeyTreeMap<Address> map = new KeyTreeMap<>( keyDefinition);
        final Address object = new Address();
        map.put( object );

        select = new Select<>( map.get( UUIDKey.UNIQUE_UUID ),
                               new ExactMatcher( keyDefinition,
                                                 "Toni" ) );
    }

    @Test
    public void testAll() throws Exception {
        final Collection<Address> all = select.all();

        assertTrue( all.isEmpty() );
    }

    @Test
    public void testFirst() throws Exception {
        assertNull( select.first() );
    }

    @Test
    public void testLast() throws Exception {
        assertNull( select.last() );
    }

    private class Address
            implements HasKeys {

        private UUIDKey uuidKey = new AnalyzerConfigurationMock().getUUID( this );

        @Override
        public Key[] keys() {
            return new Key[]{
                    uuidKey
            };
        }

        @Override
        public UUIDKey getUuidKey() {
            return uuidKey;
        }
    }
}