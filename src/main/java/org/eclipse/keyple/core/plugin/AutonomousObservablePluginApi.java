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
package org.eclipse.keyple.core.plugin;

import java.util.Set;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * API associated to a {@link org.eclipse.keyple.core.plugin.spi.AutonomousObservablePluginSpi}
 *
 * @since 2.0.0
 */
public interface AutonomousObservablePluginApi {

  /**
   * Must be invoked when one or more readers are connected to the system.
   *
   * @param readers the readers connected
   * @throws IllegalArgumentException If the Set provided as argument is null or empty
   * @since 2.0.0
   */
  void onReaderConnected(Set<ReaderSpi> readers);

  /**
   * Must be invoked when one or more readers are disconnected from the system.
   *
   * @param readerNames the readers names disconnected
   * @throws IllegalArgumentException If the Set provided as argument is null or empty
   * @since 2.0.0
   */
  void onReaderDisconnected(Set<String> readerNames);
}
