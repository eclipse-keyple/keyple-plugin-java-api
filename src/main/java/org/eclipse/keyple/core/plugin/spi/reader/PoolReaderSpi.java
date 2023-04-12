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
 * Reader extension for pool readers having the capability to provide a selected smart card.
 *
 * @since 2.1.0
 */
public interface PoolReaderSpi extends ReaderSpi {

  /**
   * Returns the selected smart card when it has been provided by the reader allocation process.
   *
   * @return null if no smart card is selected by default, the selected smart card otherwise.
   * @since 2.1.0
   */
  Object getSelectedSmartCard();
}
