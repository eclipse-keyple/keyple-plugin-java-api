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
   * Tells if the reader is a contactless type.
   *
   * @return True if the reader a contactless type, false if not.
   * @since 2.0.0
   */
  boolean isContactless();

  /**
   * Checks whether a card is currently present in the reader and, if so, activates communication
   * with it.
   *
   * <p>When this method returns {@code true}, the card is powered and ready for communication:
   *
   * <ul>
   *   <li>the power-on data are available via {@link #getPowerOnData()};
   *   <li>APDU commands can be sent via {@link #transmitApdu(byte[])}.
   * </ul>
   *
   * <p>When this method returns {@code false}, no card is present and the above methods are not
   * meaningful. All previously retrieved data are invalidated.
   *
   * <p>If a {@link ReaderIOException} is thrown, the implementation must have released any
   * resources associated with the card communication before returning, leaving the reader in a
   * clean state ready for a new detection cycle.
   *
   * @return {@code true} if a card is present and communication is active, {@code false} otherwise.
   * @throws ReaderIOException If the communication with the reader has failed.
   * @since 3.0.0
   */
  boolean isCardPresent() throws ReaderIOException;

  /**
   * Gets the power-on data.
   *
   * <p>The power-on data is defined as the data retrieved by the reader when the card is inserted.
   * This method is only meaningful after {@link #isCardPresent()} has returned {@code true}.
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
   * <p>If a {@link ReaderIOException} or {@link CardIOException} is thrown, the implementation must
   * have released any resources associated with the card communication before returning, leaving
   * the reader in a clean state ready for a new detection cycle.
   *
   * @param apduIn The data to be sent to the card.
   * @return A buffer of at least 2 bytes.
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws CardIOException If the communication with the card has failed.
   * @since 2.0.0
   */
  byte[] transmitApdu(byte[] apduIn) throws ReaderIOException, CardIOException;

  /**
   * Invoked when unregistering the associated plugin.
   *
   * @since 2.0.0
   */
  void onUnregister();
}
