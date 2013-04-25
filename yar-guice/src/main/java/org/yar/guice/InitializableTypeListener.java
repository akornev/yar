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

package org.yar.guice;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

/**
 * TODO comment
 * Date: 4/8/13
 * Time: 7:42 PM
 *
 * @author Romain Gilles
 */
public class InitializableTypeListener implements TypeListener {
    static final Matcher<? super TypeLiteral<?>> MATCHER = Matchers.subclassesOf(Initializable.class);

    @Override
    public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
        if (Initializable.class.isAssignableFrom(type.getRawType())) {
            encounter.register(new InjectionListener<I>() {
                @Override
                public void afterInjection(I injectee) {
                    if (injectee instanceof Initializable) {
                        Initializable initializable = (Initializable) injectee;
                        initializable.init();
                    }
                }
            });
        } else {
            encounter.addError("Unsupported type: %s", type);
        }
    }
}
