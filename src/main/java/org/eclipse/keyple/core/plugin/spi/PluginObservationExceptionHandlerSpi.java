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
 * Handler to be notified of runtime exceptions that may occur during operations carried out by the
 * monitoring processes.
 *
 * <p>These exceptions can be thrown either in the internal monitoring layers of the readers or in
 * the application itself (within the onPluginEvent methods when notifying plugin observers for
 * example).
 *
 * @since 2.0
 */
public interface PluginObservationExceptionHandlerSpi {

  /**
   * Called when a runtime exception occurs in the observed plugin.
   *
   * <p>The plugin name and the original exception are provided.
   *
   * @param pluginName A not empty String
   * @param e A not null reference
   * @since 2.0
   */
  void onPluginObservationError(String pluginName, Throwable e);
}
