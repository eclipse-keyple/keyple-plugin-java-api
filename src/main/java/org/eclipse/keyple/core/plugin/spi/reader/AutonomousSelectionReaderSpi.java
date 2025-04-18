/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader;

import org.eclipse.keyple.core.plugin.CardIOException;
import org.eclipse.keyple.core.plugin.ReaderIOException;

/**
 * Reader having an autonomous mechanism to select the cards (for example OMAPI readers).
 *
 * @since 2.0.0
 */
public interface AutonomousSelectionReaderSpi extends ReaderSpi {

  /**
   * Opens a logical channel for the provided AID
   *
   * <p>The <b>aid</b> is provided as a byte array. It can be set to null to activate the basic
   * channel opening defined by the OMAPI.<br>
   * The bit mask indicates the ISO defined condition to retrieve the selection data.
   *
   * @param aid The AID (optional)
   * @param isoControlMask The bit mask from the ISO 7816-4 standard
   * @return A not empty byte array containing the card answer to selection
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws CardIOException If the communication with the card has failed.
   * @since 2.0.0
   */
  byte[] openChannelForAid(byte[] aid, byte isoControlMask)
      throws ReaderIOException, CardIOException;

  /**
   * Closes the logical channel explicitly.
   *
   * @since 2.0.0
   */
  void closeLogicalChannel();
}
