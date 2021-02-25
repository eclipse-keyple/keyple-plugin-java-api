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

/**
 * Must be implemented by a specific plugin (non pool)
 *
 * @since 2.0
 */
public interface PluginFactorySpi {

  /**
   * Gets the plugin's API version used at compile time
   *
   * @return A not empty String
   * @since 2.0
   */
  String getPluginApiVersion();

  /**
   * Gets the commons's API version used at compile time
   *
   * @return A not empty String
   * @since 2.0
   */
  String getCommonsApiVersion();

  /**
   * Retrieve the name of the plugin that will be instantiated by this factory (can be static or
   * dynamic)
   *
   * @return A not empty String
   * @since 2.0
   */
  String getPluginName();

  /**
   * Retrieve an instance of a plugin SPI (can be a singleton or not)
   *
   * @return A not null reference
   * @since 2.0
   */
  PluginSpi getPlugin();
}
