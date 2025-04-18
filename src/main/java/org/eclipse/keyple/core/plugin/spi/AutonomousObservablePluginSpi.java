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
   * @deprecated Use {@link #setCallback(AutonomousObservablePluginApi)} instead.
   */
  @Deprecated
  void connect(AutonomousObservablePluginApi autonomousObservablePluginApi);

  /**
   * Sets the asynchronous callback that will be called when a reader is connected or disconnected.
   *
   * @param callback The asynchronous callback to be called.
   * @since 2.2.0
   */
  void setCallback(AutonomousObservablePluginApi callback);
}
