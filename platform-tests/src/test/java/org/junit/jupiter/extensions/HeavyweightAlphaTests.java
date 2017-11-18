/*
 * Copyright 2015-2017 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.extensions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Unit tests for {@link AutoCloseable} stored values.
 *
 * @since 1.1
 */
@ExtendWith(Heavyweight.class)
class HeavyweightAlphaTests {

	@Test
	void demoAlpha1(Heavyweight.Resource resource) {
		assertTrue(resource.usages() > 0);
	}

	@Test
	void demoAlpha2(Heavyweight.Resource resource) {
		assertTrue(resource.usages() > 0);
	}

}
