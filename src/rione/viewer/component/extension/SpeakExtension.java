package rione.viewer.component.extension;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import rescuecore2.misc.gui.ScreenTransform;

public class SpeakExtension implements EntityExtension {
	final private Color insideColor;
	final private Color edgeColor;
	final private Color stringColor;
	final private EntityExtension base;
	final private String[] strings;

	/**
	 * 吹き出しでStringを表示します
	 * 
	 * @param str
	 *            要素1つが1行に表示されます
	 */
	public SpeakExtension(ArrayList<String> str) {
		this(null, (String[]) str.toArray(), Color.black, Color.WHITE, Color.black);
	}

	/**
	 * 吹き出しでStringを表示します
	 * 
	 * @param str
	 *            要素1つが1行に表示されます
	 */
	public SpeakExtension(String[] str) {
		this(null, str, Color.black, Color.WHITE, Color.black);
	}

	/**
	 * 吹き出しでStringを表示します
	 */
	public SpeakExtension(String str) {
		this(null, new String[] { str }, Color.black, Color.WHITE, Color.black);
	}

	/**
	 * 吹き出しでStringを表示します
	 * 
	 * @param base
	 *            baseに対してこの装飾を追加します
	 * @param str
	 *            要素1つが1行に表示されます
	 */

	public SpeakExtension(EntityExtension base, ArrayList<String> str) {
		this(base, (String[]) str.toArray(), Color.black, Color.WHITE, Color.black);
	}

	/**
	 * 吹き出しでStringを表示します
	 * 
	 * @param base
	 *            baseに対してこの装飾を追加します
	 * @param str
	 *            要素1つが1行に表示されます
	 */
	public SpeakExtension(EntityExtension base, String[] str) {
		this(base, str, Color.black, Color.WHITE, Color.black);
	}

	public SpeakExtension(EntityExtension base, String str) {
		this(base, new String[] { str }, Color.black, Color.WHITE, Color.black);
	}

	public SpeakExtension(EntityExtension base, ArrayList<String> str, Color edge, Color inside, Color string_color) {
		this(base, (String[]) str.toArray(), edge, inside, string_color);
	}

	/**
	 * 吹き出しでStringを表示します
	 * 
	 * @param base
	 *            baseに対してこの装飾を追加します
	 * @param str
	 *            要素1つが1行に表示されます
	 * @param edge
	 *            縁の色
	 * @param inside
	 *            吹き出しの色
	 * @param stringColor
	 *            文字色
	 */
	public SpeakExtension(EntityExtension base, String[] str, Color edge, Color inside, Color stringColor) {
		this.base = base;
		this.strings = str;
		this.edgeColor = edge;
		this.insideColor = inside;
		this.stringColor = stringColor;
	}

	@Override
	public int render(Graphics2D g, ScreenTransform t, Shape s, int x, int y) {
		if (base != null) {
			base.render(g, t, s, x, y);
		}
		int round = 10, dist = 10, dist2 = 20, space = 5, height = g.getFontMetrics().getAscent();
		int ScreenBaseX = t.xToScreen(x);
		int ScreenBaseY = t.yToScreen(y);
		int[] xp = { ScreenBaseX + dist, ScreenBaseX + dist2, ScreenBaseX + dist2 };
		int[] yp = { ScreenBaseY, ScreenBaseY - space, ScreenBaseY + space };
		g.setColor(insideColor);
		g.fillPolygon(xp, yp, 3);
		g.setColor(edgeColor);
		g.setStroke(new BasicStroke(2));
		g.drawPolygon(xp, yp, 3);

		String longestStr = new String();
		for (String str : strings) {
			if (str.length() > longestStr.length())
				longestStr = str;
		}

		int stringWidth = g.getFontMetrics().stringWidth(longestStr);
		g.setColor(insideColor);
		g.setStroke(new BasicStroke(4));
		FontMetrics gmt = g.getFontMetrics();
		g.fillRoundRect(ScreenBaseX + round + dist, ScreenBaseY - height / 2, stringWidth + 20, gmt.getHeight() + gmt.getAscent() * (strings.length - 1), 10, 10);
		g.setColor(edgeColor);
		g.drawRoundRect(ScreenBaseX + round + dist, ScreenBaseY - height / 2, stringWidth + 20, gmt.getHeight() + gmt.getAscent() * (strings.length - 1), 10, 10);
		g.setColor(stringColor);
		int lines = 0;
		for (String str : strings) {
			g.drawString(str, ScreenBaseX + round + dist + 10, ScreenBaseY + g.getFontMetrics().getHeight() / 2 + lines * g.getFontMetrics().getAscent());
			lines++;
		}
		g.setStroke(new BasicStroke(1));
		return 0;
	}

}
