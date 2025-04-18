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

/**
 * Factory of {@link PoolPluginSpi}
 *
 * @since 2.0.0
 */
public interface PoolPluginFactorySpi {

  /**
   * Gets the plugin's API version used at compile time
   *
   * @return A not empty String
   * @since 2.0.0
   */
  String getPluginApiVersion();

  /**
   * Gets the common's API version used at compile time
   *
   * @return A not empty String
   * @since 2.0.0
   */
  String getCommonApiVersion();

  /**
   * Retrieves the name of the pool plugin that will be instantiated by this factory (can be static
   * or dynamic)
   *
   * @return A not empty String
   * @since 2.0.0
   */
  String getPoolPluginName();

  /**
   * Retrieves an instance of a pool plugin SPI (can be a singleton or not)
   *
   * @return A not null reference
   * @since 2.0.0
   */
  PoolPluginSpi getPoolPlugin();
}
