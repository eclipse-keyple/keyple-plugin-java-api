/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://www.calypsonet-asso.org/
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

import org.eclipse.keyple.core.plugin.WaitForCardRemovalAutonomousReaderApi;

/**
 * Reader that have a fully integrated management of card communications for card removal detection.
 *
 * <p>A typical example of readers conforming to this mode of operation are Android-based NFC
 * readers.
 *
 * @since 2.0
 */
public interface WaitForCardRemovalAutonomousSpi {

  /**
   * Connects the associated Keyple Core {@link WaitForCardRemovalAutonomousReaderApi} API.
   *
   * @param waitForCardRemovalAutonomousReaderApi The API to connect.
   * @since 2.0
   */
  void connect(WaitForCardRemovalAutonomousReaderApi waitForCardRemovalAutonomousReaderApi);
}
