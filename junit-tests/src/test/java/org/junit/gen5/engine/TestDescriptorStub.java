/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.gen5.engine;

import org.junit.gen5.engine.support.descriptor.AbstractTestDescriptor;

public final class TestDescriptorStub extends AbstractTestDescriptor {

	public TestDescriptorStub(String uniqueId) {
		super(uniqueId);
	}

	@Override
	public String getName() {
		return getUniqueId();
	}

	@Override
	public String getDisplayName() {
		return getUniqueId();
	}

	@Override
	public boolean isTest() {
		return getChildren().isEmpty();
	}

	@Override
	public boolean isContainer() {
		return !isTest();
	}
}
