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

/**
 * Reader able to detect cards autonomously.
 *
 * <p>The implementation of this interface also requires the choice of a single interface in each of
 * the 'insertion', 'processing' and 'removal' {@link
 * org.eclipse.keyple.core.plugin.spi.reader.observable.states} sub-packages.
 *
 * @since 2.0
 */
public interface ObservableReaderSpi {

  /**
   * Called when the reader started the card detection
   *
   * @since 2.0
   */
  void onStartDetection();

  /**
   * Called when the reader stopped the card detection
   *
   * @since 2.0
   */
  void onStopDetection();

  /**
   * Gets the exception handler to be used for notifying execution failures during reader
   * monitoring.
   *
   * @return A not null reference.
   * @since 2.0
   */
  ReaderObservationExceptionHandlerSpi getReaderObservationExceptionHandler();
}
