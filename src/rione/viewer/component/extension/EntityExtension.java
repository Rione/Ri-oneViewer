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

import java.awt.Graphics2D;
import java.awt.Shape;

import rescuecore2.misc.gui.ScreenTransform;

public interface EntityExtension {
	/**
	 * gに対してsの描画を行う際に呼び出されます．
	 * customExtension内でExtensionMapに追加してください．
	 * @see rione.viewer.component.extension.ExtensionMap
	 * @param g 描画対象
	 * @param t 変換行列
	 * @param s 装飾対象
	 * @param x 装飾対象エンティティのx
	 * @param y 装飾対象エンティティのy
	 * @return テキストのyOffset
	 */
	int render(Graphics2D g, ScreenTransform t, Shape s, int x, int y);
}
