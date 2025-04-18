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
package org.eclipse.keyple.core.plugin;

/**
 * Indicates that an error occurred while communicating with a card.
 *
 * @since 2.0.0
 */
public class CardIOException extends Exception {

  /**
   * @param message the message to identify the exception context
   * @since 2.0.0
   */
  public CardIOException(String message) {
    super(message);
  }

  /**
   * @param message the message to identify the exception context
   * @param cause the cause
   * @since 2.0.0
   */
  public CardIOException(String message, Throwable cause) {
    super(message, cause);
  }
}
