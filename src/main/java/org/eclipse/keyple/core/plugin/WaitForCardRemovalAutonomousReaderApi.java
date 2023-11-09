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
package org.eclipse.keyple.core.plugin;

/**
 * API associated to a {@link
 * org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal.WaitForCardRemovalAutonomousSpi}
 *
 * @since 2.0.0
 * @deprecated Use {@link CardRemovalWaiterAsynchronousApi} instead (will be removed in a future
 *     version of this API).
 */
@Deprecated
public interface WaitForCardRemovalAutonomousReaderApi {

  /**
   * Must be invoked when a card is removed.
   *
   * @since 2.0.0
   * @deprecated Use {@link CardRemovalWaiterAsynchronousApi#onCardRemoved()} instead.
   */
  @Deprecated
  void onCardRemoved();
}
