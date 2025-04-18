/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.processing;

import org.eclipse.keyple.core.plugin.ReaderIOException;
import org.eclipse.keyple.core.plugin.TaskCanceledException;

/**
 * Reader able to detect a card removal during processing, between two APDU commands.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers.
 *
 * @since 2.0.0
 * @deprecated Useless SPI, don't implement it. Will be removed in a future version of this API.
 */
@Deprecated
public interface WaitForCardRemovalDuringProcessingBlockingSpi {

  /**
   * Waits indefinitely for a card to be removed.
   *
   * <p>This wait can be cancelled for an internal (for example timeout) or external reason (for
   * example invocation of {@link #stopWaitForCardRemovalDuringProcessing()}), in this case an
   * exception is raised.
   *
   * @throws ReaderIOException If the communication with the reader
   * @throws TaskCanceledException If the task has been canceled and is no longer active
   * @since 2.0.0
   * @deprecated
   */
  @Deprecated
  void waitForCardRemovalDuringProcessing() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the waiting of the removal of the card
   *
   * @since 2.0.0
   * @deprecated
   */
  @Deprecated
  void stopWaitForCardRemovalDuringProcessing();
}
