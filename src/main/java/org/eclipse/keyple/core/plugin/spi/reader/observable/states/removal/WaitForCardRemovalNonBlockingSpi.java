/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://www.calypsonet-asso.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.states.removal;

/**
 * Must be implemented by readers that require external active stimulation to detect card removal.
 *
 * <p>The card presence management API will be used by the service to produce the reader events.
 *
 * <p>A typical example of readers conforming to this mode of operation are terminals embedding a
 * slave RF communication module.
 *
 * @since 2.0
 */
public interface WaitForCardRemovalNonBlockingSpi {}
