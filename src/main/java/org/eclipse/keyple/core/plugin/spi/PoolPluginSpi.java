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
package org.eclipse.keyple.core.plugin.spi;

import java.util.SortedSet;
import org.eclipse.keyple.core.plugin.PluginIOException;
import org.eclipse.keyple.core.plugin.spi.reader.PoolReaderSpi;
import org.eclipse.keyple.core.plugin.spi.reader.ReaderSpi;

/**
 * Plugin able to manage a dynamic list of readers based on an allocation/de-allocation mechanism
 * (for example HSM).
 *
 * @since 2.0.0
 */
public interface PoolPluginSpi {

  /**
   * Gets the name of the pool plugin.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getName();

  /**
   * Gets a list of group references that will be used as an argument to {@link
   * #allocateReader(String)}.
   *
   * <p>A group reference can represent a family of Reader with all the same characteristics (for
   * example SAM with identical key sets).
   *
   * @return An empty Set if there is no group reference
   * @throws PluginIOException If an error occurs
   * @since 2.0.0
   */
  SortedSet<String> getReaderGroupReferences() throws PluginIOException;

  /**
   * Obtains an available reader resource and makes it exclusive to the caller until the
   * releaseReader method is invoked.
   *
   * <p>The allocated reader belongs to the group targeted with the provided group reference.
   *
   * @param readerGroupReference The reader group reference (optional).
   * @return A not null reference.
   * @throws PluginIOException If an error occurs.
   * @since 2.0.0
   */
  PoolReaderSpi allocateReader(String readerGroupReference) throws PluginIOException;

  /**
   * Releases the reader previously allocated with {@link #allocateReader(String)} and whose
   * reference is provided.
   *
   * <p>This method must be invoked as soon as the reader is no longer needed by the caller of
   * {@link #allocateReader(String)} in order to free the resource.
   *
   * @param readerSpi The reader to deallocate
   * @throws PluginIOException If an error occurs
   * @since 2.0.0
   */
  void releaseReader(ReaderSpi readerSpi) throws PluginIOException;

  /**
   * Invoked when unregistering the plugin.
   *
   * @since 2.0.0
   */
  void onUnregister();
}
