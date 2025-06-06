/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion;

import org.eclipse.keyple.core.plugin.WaitForCardInsertionAutonomousReaderApi;

/**
 * Reader that have a fully integrated management of card communications for card insertion
 * detection.
 *
 * <p>A typical example of readers conforming to this mode of operation are Android-based NFC
 * readers.
 *
 * @since 2.0.0
 * @deprecated Implement {@link CardInsertionWaiterAsynchronousSpi} instead (will be removed in a
 *     future version of this API).
 */
@Deprecated
public interface WaitForCardInsertionAutonomousSpi {

  /**
   * Connects the associated Keyple Core {@link WaitForCardInsertionAutonomousReaderApi} API.
   *
   * @param waitForCardInsertionAutonomousReaderApi The API to connect.
   * @since 2.0.0
   * @deprecated
   */
  @Deprecated
  void connect(WaitForCardInsertionAutonomousReaderApi waitForCardInsertionAutonomousReaderApi);
}
