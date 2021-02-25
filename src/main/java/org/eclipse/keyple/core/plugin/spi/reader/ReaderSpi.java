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
 * Must be implemented by a specific reader (pool and non pool plugins).
 *
 * @since 2.0
 */
public interface ReaderSpi {

  /**
   * Gets the name of the reader.
   *
   * @return A not empty string.
   * @since 2.0
   */
  String getName();

  /**
   * Indicates if the provided reader protocol is supported by the reader.
   *
   * @param readerProtocol A not empty String
   * @return true if the protocol is supported, false if not
   * @throws IllegalArgumentException if the argument is not correct
   * @since 2.0
   */
  boolean isProtocolSupported(String readerProtocol);

  /**
   * Activates the protocol provided from the reader's implementation point of view.
   *
   * <p>The argument is a reader specific String identifying the protocol.
   *
   * @param readerProtocol A not empty String.
   * @throws IllegalArgumentException if the argument is not correct
   * @since 2.0
   */
  void activateProtocol(String readerProtocol);

  /**
   * Deactivates the protocol provided from the reader's implementation point of view.
   *
   * <p>The argument is a reader specific String identifying the protocol.
   *
   * @param readerProtocol A not empty String.
   * @throws IllegalArgumentException if the argument is not correct
   * @since 2.0
   */
  void deactivateProtocol(String readerProtocol);

  /**
   * Tells if the current card communicates with the protocol provided as an argument.
   *
   * <p>The protocol identification string must match one of the protocols supported by this reader.
   *
   * <p>It returns true if the current protocol is the protocol provided as an argument, false if it
   * is not.
   *
   * @param readerProtocol A not empty string.
   * @return true if the current protocol corresponds to the one provided, false if not.
   * @throws IllegalArgumentException if the argument is not correct
   * @since 2.0
   */
  boolean isCurrentProtocol(String readerProtocol);

  /**
   * Attempts to open the physical channel.
   *
   * <p>This method returns normally only if the physical channel could be opened. An exception must
   * be raised if not.
   *
   * @throws ReaderIOException if the communication with the reader has failed.
   * @throws CardIOException if the communication with the card has failed and the physical channel
   *     could not be open.
   * @since 2.0
   */
  void openPhysicalChannel() throws ReaderIOException, CardIOException;

  /**
   * Attempts to close the current physical channel.
   *
   * @throws ReaderIOException if the communication with the reader has failed.
   * @since 2.0
   */
  void closePhysicalChannel() throws ReaderIOException;

  /**
   * Tells if the physical channel is open or not.
   *
   * @return true is the physical channel is open, false if not.
   */
  boolean isPhysicalChannelOpen();

  /**
   * Verifies the presence of the card.
   *
   * @return true if the card is present
   * @throws ReaderIOException if the communication with the reader has failed
   * @since 2.0
   */
  boolean checkCardPresence() throws ReaderIOException;

  /**
   * Get the ATR data
   *
   * <p>In contact mode, ATR data is the data returned by the card.
   *
   * <p>In contactless mode, as the ATR is not provided by the secured element, it can vary from one
   * plugin to another
   *
   * @return A not null reference
   * @since 2.0
   */
  byte[] getATR();

  /**
   * Transmits an APDU defined as a byte buffer and receives its response.
   *
   * <p><b>Caution: the implementation must handle the case where the card response is 61xy and
   * execute the appropriate get response command.</b>
   *
   * @param apduIn the outgoing data to be sent.
   * @return apduResponse A not empty byte buffer.
   * @throws IllegalArgumentException if the provided buffer is null or empty
   * @throws ReaderIOException if the communication with the reader has failed
   * @throws CardIOException if the communication with the card has failed
   * @since 2.0
   */
  byte[] transmitApdu(byte[] apduIn) throws ReaderIOException, CardIOException;

  /**
   * Tells if the reader is a contactless type.
   *
   * @return true if the reader a contactless type, false if not
   * @since 2.0
   */
  boolean isContactless();
}
