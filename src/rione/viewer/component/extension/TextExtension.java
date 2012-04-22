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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Collections;
import java.util.List;

import rescuecore2.misc.gui.ScreenTransform;

/**
 * 文字列の装飾
 * 
 * @author utisam
 * 
 */
public class TextExtension implements EntityExtension {
	
	private final List<String> text;
	private final EntityExtension base;
	private final Color stringColor;

	public TextExtension(String str, Color color) {
		this(Collections.singletonList(str), color);
	}

	public TextExtension(List<String> strs, Color color) {
		this(null, strs, color);
	}
	
	public TextExtension(EntityExtension base, String str, Color color) {
		this(base, Collections.singletonList(str), color);
	}

	public TextExtension(EntityExtension base, List<String> strs, Color color) {
		this.base = base;
		text = strs;
		stringColor = color;
	}

	@Override
	public int render(Graphics2D g, ScreenTransform t, Shape s, int x, int y) {
		int yOffset = 0;
		if (base != null) {
			yOffset = base.render(g, t, s, x, y);
		}
		g.setColor(stringColor);
		for (String str : text) {
			g.drawString(str, t.xToScreen(x), t.yToScreen(y) + yOffset);
			yOffset += g.getFontMetrics().getAscent();
		}
		return yOffset;
	}

}
