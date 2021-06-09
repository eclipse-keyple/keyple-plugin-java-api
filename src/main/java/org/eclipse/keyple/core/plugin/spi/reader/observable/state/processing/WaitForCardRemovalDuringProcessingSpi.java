/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.processing;

/**
 * Reader able to detect a card removal during processing, between two APDU commands.
 *
 * <p>A typical example of readers conforming to this mode of operation are PC/SC type readers.
 *
 * @since 2.0
 */
public interface WaitForCardRemovalDuringProcessingSpi {}
