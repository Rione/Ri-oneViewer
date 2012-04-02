package rione.viewer.component.extension;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

import rescuecore2.misc.gui.ScreenTransform;
import rione.viewer.component.TransformedGraphics;

/**
 * 斜め十字の装飾
 * @author utisam
 *
 */
public class XExtension implements EntityExtension {

	private final EntityExtension base;
	private final int length;
	private final Color color;
	private final Stroke stroke;
	
	private final static int DEFAULT_LENGTH = 3;
	static private final float DEFAULT_THICKNESS = 1.0f; 
	
	/**
	 * baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param c 色
	 */
	public XExtension(Color c) {
		this(null, c, DEFAULT_THICKNESS, DEFAULT_LENGTH);
	}
	
	/**
	 * baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param c 色
	 * @param length 長さ
	 * @param t 太さ
	 */
	public XExtension(Color c, float t, int length) {
		this(null, c, t, length);
	}
	
	/**
	 * baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param base baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param c 色
	 */
	public XExtension(EntityExtension base, Color c) {
		this(base, c, DEFAULT_THICKNESS, DEFAULT_LENGTH);
	}
	
	/**
	 * baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param base baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param c 色
	 * @param t 太さ
	 * @param length 長さ
	 */
	public XExtension(EntityExtension base, Color c, float t, int length) {
		this(base, c, new BasicStroke(t), length);
	}
	
	/**
	 * baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param base baseの効果を描画した後にさらに斜め十字を描画します．
	 * @param c 色
	 * @param s ストローク
	 * @param length 長さ
	 */
	public XExtension(EntityExtension base, Color c, Stroke s, int length) {
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
				return new XExtension(base, color, stroke, length);
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
		gt.drawLine(x - length, y - length, x + length, y + length);
		gt.drawLine(x + length, y - length, x - length, y + length);
		return yOffset;
	}

}
