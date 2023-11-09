/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
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
 * <p>The target devices must comply with the following Calypsonet Terminal requirements:
 *
 * <ul>
 *   <li>RL-CL-TS16794 (for contactless communication)
 *   <li>RL-DET-PCIBLOCK.1 (for contactless communication)
 *   <li>RL-CT-T0 (for contact communication)
 *   <li>RL-PERF-TIME.1
 * </ul>
 *
 * @since 2.0.0
 */
public interface ReaderSpi {

  /**
   * Gets the name of the reader.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getName();

  /**
   * Validates the opening of the physical channel. Performs the actual opening if this has not been
   * done by the {@link #checkCardPresence()} method. In all cases, memorizes the new state for the
   * operation of the {@link #isPhysicalChannelOpen()} method. After executing this method, the
   * reader is able to send APDUs to the card.
   *
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws CardIOException If the communication with the card has failed.
   * @since 2.0.0
   */
  void openPhysicalChannel() throws ReaderIOException, CardIOException;

  /**
   * Tells the reader that card processing is complete and that the next step is to remove the card
   * from the reader.
   *
   * <p>If the reader has the ability to sense the presence of the card without communicating with
   * it, then this method must proceed to the actual closing of the physical channel (e.g. power
   * down in the case of a contact reader). Otherwise, this method is limited to changing the
   * logical opening state of the physical channel and letting the removal procedure do the closing.
   *
   * @throws ReaderIOException If the communication with the reader has failed.
   * @since 2.0.0
   */
  void closePhysicalChannel() throws ReaderIOException;

  /**
   * Tells if the physical channel is open or not.
   *
   * @return True is the physical channel is open, false if not.
   */
  boolean isPhysicalChannelOpen();

  /**
   * Verifies the presence of a card.
   *
   * <p>Depending on the reader's capabilities, this method will either use a card presence
   * indicator without necessarily communicating with the card (for example, in the case of a
   * contact reader equipped with a physical insertion detector using a switch), or will communicate
   * with the card (in the case of contactless hunting). In the latter case, we can consider that
   * the physical channel has been opened (and therefore no longer needs to be opened in the {@link
   * #openPhysicalChannel()} method).
   *
   * @return True if a card is present
   * @throws ReaderIOException If the communication with the reader has failed.
   * @since 2.0.0
   */
  boolean checkCardPresence() throws ReaderIOException;

  /**
   * Gets the power-on data.
   *
   * <p>The power-on data is defined as the data retrieved by the reader when the card is inserted.
   *
   * <p>In the case of a contact reader, this is the Answer To Reset data (ATR) defined by ISO7816.
   *
   * <p>In the case of a contactless reader, the reader decides what this data is. Contactless
   * readers provide a virtual ATR (partially standardized by the PC/SC standard), but other devices
   * can have their own definition, including for example elements from the anti-collision stage of
   * the ISO14443 protocol (ATQA, ATQB, ATS, SAK, etc).
   *
   * <p>These data being variable from one reader to another, they are defined here in string format
   * which can be either a hexadecimal string or any other relevant information.
   *
   * @return A not empty String.
   * @since 2.0.0
   */
  String getPowerOnData();

  /**
   * Transmits an APDU and returns its response.
   *
   * <p><b>Caution: the implementation must handle the case where the card response is 61xy and
   * execute the appropriate get response command (Calypsonet Terminal requirement
   * "RL-SW-61XX.1").</b>
   *
   * @param apduIn The data to be sent to the card.
   * @return A buffer of at least 2 bytes.
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws CardIOException If the communication with the card has failed.
   * @since 2.0.0
   */
  byte[] transmitApdu(byte[] apduIn) throws ReaderIOException, CardIOException;

  /**
   * Tells if the reader is a contactless type.
   *
   * @return True if the reader a contactless type, false if not
   * @since 2.0.0
   */
  boolean isContactless();

  /**
   * Invoked when unregistering the associated plugin.
   *
   * @since 2.0.0
   */
  void onUnregister();
}
