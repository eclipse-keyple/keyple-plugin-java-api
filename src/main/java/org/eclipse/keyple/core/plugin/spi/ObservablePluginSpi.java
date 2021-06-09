/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
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
import org.eclipse.keyple.core.plugin.PluginIOException;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Plugin (non pool) able to manage a dynamic list of readers and provide the content on request
 * (for example PC/SC).
 *
 * <p>The production of plugin events (connection/disconnection of readers) is handled by the Keyple
 * Core adapter.
 *
 * @since 2.0
 */
public interface ObservablePluginSpi extends PluginSpi {

  /**
   * Gets the recommended time cycle in milliseconds to check the list of current readers.
   *
   * @return A positive int
   * @since 2.0
   */
  int getMonitoringCycleDuration();

  /**
   * Enumerates currently available readers and returns their names as a collection of String.
   *
   * @return An empty Set if no reader is available
   * @throws PluginIOException If an error occurs while searching readers.
   * @since 2.0
   */
  Set<String> searchAvailableReaderNames() throws PluginIOException;

  /**
   * Searches for the reader whose name is provided and returns its {@link ReaderSpi} if found, null
   * if not.
   *
   * @param readerName The name of reader
   * @return Null if the reader is not found
   * @throws PluginIOException If an error occurs while searching the reader.
   * @since 2.0
   */
  ReaderSpi searchReader(String readerName) throws PluginIOException;
}
