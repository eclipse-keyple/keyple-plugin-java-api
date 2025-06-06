/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi;

import java.util.Set;
import org.eclipse.keyple.core.plugin.PluginIOException;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Plugin (non pool) able to manage a static list of readers.
 *
 * @since 2.0.0
 */
public interface PluginSpi {

  /**
   * Gets the name of the plugin.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getName();

  /**
   * Enumerates currently available readers.
   *
   * @return A empty Set if no reader is available.
   * @throws PluginIOException If an error occurs while searching readers.
   * @since 2.0.0
   */
  Set<ReaderSpi> searchAvailableReaders() throws PluginIOException;

  /**
   * Invoked when unregistering the plugin.
   *
   * @since 2.0.0
   */
  void onUnregister();
}
