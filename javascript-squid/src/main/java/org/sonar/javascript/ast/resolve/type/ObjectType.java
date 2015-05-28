/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011 SonarSource and Eriks Nukis
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.javascript.ast.resolve.type;

import javax.annotation.Nullable;

public class ObjectType implements Type {

  private FunctionTypeTree functionTypeTree = null;

  @Override
  public boolean isCallable() {
    return functionTypeTree != null;
  }

  @Override
  public Kind kind() {
    if (isCallable()){
      return Kind.FUNCTION;
    } else {
      return Kind.OBJECT;
    }
  }

  protected ObjectType(){}

  public static ObjectType createFunction(FunctionTypeTree functionTypeTree){
    ObjectType objectType = new ObjectType();
    objectType.functionTypeTree = functionTypeTree;
    return objectType;
  }

  public static ObjectType create(){
    return new ObjectType();
  }

  @Nullable
  public FunctionTypeTree functionTypeTree(){
    return functionTypeTree;
  }
}