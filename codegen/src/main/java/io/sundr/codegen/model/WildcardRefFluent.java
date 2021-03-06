/*
 *      Copyright 2019 The original authors.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package io.sundr.codegen.model;

import io.sundr.builder.Nested;
import io.sundr.builder.Predicate;
import io.sundr.builder.VisitableBuilder;

import java.util.Collection;
import java.util.List;

public interface WildcardRefFluent<A extends WildcardRefFluent<A>> extends TypeRefFluent<A>{


    public A addToBounds(VisitableBuilder<? extends TypeRef, ?> builder);
    public A addToBounds(int index, VisitableBuilder<? extends TypeRef, ?> builder);
    public A addToBounds(int index, TypeRef item);
    public A setToBounds(int index, TypeRef item);
    public A addToBounds(TypeRef... items);
    public A addAllToBounds(Collection<TypeRef> items);
    public A removeFromBounds(VisitableBuilder<? extends TypeRef, ?> builder);
    public A removeFromBounds(TypeRef... items);
    public A removeAllFromBounds(Collection<TypeRef> items);

/**
 * This method has been deprecated, please use method buildBounds instead.
 * @return The buildable object.
 */
@Deprecated public List<TypeRef> getBounds();
    public List<TypeRef> buildBounds();
    public TypeRef buildBound(int index);
    public TypeRef buildFirstBound();
    public TypeRef buildLastBound();
    public TypeRef buildMatchingBound(Predicate<VisitableBuilder<? extends TypeRef, ?>> predicate);
    public Boolean hasMatchingBound(Predicate<VisitableBuilder<? extends TypeRef, ?>> predicate);
    public A withBounds(List<TypeRef> bounds);
    public A withBounds(TypeRef... bounds);
    public Boolean hasBounds();
    public A addToPrimitiveRefBounds(int index, PrimitiveRef item);
    public A setToPrimitiveRefBounds(int index, PrimitiveRef item);
    public A addToPrimitiveRefBounds(PrimitiveRef... items);
    public A addAllToPrimitiveRefBounds(Collection<PrimitiveRef> items);
    public A removeFromPrimitiveRefBounds(PrimitiveRef... items);
    public A removeAllFromPrimitiveRefBounds(Collection<PrimitiveRef> items);
    public WildcardRefFluent.PrimitiveRefBoundsNested<A> setNewPrimitiveRefBoundLike(int index, PrimitiveRef item);
    public WildcardRefFluent.PrimitiveRefBoundsNested<A> addNewPrimitiveRefBound();
    public WildcardRefFluent.PrimitiveRefBoundsNested<A> addNewPrimitiveRefBoundLike(PrimitiveRef item);
    public A addToVoidRefBounds(int index, VoidRef item);
    public A setToVoidRefBounds(int index, VoidRef item);
    public A addToVoidRefBounds(VoidRef... items);
    public A addAllToVoidRefBounds(Collection<VoidRef> items);
    public A removeFromVoidRefBounds(VoidRef... items);
    public A removeAllFromVoidRefBounds(Collection<VoidRef> items);
    public WildcardRefFluent.VoidRefBoundsNested<A> setNewVoidRefBoundLike(int index, VoidRef item);
    public WildcardRefFluent.VoidRefBoundsNested<A> addNewVoidRefBound();
    public WildcardRefFluent.VoidRefBoundsNested<A> addNewVoidRefBoundLike(VoidRef item);
    public A addToWildcardRefBounds(int index, WildcardRef item);
    public A setToWildcardRefBounds(int index, WildcardRef item);
    public A addToWildcardRefBounds(WildcardRef... items);
    public A addAllToWildcardRefBounds(Collection<WildcardRef> items);
    public A removeFromWildcardRefBounds(WildcardRef... items);
    public A removeAllFromWildcardRefBounds(Collection<WildcardRef> items);
    public WildcardRefFluent.WildcardRefBoundsNested<A> setNewWildcardRefBoundLike(int index, WildcardRef item);
    public WildcardRefFluent.WildcardRefBoundsNested<A> addNewWildcardRefBound();
    public WildcardRefFluent.WildcardRefBoundsNested<A> addNewWildcardRefBoundLike(WildcardRef item);
    public A addToClassRefBounds(int index, ClassRef item);
    public A setToClassRefBounds(int index, ClassRef item);
    public A addToClassRefBounds(ClassRef... items);
    public A addAllToClassRefBounds(Collection<ClassRef> items);
    public A removeFromClassRefBounds(ClassRef... items);
    public A removeAllFromClassRefBounds(Collection<ClassRef> items);
    public WildcardRefFluent.ClassRefBoundsNested<A> setNewClassRefBoundLike(int index, ClassRef item);
    public WildcardRefFluent.ClassRefBoundsNested<A> addNewClassRefBound();
    public WildcardRefFluent.ClassRefBoundsNested<A> addNewClassRefBoundLike(ClassRef item);
    public A addToTypeParamRefBounds(int index, TypeParamRef item);
    public A setToTypeParamRefBounds(int index, TypeParamRef item);
    public A addToTypeParamRefBounds(TypeParamRef... items);
    public A addAllToTypeParamRefBounds(Collection<TypeParamRef> items);
    public A removeFromTypeParamRefBounds(TypeParamRef... items);
    public A removeAllFromTypeParamRefBounds(Collection<TypeParamRef> items);
    public WildcardRefFluent.TypeParamRefBoundsNested<A> setNewTypeParamRefBoundLike(int index, TypeParamRef item);
    public WildcardRefFluent.TypeParamRefBoundsNested<A> addNewTypeParamRefBound();
    public WildcardRefFluent.TypeParamRefBoundsNested<A> addNewTypeParamRefBoundLike(TypeParamRef item);

    public interface PrimitiveRefBoundsNested<N> extends Nested<N>,PrimitiveRefFluent<WildcardRefFluent.PrimitiveRefBoundsNested<N>>{


    public N and();    public N endPrimitiveRefBound();
}
    public interface VoidRefBoundsNested<N> extends Nested<N>,VoidRefFluent<WildcardRefFluent.VoidRefBoundsNested<N>>{


    public N and();    public N endVoidRefBound();
}
    public interface WildcardRefBoundsNested<N> extends Nested<N>,WildcardRefFluent<WildcardRefFluent.WildcardRefBoundsNested<N>>{


    public N and();    public N endWildcardRefBound();
}
    public interface ClassRefBoundsNested<N> extends Nested<N>,ClassRefFluent<WildcardRefFluent.ClassRefBoundsNested<N>>{


    public N and();    public N endClassRefBound();
}
    public interface TypeParamRefBoundsNested<N> extends Nested<N>,TypeParamRefFluent<WildcardRefFluent.TypeParamRefBoundsNested<N>>{

        
    public N and();    public N endTypeParamRefBound();
}


}
