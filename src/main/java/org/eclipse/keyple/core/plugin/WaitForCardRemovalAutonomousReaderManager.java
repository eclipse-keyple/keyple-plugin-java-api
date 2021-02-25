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
package org.eclipse.keyple.core.plugin;

/**
 * Manager associated to a {@link
 * org.eclipse.keyple.core.plugin.spi.reader.observable.states.removal.WaitForCardRemovalAutonomousSpi}
 *
 * @since 2.0
 */
public interface WaitForCardRemovalAutonomousReaderManager {

  /**
   * Must be called when a card is removed.
   *
   * @since 2.0
   */
  void onCardRemoved();
}
