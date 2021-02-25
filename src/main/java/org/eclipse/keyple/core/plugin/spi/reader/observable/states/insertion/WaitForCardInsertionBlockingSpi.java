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
package org.eclipse.keyple.core.plugin.spi.reader.observable.states.insertion;

import org.eclipse.keyple.core.plugin.ReaderIOException;
import org.eclipse.keyple.core.plugin.TaskCanceledException;

/**
 * Must be implemented by readers that are autonomous in the management of waiting for the insertion
 * of a card and that provide a method to wait for it indefinitely.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers
 * capable of performing RF polling without waiting for a command from the application.
 *
 * @since 2.0
 */
public interface WaitForCardInsertionBlockingSpi {
  /**
   * Waits indefinitely for a card to be inserted.
   *
   * <p>This wait can be cancelled for an internal (e.g. timeout) or external reason (e.g. call to
   * {@link #stopWaitForCard()}), in this case an exception is raised.
   *
   * @throws ReaderIOException if the communication with the reader has failed (disconnection)
   * @throws TaskCanceledException if the task has been canceled and is no longer active
   * @since 2.0
   */
  void waitForCardPresent() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the waiting of a card
   *
   * @since 2.0
   */
  void stopWaitForCard();
}
