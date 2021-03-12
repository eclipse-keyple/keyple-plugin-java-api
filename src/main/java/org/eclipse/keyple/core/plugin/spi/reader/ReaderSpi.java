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
 * Reader able to communicate with smart cards whose purpose is to remain present in the reader (for
 * example a SAM reader).
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
   * <p>Using this method allows to invoke the {@link #activateProtocol(String)} method only if the
   * protocol is supported.
   *
   * @param readerProtocol The reader protocol.
   * @return true if the protocol is supported, false if not.
   * @throws IllegalArgumentException if the protocol is null or empty
   * @since 2.0
   */
  boolean isProtocolSupported(String readerProtocol);

  /**
   * Activates a specific protocol in order to make the reader able to communicate with the cards
   * using this protocol.
   *
   * @param readerProtocol The reader specific protocol to activate.
   * @throws IllegalArgumentException if the protocol is null, empty or not supported
   * @since 2.0
   */
  void activateProtocol(String readerProtocol);

  /**
   * Deactivates a specific protocol so that the reader ignores cards using this protocol.
   *
   * @param readerProtocol The reader specific protocol to deactivate.
   * @throws IllegalArgumentException if the protocol is null, empty or not supported
   * @since 2.0
   */
  void deactivateProtocol(String readerProtocol);

  /**
   * Tells if the current card communicates with the provided protocol.
   *
   * @param readerProtocol The reader protocol to check.
   * @return true if the current protocol corresponds to the one provided, false if not.
   * @throws IllegalArgumentException if the protocol is null or empty
   * @since 2.0
   */
  boolean isCurrentProtocol(String readerProtocol);

  /**
   * Attempts to open the physical channel (to established a communication with the card).
   *
   * @throws ReaderIOException if the communication with the reader has failed.
   * @throws CardIOException if the communication with the card has failed.
   * @since 2.0
   */
  void openPhysicalChannel() throws ReaderIOException, CardIOException;

  /**
   * Attempts to close the current physical channel.
   *
   * <p>The physical channel may have been implicitly closed previously by a card withdrawal.
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
   * Verifies the presence of a card.
   *
   * @return true if a card is present
   * @throws ReaderIOException if the communication with the reader has failed.
   * @since 2.0
   */
  boolean checkCardPresence() throws ReaderIOException;

  /**
   * Get the ATR data
   *
   * <p>In contact mode, ATR data is the data returned by the card.
   *
   * <p>In contactless mode, as the ATR is not provided by the card, it can vary from one reader to
   * another. In this case, the ATR represents more generally a block of data coming from the
   * anti-collision step forming an identifier allowing the distinction between cards of different
   * families. The developer of this method is free to choose the structure of this block of data as
   * long as it is meaningful with the elements allowing the identification of protocols.
   *
   * @return A not empty array
   * @since 2.0
   */
  byte[] getATR();

  /**
   * Transmits an APDU and returns its response.
   *
   * <p><b>Caution: the implementation must handle the case where the card response is 61xy and
   * execute the appropriate get response command.</b>
   *
   * @param apduIn The data to be sent to the card.
   * @return A buffer of at least 2 bytes.
   * @throws IllegalArgumentException if the provided buffer is null or empty
   * @throws ReaderIOException if the communication with the reader has failed.
   * @throws CardIOException if the communication with the card has failed.
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

  /**
   * Invoked when unregistering the associated plugin.
   *
   * @since 2.0
   */
  void unregister();
}
