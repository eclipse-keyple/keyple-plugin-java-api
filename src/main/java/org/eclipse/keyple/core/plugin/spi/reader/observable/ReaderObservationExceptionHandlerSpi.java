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
 * Reader observation error handler to be notified of runtime exceptions that may occur during
 * operations carried out by the card monitoring process.
 *
 * @since 2.0
 */
public interface ReaderObservationExceptionHandlerSpi {

  /**
   * Called when a runtime exception occurs in the observed reader.
   *
   * <p>The plugin and reader names and the original exception are provided.
   *
   * @param pluginName the plugin name
   * @param readerName the reader name
   * @param e the original exception
   * @since 2.0
   */
  void onReaderObservationError(String pluginName, String readerName, Throwable e);
}
