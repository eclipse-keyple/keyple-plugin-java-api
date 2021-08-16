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
package org.eclipse.keyple.core.plugin.spi.reader;

/**
 * Reader able to manage multiple protocols and which allows the configuration of the protocol to
 * use.
 *
 * @since 2.0
 */
public interface ConfigurableReaderSpi extends ReaderSpi {

  /**
   * Indicates if the provided reader protocol is supported by the reader.
   *
   * <p>Using this method allows to invoke the {@link #activateProtocol(String)} method only if the
   * protocol is supported.
   *
   * @param readerProtocol The reader protocol.
   * @return True if the protocol is supported, false if not.
   * @since 2.0
   */
  boolean isProtocolSupported(String readerProtocol);

  /**
   * Activates a specific protocol in order to make the reader able to communicate with the cards
   * using this protocol.
   *
   * @param readerProtocol The reader specific protocol to activate.
   * @since 2.0
   */
  void activateProtocol(String readerProtocol);

  /**
   * Deactivates a specific protocol so that the reader ignores cards using this protocol.
   *
   * @param readerProtocol The reader specific protocol to deactivate.
   * @since 2.0
   */
  void deactivateProtocol(String readerProtocol);

  /**
   * Tells if the current card communicates with the provided protocol.
   *
   * @param readerProtocol The reader protocol to check.
   * @return True if the current protocol corresponds to the one provided, false if not.
   * @since 2.0
   */
  boolean isCurrentProtocol(String readerProtocol);
}
