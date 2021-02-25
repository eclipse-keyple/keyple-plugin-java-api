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
package org.eclipse.keyple.core.plugin.spi;

import java.util.SortedSet;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Must be implemented by a specific pool plugin.
 *
 * @since 2.0
 */
public interface PoolPluginSpi {

  /**
   * Gets the name of the pool plugin.
   *
   * @return A not empty string.
   * @since 2.0
   */
  String getName();

  /**
   * Gets a list of group references that will be used as an argument to allocateReader.
   *
   * <p>A group reference can represent a family of Reader with all the same characteristics (e.g.
   * SAM with identical key sets).
   *
   * @return A not null reference
   * @since 2.0
   */
  SortedSet<String> getReaderGroupReferences();

  /**
   * Obtains an available Reader resource and makes it exclusive to the caller until the
   * releaseReader method is called.
   *
   * <p>The allocated reader belongs to the group targeted with the provided group reference.
   *
   * <p>Depending on the implementation made, this reference may be null.
   *
   * @param readerGroupReference A nullable String
   * @return A not null reference
   * @since 2.0
   */
  ReaderSpi allocateReader(String readerGroupReference);

  /**
   * Releases the reader previously allocated with allocateReader and whose reference is provided.
   *
   * <p>This method must be called as soon as the reader is no longer needed by the caller of
   * allocateReader in order to free the resource.
   *
   * @param readerSpi A not null reference
   * @since 2.0
   */
  void releaseReader(ReaderSpi readerSpi);
}
