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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;

public class Heavyweight implements ParameterResolver {

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext context) {
		return Resource.class.equals(parameterContext.getParameter().getType());
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext context) {
		ExtensionContext engineContext = context.getRoot();
		ExtensionContext.Store store = engineContext.getStore(ExtensionContext.Namespace.GLOBAL);
		ResourceValue resource = store.getOrComputeIfAbsent(ResourceValue.class);
		resource.usages.incrementAndGet();
		return resource;
	}

	interface Resource {
		int usages();
	}

	static class ResourceValue implements Resource, AutoCloseable {

		private final AtomicInteger usages = new AtomicInteger();

		@Override
		public void close() {
			assertEquals(3, usages.get(), "Usage counter mismatch!");
		}

		@Override
		public int usages() {
			return usages.get();
		}
	}

}
