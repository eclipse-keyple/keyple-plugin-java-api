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

import org.eclipse.keyple.core.plugin.CardInsertionWaiterAsynchronousApi;

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
   * Sets the asynchronous callback that will be called when a card is inserted.
   *
   * @param callback The asynchronous callback to be called.
   * @since 2.2.0
   */
  void setCallback(CardInsertionWaiterAsynchronousApi callback);
}
