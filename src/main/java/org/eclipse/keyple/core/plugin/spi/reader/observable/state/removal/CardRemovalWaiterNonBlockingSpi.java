/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal;

/**
 * This SPI is specifically designed for plugins that don't handle card removal autonomously but
 * requires the sending of an APDU to detect the card removal.
 *
 * <p>When a plugin implements this SPI, the {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#transmitApdu(byte[])} method will be called
 * periodically by the service when a card removal is expected. The card is considered removed when
 * the transmission fails.
 *
 * <p>The value returned by the {@link #getCardInsertionMonitoringSleepDuration()} will be used as
 * an argument to {@link Thread#sleep(long)} between two calls to {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#transmitApdu}.
 *
 * <p>A typical example of readers conforming to this mode of operation are terminals embedding a
 * slave RF communication module without card presence feature.
 *
 * @since 2.2.0
 */
public interface CardRemovalWaiterNonBlockingSpi {

  /**
   * Provides the value of the sleep duration (in milliseconds) inserted between two calls to {@link
   * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#transmitApdu}.
   *
   * @return A positive value (0 is allowed).
   * @since 2.2.0
   */
  int getCardInsertionMonitoringSleepDuration();
}
