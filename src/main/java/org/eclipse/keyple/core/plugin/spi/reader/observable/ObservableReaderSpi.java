/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://www.calypsonet-asso.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable;

import org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.WaitForCardInsertionAutonomousSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.WaitForCardInsertionBlockingSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.WaitForCardInsertionNonBlockingSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.processing.DontWaitForCardRemovalDuringProcessingSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.processing.WaitForCardRemovalDuringProcessingSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.WaitForCardRemovalAutonomousSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.WaitForCardRemovalBlockingSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.WaitForCardRemovalNonBlockingSpi;

/**
 * Reader able to detect the insertion and removal of cards.
 *
 * <p>In addition, an observable reader must also define its observation capabilities for the card
 * insertion, processing and removal steps.
 *
 * <p>For the card insertion state, it must implement one of the following interfaces:
 *
 * <ul>
 *   <li>{@link WaitForCardInsertionBlockingSpi}
 *   <li>{@link WaitForCardInsertionNonBlockingSpi}
 *   <li>{@link WaitForCardInsertionAutonomousSpi}
 * </ul>
 *
 * <p>For the card processing state, it must implement one of the following interfaces:
 *
 * <ul>
 *   <li>{@link WaitForCardRemovalDuringProcessingSpi}
 *   <li>{@link DontWaitForCardRemovalDuringProcessingSpi}
 * </ul>
 *
 * <p>For the card removal state, it must implement one of the following interfaces:
 *
 * <ul>
 *   <li>{@link WaitForCardRemovalBlockingSpi}
 *   <li>{@link WaitForCardRemovalNonBlockingSpi}
 *   <li>{@link WaitForCardRemovalAutonomousSpi}
 * </ul>
 *
 * @since 2.0
 */
public interface ObservableReaderSpi {

  /**
   * Invoked when the card observation process is started
   *
   * @since 2.0
   */
  void onStartDetection();

  /**
   * Invoked when the card observation process is stopped
   *
   * @since 2.0
   */
  void onStopDetection();
}
