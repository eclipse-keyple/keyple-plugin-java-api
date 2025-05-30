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
 * Reader able to detect and notify a card removal during processing, between two APDU commands.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers.
 *
 * @since 2.3.0
 */
public interface CardPresenceMonitorBlockingSpi {

  /**
   * Monitors the card presence indefinitely (the method is blocking as long as the card is
   * present).
   *
   * <p>This monitoring can be cancelled for an internal (for example timeout) or external reason
   * (for example invocation of {@link #stopCardPresenceMonitoringDuringProcessing()}), in this case
   * an exception is raised.
   *
   * @throws ReaderIOException If the communication with the reader has failed.
   * @throws TaskCanceledException If the task has been canceled and is no longer active.
   * @since 2.3.0
   */
  void monitorCardPresenceDuringProcessing() throws ReaderIOException, TaskCanceledException;

  /**
   * Interrupts the monitoring of the card presence.
   *
   * @since 2.3.0
   */
  void stopCardPresenceMonitoringDuringProcessing();
}
