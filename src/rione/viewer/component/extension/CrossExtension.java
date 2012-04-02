package rione.viewer.component.extension;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

import rescuecore2.misc.gui.ScreenTransform;
import rione.viewer.component.TransformedGraphics;

/**
 * 十字の装飾
 * 
 * @author utisam
 * 
 */
public class CrossExtension implements EntityExtension {

	private final EntityExtension base;
	private final int length;
	private final Color color;
	private final Stroke stroke;
	
	private final static float DEFAULT_THICKNESS = 1.0f;
	private final static int DEFAULT_LENGTH = 3;
	
	public CrossExtension(Color c) {
		this(null, c, new BasicStroke(DEFAULT_THICKNESS), DEFAULT_LENGTH);
	}
	
	public CrossExtension(Color c, float t, int length) {
		this(null, c, new BasicStroke(t), length);
	}
	
	public CrossExtension(EntityExtension base, Color c) {
		this(base, c, new BasicStroke(DEFAULT_THICKNESS), DEFAULT_LENGTH);
	}
	
	public CrossExtension(EntityExtension base, Color c, float t, int length) {
		this(base, c, new BasicStroke(t), length);
	}
	
	public CrossExtension(EntityExtension base, Color c, Stroke s, int length) {
		this.base = base;
		this.color = c;
		this.stroke = s;
		this.length = length;
	}
	
	/**
	 * このインスタンスをテンプレートとする生成関数を返します．
	 * @return このインスタンスをテンプレートとする生成関数．
	 */
	public DecoratorFunction decorator() {
		return new DecoratorFunction() {
			@Override
			public EntityExtension create(EntityExtension base) {
				return new CrossExtension(base, color, stroke, length);
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
		g.setStroke(stroke);
		TransformedGraphics gt = new TransformedGraphics(g, t);
		gt.drawLine(x - length, y, x + length, y);
		gt.drawLine(x, y - length, x, y + length);
		return yOffset;
	}

}
