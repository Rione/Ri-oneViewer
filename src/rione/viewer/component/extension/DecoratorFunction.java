/*
 *Copyright:

 Copyright (C) Ri-one, RoboCup Simulation League Project Team
    Ritsumeikan University College of Information Science and Engnieering

 This code is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 3, or (at your option)
 any later version.

 This code is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this code; see the file COPYING.  If not, write to
 the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.

 *EndCopyright:
 */
package rione.viewer.component.extension;

/**
 * 既存のExtensionにExtensionを付与するための関数オブジェクトのためのインタフェースです．
 * @see rione.viewer.component.extension.ExtensionMap
 * @author utisam
 *
 */
public interface DecoratorFunction {
	/**
	 * このインスタンスをテンプレートとしてbaseに装飾を付与します．
	 * @see rione.viewer.component.extension.ExtensionMap#putExtensionToAll(java.util.Collection, DecoratorFunction)
	 * @see rione.viewer.component.extension.ExtensionMap#putExtensionToAllID(java.util.Collection, DecoratorFunction)
	 * @param base
	 * @return baseに新しくExtensionを付与したもの
	 */
	EntityExtension create(EntityExtension base);
}
