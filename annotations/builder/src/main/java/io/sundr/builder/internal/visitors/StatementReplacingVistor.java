/*
 * Copyright 2016 The original authors.
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

package io.sundr.builder.internal.visitors;

import io.sundr.builder.TypedVisitor;
import io.sundr.codegen.model.StringStatementBuilder;

import static java.lang.String.format;

public class StatementReplacingVistor extends TypedVisitor<StringStatementBuilder> {

    private static final String CAST_TARGET_FORMAT = "\\(%s\\)";
    private static final String CAST_REPLACEMENT_FORMAT = "(%s)";
    private static final String PARAM_FORMAT = "<%s>";

    private final String target;
    private final String replacement;

    public StatementReplacingVistor(String target, String replacement) {
        this.target = target;
        this.replacement = replacement;
    }

    public void visit(StringStatementBuilder builder) {
        builder.withData(builder.getData()
                .replaceAll(format(CAST_TARGET_FORMAT, target), format(CAST_REPLACEMENT_FORMAT, replacement))
                .replaceAll(format(PARAM_FORMAT, target), format(PARAM_FORMAT, replacement))
        );

    }
}
