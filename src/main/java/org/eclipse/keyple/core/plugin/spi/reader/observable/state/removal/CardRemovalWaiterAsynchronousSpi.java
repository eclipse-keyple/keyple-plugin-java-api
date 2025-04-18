/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal;

import org.eclipse.keyple.core.plugin.CardRemovalWaiterAsynchronousApi;

/**
 * This SPI is specifically designed for plugins that handle card removal asynchronously.
 *
 * @since 2.2.0
 */
public interface CardRemovalWaiterAsynchronousSpi {

  /**
   * Sets the asynchronous callback that will be called when the card removal is complete.
   *
   * @param callback The asynchronous callback to be called.
   * @since 2.2.0
   */
  void setCallback(CardRemovalWaiterAsynchronousApi callback);
}
