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
 * Interface to be implemented by a provider of an observable plugin managed by Keyple Service.
 *
 * <p>The production of plugin events (connection/disconnection of readers) is handled by an
 * execution thread managed by Keyple Service.
 *
 * @since 2.0
 */
public interface ObservablePluginSpi extends PluginSpi {

  /**
   * Gets the specified time cycle in milliseconds for checking the list of current readers.
   *
   * @return An int
   * @since 2.0
   */
  int getMonitoringCycleDuration();

  /**
   * Enumerates currently available readers and returns their names as a collection of String.
   *
   * @return A not null Set
   * @since 2.0
   */
  Set<String> searchAvailableReadersNames();

  /**
   * Searches for the reader whose name is provided and returns its {@link ReaderSpi} if found,
   * raises an exception if not.
   *
   * @param readerName A not empty String
   * @return A not null reference
   * @since 2.0
   */
  ReaderSpi searchReader(String readerName);

  /**
   * Gets the exception handler to be used for notifying execution failures during plugin
   * monitoring.
   *
   * @return A not null reference.
   * @since 2.0
   */
  PluginObservationExceptionHandlerSpi getPluginObservationExceptionHandler();
}
