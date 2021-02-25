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

import org.eclipse.keyple.core.plugin.AutonomousObservablePluginManager;

/**
 * Interface to be implemented by the provider of a plugin capable of generating reader
 * connection/disconnection events on its own.
 *
 * @since 2.0
 */
public interface AutonomousObservablePluginSpi extends PluginSpi {

  /**
   * Sets the plugin event manager dedicated to autonomous observable readers
   *
   * @param manager A not null reference
   * @since 2.0
   */
  void setManager(AutonomousObservablePluginManager manager);
}
