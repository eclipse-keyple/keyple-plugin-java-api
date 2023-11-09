/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
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

import org.eclipse.keyple.core.plugin.CardInsertionWaiterAsynchronousApi;
import org.eclipse.keyple.core.plugin.WaitForCardInsertionAutonomousReaderApi;

/**
 * This SPI is specifically designed for plugins that handle card insertion asynchronously.
 *
 * <p>A typical example of readers conforming to this mode of operation are Android-based NFC
 * readers.
 *
 * @since 2.2.0
 */
public interface CardInsertionWaiterAsynchronousSpi {

  /**
   * Connects the associated Keyple Core {@link WaitForCardInsertionAutonomousReaderApi} API.
   *
   * @param callback API of the callback to call when a card is inserted.
   * @since 2.2.0
   */
  void setCallback(CardInsertionWaiterAsynchronousApi callback);
}
