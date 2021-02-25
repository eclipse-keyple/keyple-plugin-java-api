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
package org.eclipse.keyple.core.plugin.spi.reader;

import org.eclipse.keyple.core.plugin.CardIOException;
import org.eclipse.keyple.core.plugin.ReaderIOException;

/**
 * Must be implemented by a specific reader that selects the cards itself (e.g. OMAPI readers).
 *
 * @since 2.0
 */
public interface AutonomousSelectionReaderSpi {

  /**
   * Opens a logical channel for the provided AID
   *
   * <p>The <b>dfName</b> is provided as a byte array. It can be set to null to activate the basic
   * channel opening defined by the OMAPI. <br>
   * The bit mask indicates the ISO defined condition to retrieve the selection data.
   *
   * @param dfName A byte array or null TODO Shouldn't we rename this "AID"?
   * @param isoControlMask bit mask from the ISO 7816-4 standard
   * @return A byte array containing the card answer to selection
   * @throws IllegalArgumentException if the dfName is null or empty
   * @throws ReaderIOException if the communication with the reader has failed
   * @throws CardIOException if the communication with the card has failed
   */
  byte[] openChannelForAid(byte[] dfName, byte isoControlMask)
      throws ReaderIOException, CardIOException;

  void closeLogicalChannel();
}
