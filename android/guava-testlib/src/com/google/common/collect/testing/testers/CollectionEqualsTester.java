/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect.testing.testers;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.testing.AbstractCollectionTester;
import org.junit.Ignore;

/**
 * Tests {@link java.util.Collection#equals}.
 *
 * @author George van den Driessche
 */
@GwtCompatible
@Ignore("test runners must not instantiate and run this directly, only via suites we build")
// @Ignore affects the Android test runner, which respects JUnit 4 annotations on JUnit 3 tests.
@SuppressWarnings("JUnit4ClassUsedInJUnit3")
public class CollectionEqualsTester<E> extends AbstractCollectionTester<E> {

  @SuppressWarnings({
    "SelfEquals", // TODO(cpovirk): Consider using EqualsTester from Guava.
    "UndefinedEquals", // Comparisons of an object to itself *are* defined.
  })
  public void testEquals_self() {
    assertTrue("An Object should be equal to itself.", collection.equals(collection));
  }

  // Comparisons to null *are* defined.
  @SuppressWarnings("UndefinedEquals")
  public void testEquals_null() {
    // noinspection ObjectEqualsNull
    assertFalse("An object should not be equal to null.", collection.equals(null));
  }

  // A collection should essentially never be equal to a non-collection.
  @SuppressWarnings("UndefinedEquals")
  public void testEquals_notACollection() {
    // noinspection EqualsBetweenInconvertibleTypes
    assertFalse(
        "A Collection should never equal an object that is not a Collection.",
        collection.equals("huh?"));
  }
}
