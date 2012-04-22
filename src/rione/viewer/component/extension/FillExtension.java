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

import rescuecore2.misc.gui.ScreenTransform;

/**
 * 塗りつぶしを行う装飾
 * @author utisam
 *
 */
public class FillExtension implements EntityExtension {

	final private EntityExtension base;
	final private Color color;

	public static final FillExtension BLACK = new FillExtension(Color.BLACK);
	public static final FillExtension BLUE = new FillExtension(Color.BLUE);
	public static final FillExtension CYAN = new FillExtension(Color.CYAN);
	public static final FillExtension DARK_GRAY = new FillExtension(Color.DARK_GRAY);
	public static final FillExtension GRAY = new FillExtension(Color.GRAY);
	public static final FillExtension GREEN = new FillExtension(Color.GREEN);
	public static final FillExtension LIGHT_GRAY = new FillExtension(Color.LIGHT_GRAY);
	public static final FillExtension MAGENTA = new FillExtension(Color.MAGENTA);
	public static final FillExtension ORANGE = new FillExtension(Color.ORANGE);
	public static final FillExtension PINK = new FillExtension(Color.PINK);
	public static final FillExtension RED = new FillExtension(Color.RED);
	public static final FillExtension WHITE = new FillExtension(Color.WHITE);
	public static final FillExtension YELLOW = new FillExtension(Color.YELLOW);

	public FillExtension(Color c) {
		this(null, c);
	}

	/**
	 * 塗りつぶします
	 * @param base baseの効果を描画した後にさらに塗りつぶされます．
	 * @param c 塗りつぶしの色
	 */
	public FillExtension(EntityExtension base, Color c) {
		this.base = base;
		this.color = c;
	}

	/**
	 * このインスタンスをテンプレートとする生成関数を返します．
	 * @return このインスタンスをテンプレートとする生成関数．
	 */
	public DecoratorFunction decorator() {
		return new DecoratorFunction() {
			@Override
			public EntityExtension create(EntityExtension base) {
				return new FillExtension(base, color);
			}
		};
	}

	@Override
	public int render(Graphics2D g, ScreenTransform t, Shape s, int x, int y) {
		int yOffset = 0;
		if (base != null) {
			yOffset = base.render(g, t, s, x, y);
		}
		g.setColor(color);
		g.fill(s);
		return yOffset;
	}

}
