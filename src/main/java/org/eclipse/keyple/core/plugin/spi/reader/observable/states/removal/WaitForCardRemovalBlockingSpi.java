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
package org.eclipse.keyple.core.plugin.spi.reader.observable.states.removal;

import org.eclipse.keyple.core.plugin.ReaderIOException;

/**
 * Interface to be implemented by the readers able to handle natively the card removal process.
 *
 * @since 2.0
 */
public interface WaitForCardRemovalBlockingSpi {
  /**
   * Wait until the card disappears.
   *
   * <p>TODO check these explanations
   *
   * <p>This method must be implemented by the plugin's reader class when it must manage the card
   * removal process itself. (for example by using the analogous waitForCardAbsent method in the
   * case of a plugin based on smartcard.io [PC/SC]).
   *
   * <p>In the case where the reader plugin is not able to handle the card removal process itself
   * (not implementing the {@link WaitForCardRemovalBlockingSpi} interface, then it is managed by
   * the isCardPresentPing method defined in this class.
   *
   * <p>Returns true if the card has disappeared.
   *
   * @return presence status
   * @throws ReaderIOException if the communication with the reader
   * @since 2.0
   */
  boolean waitForCardAbsentNative();

  /**
   * Interrupts the waiting of the removal of the card
   *
   * @since 2.0
   */
  void stopWaitForCardRemoval();
}
