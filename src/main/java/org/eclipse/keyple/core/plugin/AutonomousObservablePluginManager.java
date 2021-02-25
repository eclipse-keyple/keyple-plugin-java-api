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

import java.util.Set;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Interfaces to be implemented by the Keyple Service adapter
 *
 * @since 2.0
 */
public interface AutonomousObservablePluginManager {

  /**
   * This method is called when one or more readers are connected to the system.
   *
   * <p>Newly connected readers are provided as a collection of {@link ReaderSpi}.
   *
   * @param readers A not empty Set
   * @since 2.0
   */
  void onReaderConnected(Set<ReaderSpi> readers);

  /**
   * This method is called when one or more readers are disconnected from the system.
   *
   * <p>Newly disconnected readers names are provided as a collection of String.
   *
   * @param readersNames A not empty Set
   * @since 2.0
   */
  void onReaderDisconnected(Set<String> readersNames);
}
