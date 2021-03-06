/*
 * Copyright 2013 Romain Gilles
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.javabits.yar;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * TODO comment
 * Date: 3/19/13
 * Time: 8:55 AM
 *
 * @author Romain Gilles
 */
public abstract class AbstractMultiElementWatcher<T> extends AbstractWatcher<T> {

    private Map<Supplier<T>, Boolean> trackedElements = new IdentityHashMap<>();

    @Override
    protected void track(Supplier<T> handle) {
        if (handle != null) {
            trackedElements.put(handle, Boolean.TRUE);
        }
    }

    @Override
    protected boolean isTracked(Supplier<T> element) {
        return trackedElements.containsKey(element);
    }
}
