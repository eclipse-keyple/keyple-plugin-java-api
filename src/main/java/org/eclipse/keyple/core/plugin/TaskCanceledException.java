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
package org.eclipse.keyple.core.plugin;

/**
 * Indicates that a task (for example, waiting for a card to be inserted) has been cancelled and is
 * no longer active.
 *
 * @since 2.0.0
 */
public class TaskCanceledException extends Exception {

  /**
   * @param message the message to identify the exception context
   * @since 2.0.0
   */
  public TaskCanceledException(String message) {
    super(message);
  }
}
