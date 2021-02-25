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
import org.eclipse.keyple.core.plugin.TaskCanceledException;

/**
 * Interface to be implemented by the readers able to handle natively the card removal process.
 *
 * @since 2.0
 */
public interface WaitForCardRemovalBlockingSpi {
  /**
   * Waits indefinitely for a card to be inserted.
   *
   * <p>This wait can be cancelled for an internal (e.g. timeout) or external reason (e.g. call to
   * {@link #stopWaitForCardRemoval()}), in this case an exception is raised.
   *
   * @throws ReaderIOException if the communication with the reader
   * @throws TaskCanceledException if the task has been canceled and is no longer active
   * @since 2.0
   */
  void waitForCardAbsentNative() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the waiting of the removal of the card
   *
   * @since 2.0
   */
  void stopWaitForCardRemoval();
}
