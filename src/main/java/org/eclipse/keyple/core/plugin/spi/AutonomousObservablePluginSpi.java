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
 * Must be implemented by a specific plugin (non pool) with reader observation capabilities.
 *
 * <p>Plugin events are produced by the plugin itself.
 *
 * @since 2.0
 */
public interface AutonomousObservablePluginSpi extends PluginSpi {

  /**
   * Sets the plugin event manager dedicated to autonomous observable plugins
   *
   * @param manager the manager
   * @since 2.0
   */
  void setManager(AutonomousObservablePluginManager manager);
}
