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
package org.eclipse.keyple.core.plugin;

/**
 * API associated to a {@link
 * org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.WaitForCardRemovalAutonomousSpi}
 *
 * @since 2.2.0
 */
public interface CardRemovalWaiterAsynchronousApi {

  /**
   * Must be invoked when a card is removed.
   *
   * @since 2.2.0
   */
  void onCardRemoved();
}
