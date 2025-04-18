/* **************************************************************************************
 * Copyright (c) 2023 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader;

/**
 * Reader extension for pool readers.
 *
 * @since 2.1.0
 */
public interface PoolReaderSpi extends ReaderSpi {

  /**
   * Returns the selected smart card when it has been provided by the reader allocation process.
   *
   * @return Null if no smart card is selected by default, the selected smart card otherwise.
   * @since 2.1.0
   */
  Object getSelectedSmartCard();
}
