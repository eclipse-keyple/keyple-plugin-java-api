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
package org.eclipse.keyple.core.plugin;

/**
 * API associated to a {@link
 * org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.WaitForCardInsertionAutonomousSpi}
 *
 * @since 2.0.0
 * @deprecated Use {@link CardInsertionWaiterAsynchronousApi} instead (will be removed in a future
 *     version of this API).
 */
@Deprecated
public interface WaitForCardInsertionAutonomousReaderApi {

  /**
   * Must be invoked when a card is inserted.
   *
   * @since 2.0.0
   * @deprecated Use {@link CardInsertionWaiterAsynchronousApi#onCardInserted()} instead.
   */
  @Deprecated
  void onCardInserted();
}
