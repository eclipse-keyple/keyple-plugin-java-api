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
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion;

/**
 * This SPI is specifically designed for plugins that don't handle card insertion autonomously but
 * requires an external active stimulation to detect card insertion without implementing a waiting
 * mechanism.
 *
 * <p>When a plugin implements this SPI, the {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#checkCardPresence} method will be called
 * periodically by the service when a card insertion is expected.
 *
 * <p>The value returned by the {@link #getCardInsertionMonitoringSleepDuration()} will be used as
 * an argument to {@link Thread#sleep(long)} between two calls to {@link
 * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#checkCardPresence}.
 *
 * <p>A typical example of readers conforming to this mode of operation are terminals embedding a
 * slave RF communication module.
 *
 * @since 2.2.0
 */
public interface CardInsertionWaiterNonBlockingSpi {

  /**
   * Provides the value of the sleep duration (in milliseconds) inserted between two calls to {@link
   * org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi#checkCardPresence}.
   *
   * @return A positive value (0 is allowed).
   * @since 2.2.0
   */
  int getCardInsertionMonitoringSleepDuration();
}
