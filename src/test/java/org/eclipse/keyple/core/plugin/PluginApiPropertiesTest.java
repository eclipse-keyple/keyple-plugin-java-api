/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://www.calypsonet-asso.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;

public class PluginApiPropertiesTest {

  private static final Properties properties = new Properties();

  @Test
  public void versionIsCorrectlyWritten() throws Exception {
    InputStream inputStream = new FileInputStream("gradle.properties");
    try {
      properties.load(inputStream);
    } finally {
      inputStream.close();
    }
    String libVersion = properties.getProperty("version");
    assertThat(libVersion).matches("\\d+\\.\\d+").isEqualTo(PluginApiProperties.VERSION);
  }
}
