package rione.viewer.component.extension;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

import rescuecore2.misc.gui.ScreenTransform;

public class CircleExtension implements EntityExtension {

	private final Color color;
	private final Stroke stroke;
	private final EntityExtension base;
	private final int r;
	
	public CircleExtension(Color c, int r) {
		this(null, c, 1.0f, r);
	}
	
	public CircleExtension(Color c, float t, int r) {
		this(null, c, t, r);
	}
	
	public CircleExtension(Color c, Stroke s, int r) {
		this(null, c, s, r);
	}
	
	public CircleExtension(EntityExtension base, Color c, int r) {
		this(base, c, 1.0f, r);
	}
	
	public CircleExtension(EntityExtension base, Color c, float t, int r) {
		this(base, c, new BasicStroke(t), r);
	}
	
	public CircleExtension(EntityExtension base, Color c, Stroke s, int r) {
		this.base = base;
		this.color = c;
		this.stroke = s;
		this.r = r;
	}

	@Override
	public int render(Graphics2D g, ScreenTransform t, Shape s, int x, int y) {
		int yOffset = 0;
		if (base != null) {
			yOffset = base.render(g, t, s, x, y);
		}
		g.setColor(color);
		g.setStroke(stroke);
		int sx = t.xToScreen(x - r);
		int sy =  t.yToScreen(y + r);
		int ex = t.xToScreen(x + r);
		int ey =  t.yToScreen(y - r);
		g.drawOval(sx, sy, ex - sx, ey - sy);
		return yOffset;
	}

}
