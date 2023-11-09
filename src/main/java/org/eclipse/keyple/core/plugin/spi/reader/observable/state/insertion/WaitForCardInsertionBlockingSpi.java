/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion;

import org.eclipse.keyple.core.plugin.ReaderIOException;
import org.eclipse.keyple.core.plugin.TaskCanceledException;

/**
 * Reader able to wait autonomously and indefinitely for the insertion of a card by implementing a
 * waiting mechanism.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers
 * capable of performing RF polling without waiting for a command from the application.
 *
 * @since 2.0.0
 * @deprecated Implement {@link CardInsertionWaiterBlockingSpi} instead (will be removed in a future
 *     version of this API).
 */
@Deprecated
public interface WaitForCardInsertionBlockingSpi {

  /**
   * Waits indefinitely for a card to be inserted.
   *
   * <p>This wait can be cancelled for an internal (for example timeout) or external reason (for
   * example invocation of {@link #stopWaitForCardInsertion()}), in this case an exception is
   * raised.
   *
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws TaskCanceledException If the task has been canceled and is no longer active
   * @since 2.0.0
   * @deprecated
   */
  @Deprecated
  void waitForCardInsertion() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the waiting of a card insertion.
   *
   * @since 2.0.0
   * @deprecated
   */
  @Deprecated
  void stopWaitForCardInsertion();
}
