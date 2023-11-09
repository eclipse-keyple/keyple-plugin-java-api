/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
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

import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.*;
import org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.*;

/**
 * Reader able to detect the insertion and removal of cards.
 *
 * <p>In addition, an observable reader must also define its observation capabilities for the card
 * insertion and removal steps.
 *
 * <p>For the card insertion state, it must implement one of the following interfaces:
 *
 * <ul>
 *   <li>{@link CardInsertionWaiterAsynchronousSpi}
 *   <li>{@link CardInsertionWaiterBlockingSpi}
 *   <li>{@link CardInsertionWaiterNonBlockingSpi}
 * </ul>
 *
 * <p>For the card removal state, it must implement one of the following interfaces:
 *
 * <ul>
 *   <li>{@link CardRemovalWaiterAsynchronousSpi}
 *   <li>{@link CardRemovalWaiterBlockingSpi}
 *   <li>{@link CardRemovalWaiterNonBlockingSpi}
 * </ul>
 *
 * @since 2.0.0
 */
public interface ObservableReaderSpi extends ReaderSpi {

  /**
   * Invoked when the card observation process is started
   *
   * @since 2.0.0
   */
  void onStartDetection();

  /**
   * Invoked when the card observation process is stopped
   *
   * @since 2.0.0
   */
  void onStopDetection();
}
