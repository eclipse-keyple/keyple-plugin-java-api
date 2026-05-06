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

/**
 * This SPI is specifically designed for plugins that don't handle card removal autonomously.
 *
 * <p>When a plugin implements this SPI, the {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#isCardPresent()} method will be called
 * periodically by the service when a card removal is expected. The card is considered removed when
 * {@code isCardPresent()} returns {@code false}.
 *
 * <p>The value returned by {@link #getCardRemovalMonitoringSleepDuration()} will be used as an
 * argument to {@link Thread#sleep(long)} between two calls to {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#isCardPresent()}.
 *
 * <p>A typical example of readers conforming to this mode of operation are terminals embedding a
 * slave RF communication module without autonomous card presence detection.
 *
 * @since 2.2.0
 */
public interface CardRemovalWaiterNonBlockingSpi {

  /**
   * Provides the value of the sleep duration (in milliseconds) inserted between two calls to {@link
   * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#isCardPresent()}.
   *
   * @return A positive value (0 is allowed).
   * @since 2.2.0
   */
  int getCardRemovalMonitoringSleepDuration();
}
