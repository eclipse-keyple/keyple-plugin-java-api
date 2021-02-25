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
package org.eclipse.keyple.core.plugin.spi;

import java.util.Set;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Must be implemented by a specific plugin
 *
 * @since 2.0
 */
public interface PluginSpi {

  /**
   * Gets the name of the plugin.
   *
   * @return A not empty string.
   * @since 2.0
   */
  String getName();

  /**
   * Enumerates currently available readers and returns them as a collection of {@link ReaderSpi}.
   *
   * @return A not null Set
   * @since 2.0
   */
  Set<ReaderSpi> searchAvailableReaders();
}
