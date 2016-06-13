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

package io.sundr.examples.codegen;

import io.sundr.builder.annotations.Buildable;
import io.sundr.codegen.utils.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.sundr.codegen.utils.StringUtils.join;

@Buildable
public class Method extends ModifierSupport {
    private final Set<ClassRef> annotations;
    private final Set<TypeParamDef> parameters;
    private final String name;
    private final TypeRef returnType;
    private final List<Property> arguments;
    private final boolean varArgPreferred;
    private final Set<ClassRef> exceptions;
    private final Block block;

    public Method(Set<ClassRef> annotations, Set<TypeParamDef> parameters, String name, TypeRef returnType, List<Property> arguments, boolean varArgPreferred, Set<ClassRef> exceptions, Block block, int modifiers, Map<String, Object> attributes) {
        super(modifiers, attributes);
        this.annotations = annotations;
        this.parameters = parameters;
        this.name = name;
        this.returnType = returnType;
        this.arguments = arguments;
        this.varArgPreferred = varArgPreferred;
        this.exceptions = exceptions;
        this.block = block;
    }

    public Set<ClassRef> getAnnotations() {
        return annotations;
    }

    public boolean isVarArgPreferred() {
        return varArgPreferred;
    }

    public Set<TypeParamDef> getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    public TypeRef getReturnType() {
        return returnType;
    }

    public List<Property> getArguments() {
        return arguments;
    }


    public Set<ClassRef> getExceptions() {
        return exceptions;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Method method = (Method) o;

        if (parameters != null ? !parameters.equals(method.parameters) : method.parameters != null) return false;
        if (name != null ? !name.equals(method.name) : method.name != null) return false;
        return arguments != null ? arguments.equals(method.arguments) : method.arguments == null;

    }

    @Override
    public int hashCode() {
        int result = parameters != null ? parameters.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (arguments != null ? arguments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isPublic()) {
            sb.append("public ");
        } else if (isProtected()) {
            sb.append("protected ");
        } else if (isPrivate()) {
            sb.append("private ");
        }

        if (isSynchronized()) {
            sb.append("synchronized ");
        }

        if (isStatic()) {
            sb.append("static ");
        }

        if (isFinal()) {
            sb.append("final ");
        }

        if (parameters != null && !parameters.isEmpty()) {
            sb.append("<");
            sb.append(StringUtils.join(parameters, ","));
            sb.append(">");
        }

        if (name != null) {
            sb.append(returnType);
            sb.append(" ").append(name);
        } else {
            //This is a constructor
            sb.append(((ClassRef)returnType).getDefinition().getName());
        }

        sb.append("(");
        if (!varArgPreferred) {
            sb.append(StringUtils.join(arguments, ","));
        } else if (!arguments.isEmpty()) {
            List<Property> args = arguments.subList(0, arguments.size() - 1);
            Property varArg = arguments.get(arguments.size() - 1);
            sb.append(StringUtils.join(args, ","));
            if (!args.isEmpty()) {
                sb.append(",");
            }
            if (varArg.getTypeRef().getDimensions() == 1) {
                sb.append(varArg.getTypeRef().withDimensions(0)).append("... ");
            } else {
                sb.append(varArg.getTypeRef().withDimensions(0)).append("... ");
            }
            sb.append(varArg.getName());
        }
        sb.append(")");

        if (exceptions != null && !exceptions.isEmpty()) {
            sb.append(" throws ").append(join(exceptions, ","));
        }

        return sb.toString();
    }
}