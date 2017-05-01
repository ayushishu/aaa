/*
 * Copyright (c) 2016 Red Hat, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.aaa.h2.config.tests;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.opendaylight.aaa.h2.config.IdmLightConfig;
import org.opendaylight.aaa.h2.config.IdmLightConfigBuilder;

/**
 * Unit test for IdmLightConfig.
 *
 * @author Michael Vorburger
 */
public class IdmLightConfigTest {

    @Test
    public void testDefaults() {
        IdmLightConfig config = new IdmLightConfigBuilder().build();
        assertThat(config.getDbDriver()).isEqualTo("org.h2.Driver");
        assertThat(config.getDbConnectionString()).isEqualTo("jdbc:h2:./data/idmlight.db");
        assertThat(config.getDbUser()).isEqualTo("foo");
        assertThat(config.getDbPwd()).isEqualTo("bar");
        assertThat(config.getDbValidTimeOut()).isEqualTo(3);
    }

    @Test
    public void testCustomDirectory() {
        IdmLightConfigBuilder builder = new IdmLightConfigBuilder();
        builder.dbDirectory("target");
        IdmLightConfig config = builder.build();
        assertThat(config.getDbConnectionString()).isEqualTo("jdbc:h2:target/idmlight.db");
    }

    @Test
    public void testCustomConnectionString() {
        IdmLightConfigBuilder builder = new IdmLightConfigBuilder();
        builder.dbConnectionString("jdbc:mysql://localhost/test");
        IdmLightConfig config = builder.build();
        assertThat(config.getDbConnectionString()).isEqualTo("jdbc:mysql://localhost/test");
    }

}
