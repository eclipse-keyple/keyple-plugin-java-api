/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
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
 * org.eclipse.keyple.core.plugin.spi.reader.observable.state.insertion.CardInsertionWaiterAsynchronousSpi}
 *
 * @since 2.2.0
 */
public interface CardInsertionWaiterAsynchronousApi {

  /**
   * Must be invoked when a card is inserted.
   *
   * @since 2.2.0
   */
  void onCardInserted();
}
