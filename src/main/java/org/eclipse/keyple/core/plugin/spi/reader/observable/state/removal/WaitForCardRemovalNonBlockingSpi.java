/* **************************************************************************************
 * Copyright (c) 2019 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.plugin.spi.reader.observable.state.removal;

/**
 * Reader that require an external active stimulation to detect card removal without implementing a
 * waiting mechanism.
 *
 * <p>A typical example of readers conforming to this mode of operation are terminals embedding a
 * slave RF communication module.
 *
 * @since 2.0.0
 * @deprecated Implement {@link CardRemovalWaiterNonBlockingSpi} instead (will be removed in a
 *     future version of this API).
 */
@Deprecated
public interface WaitForCardRemovalNonBlockingSpi {}
