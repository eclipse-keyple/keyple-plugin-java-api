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
 * Reader able to communicate with smart cards.
 *
 * <p>This is the base interface for all reader types, including readers with permanently present
 * cards (e.g. SAM readers) and observable readers detecting card insertion and removal.
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
   * Ensures that the physical channel is open and that the card is ready to receive APDU commands.
   *
   * <p>On successful return:
   *
   * <ul>
   *   <li>the power-on data are available via {@link #getPowerOnData()};
   *   <li>the card is ready to receive APDU commands via {@link #transmitApdu(byte[])}.
   * </ul>
   *
   * <p>If {@link #checkCardPresence()} has already opened the physical channel (e.g. for
   * contactless readers performing anti-collision during presence detection), this method is a
   * no-op.
   *
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws CardIOException If no card is present or if the communication with the card has failed.
   * @since 2.0.0
   */
  void openPhysicalChannel() throws ReaderIOException, CardIOException;

  /**
   * Closes the physical channel.
   *
   * <ul>
   *   <li><b>Card present:</b> physically closes the channel (e.g. cuts the RF field, powers down
   *       the card, or performs a PC/SC reset).
   *   <li><b>Card absent:</b> no-op.
   * </ul>
   *
   * @throws ReaderIOException If the card is present and the close operation fails (reader
   *     problem).
   * @since 2.0.0
   */
  void closePhysicalChannel() throws ReaderIOException;

  /**
   * Tells if the physical channel is open or not.
   *
   * @return True is the physical channel is open, false if not.
   * @since 2.0.0
   */
  boolean isPhysicalChannelOpen();

  /**
   * Verifies the presence of a card.
   *
   * <p>The behavior of this method depends on the state of the physical channel:
   *
   * <ul>
   *   <li><b>Physical channel closed:</b> performs a best-effort one-shot detection, starting the
   *       RF field or powering up the card if necessary. If this detection also opens the physical
   *       channel (e.g. for contactless readers performing anti-collision), a subsequent call to
   *       {@link #openPhysicalChannel()} is a no-op.
   *   <li><b>Physical channel open:</b> verifies that the card is still present using the
   *       underlying SDK capabilities (e.g. ping APDU). If the card is no longer present, {@link
   *       #closePhysicalChannel()} is called internally before returning {@code false}.
   * </ul>
   *
   * @return {@code true} if a card is present, {@code false} otherwise.
   * @throws ReaderIOException If the communication with the reader has failed.
   * @since 2.0.0
   */
  boolean checkCardPresence() throws ReaderIOException;

  /**
   * Gets the power-on data.
   *
   * <p>The power-on data is defined as the data retrieved by the reader when the card is inserted.
   * This method is only meaningful after {@link #openPhysicalChannel()} has returned successfully.
   *
   * <p>In the case of a contact reader, this is the Answer To Reset data (ATR) defined by ISO7816.
   *
   * <p>In the case of a contactless reader, the reader decides what this data is. Contactless
   * readers provide a virtual ATR (partially standardized by the PC/SC standard), but other devices
   * can have their own definition, including for example elements from the anti-collision stage of
   * the ISO14443 protocol (ATQA, ATQB, ATS, SAK, etc).
   *
   * <p>These data being variable from one reader to another, they are defined here in string format
   * which can be either a hexadecimal string or any other relevant information. An empty string may
   * be returned if no power-on data is available (e.g. for a reader with a permanently powered
   * card).
   *
   * @return A non-null String, possibly empty.
   * @since 2.0.0
   */
  String getPowerOnData();

  /**
   * Transmits an APDU and returns its response.
   *
   * <p><b>Caution: the implementation must handle the ISO 7816-3 T=0 protocol specificity at the
   * transport level: status word {@code 61xx} (response bytes available) requires automatically
   * issuing a {@code GET RESPONSE} command (Calypsonet Terminal requirement "RL-SW-61XX.1"). This
   * is handled at the SPI level because its behavior depends on the underlying reader
   * implementation (T=0, T=1, PC/SC).</b>
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
