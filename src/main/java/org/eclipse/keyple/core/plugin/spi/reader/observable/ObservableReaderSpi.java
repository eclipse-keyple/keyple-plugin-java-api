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
package org.eclipse.keyple.core.plugin.spi.reader.observable;

import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.*;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.processing.*;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.*;

/**
 * Reader capable of detecting card insertion and removal.
 *
 * <p>In addition to the base {@link ReaderSpi} contract, an observable reader defines its
 * observation capabilities for card insertion, removal, and optionally processing.
 *
 * <p>For card insertion, it must implement one of:
 *
 * <ul>
 *   <li>{@link CardInsertionWaiterAsynchronousSpi}
 *   <li>{@link CardInsertionWaiterBlockingSpi}
 *   <li>{@link CardInsertionWaiterNonBlockingSpi}
 * </ul>
 *
 * <p>For card removal, it must implement one of:
 *
 * <ul>
 *   <li>{@link CardRemovalWaiterAsynchronousSpi}
 *   <li>{@link CardRemovalWaiterBlockingSpi}
 *   <li>{@link CardRemovalWaiterNonBlockingSpi}
 * </ul>
 *
 * <p>For card processing (monitoring presence between APDU commands), it may optionally implement:
 *
 * <ul>
 *   <li>{@link CardPresenceMonitorBlockingSpi} for readers that support blocking presence
 *       monitoring (e.g., PC/SC readers)
 * </ul>
 *
 * <p>Readers implementing {@link CardRemovalWaiterAsynchronousSpi} (e.g., Android NFC readers) do
 * not need to implement {@link CardPresenceMonitorBlockingSpi}, as asynchronous removal
 * notifications cover all phases, including processing.
 *
 * <p>Once a card insertion is detected through any of these mechanisms, the card is in the same
 * active state as when {@link ReaderSpi#isCardPresent()} returns {@code true}: power-on data are
 * available via {@link ReaderSpi#getPowerOnData()} and APDU commands can be sent via {@link
 * ReaderSpi#transmitApdu(byte[])}.
 *
 * <p>The framework calls {@link #deselectCard()} after card processing completes and before
 * entering the removal waiting phase, regardless of the removal strategy.
 *
 * @since 2.0.0
 */
public interface ObservableReaderSpi extends ReaderSpi {

  /**
   * Called when card detection starts.
   *
   * <p>Initializes any hardware or driver state required to begin detection (e.g., enables polling,
   * arms interrupts).
   *
   * @since 2.0.0
   */
  void onStartDetection();

  /**
   * Called when card detection stops.
   *
   * <p>Releases any hardware or driver resources acquired during detection (e.g., disables polling,
   * disarms interrupts).
   *
   * @since 2.0.0
   */
  void onStopDetection();

  /**
   * Deselects the currently active card, transitioning it to the HALT state to enable reliable
   * removal detection.
   *
   * <p>This method is called by the framework immediately after card processing completes and
   * before entering the removal waiting phase. A card left in the <b>ACTIVE</b> state cannot be
   * reliably detected as absent: polling commands (REQA/REQB, ISO/IEC 14443-3) only target cards in
   * the IDLE state. Deselecting the card moves it to the <b>HALT</b> state, where it responds only
   * to WUPA/WUPB, making presence and absence unambiguous.
   *
   * <p>Implementations may use one of the following approaches:
   *
   * <ul>
   *   <li><b>ISO/IEC 14443-4 S(DESELECT)</b> — sends an S-block (PCB {@code 0xC2} without CID,
   *       {@code 0xCA} with CID). The card acknowledges and transitions to HALT while the RF field
   *       remains on. This is the preferred, protocol-compliant approach (EMVCo, NFC Forum "Sleep
   *       Deactivation").
   *   <li><b>RF field interruption</b> — briefly turns off the RF field, resetting the card. When
   *       restored, the card returns to IDLE and is discoverable via REQA/REQB. This approach is
   *       universal but more disruptive (no protocol handshake, affects all cards, requires
   *       settling time).
   * </ul>
   *
   * <p>For readers implementing {@link CardRemovalWaiterAsynchronousSpi} (e.g., Android NFC
   * readers), this method may be a no-op if deselection is handled by the driver or not required
   * before removal notification.
   *
   * @since 3.0.0
   */
  void deselectCard();
}
