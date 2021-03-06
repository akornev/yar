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

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Date: 3/5/13
 * Time: 10:03 PM
 *
 * @author Romain Gilles
 * @since 1.0
 */
public interface BlockingSupplierRegistry extends Registry {
    TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;
    long DEFAULT_TIMEOUT = 5L;

    @Nullable
    @Override
    <T> BlockingSupplier<T> get(Class<T> type);

    @Nullable
    @Override
    <T> BlockingSupplier<T> get(Id<T> id);
}
