/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal;

import org.eclipse.keyple.core.plugin.ReaderIOException;
import org.eclipse.keyple.core.plugin.TaskCanceledException;

/**
 * This SPI is specifically designed for plugins that handle card removal synchronously. The plugin
 * waits autonomously and indefinitely for the removal of a card by implementing a waiting
 * mechanism.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers
 * capable of performing RF polling without waiting for a command from the application.
 *
 * @since 2.2.0
 */
public interface CardRemovalWaiterBlockingSpi {

  /**
   * Waits indefinitely for a card to be removed.
   *
   * <p>This wait can be cancelled for an internal (for example timeout) or external reason (for
   * example invocation of {@link #stopWaitForCardRemoval()}), in this case an exception is raised.
   *
   * @throws ReaderIOException If the communication with the reader
   * @throws TaskCanceledException If the task has been canceled and is no longer active
   * @since 2.2.0
   */
  void waitForCardRemoval() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the waiting of the removal of the card
   *
   * @since 2.2.0
   */
  void stopWaitForCardRemoval();
}
