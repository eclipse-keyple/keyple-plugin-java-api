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

import org.eclipse.keyple.core.plugin.AutonomousObservablePluginApi;

/**
 * Plugin (non pool) having autonomous capabilities to observe reader connections and
 * disconnections.
 *
 * <p>Plugin events are produced by the plugin itself.
 *
 * @since 2.0.0
 */
public interface AutonomousObservablePluginSpi extends PluginSpi {

  /**
   * Connects the associated Keyple Core {@link AutonomousObservablePluginApi} API.
   *
   * @param autonomousObservablePluginApi The API to connect.
   * @since 2.0.0
   */
  void connect(AutonomousObservablePluginApi autonomousObservablePluginApi);
}
