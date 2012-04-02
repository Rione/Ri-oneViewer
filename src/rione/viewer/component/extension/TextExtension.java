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
