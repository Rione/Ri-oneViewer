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
/**
 * 
 */
package rione.viewer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rione.viewer.component.AdvancedViewComponent;

/**
 * キーリスナーを統一するためのクラス<br>
 * コレを込みでクラスの関係みるとぐちゃぐちゃなので，
 * キー関係は最後に見るのがいいと思う
 * 
 * @author utisam
 *
 */
public class ViewerEventProcessor implements KeyListener {
	
	protected AdvancedViewComponent viewer = null;
	
	public ViewerEventProcessor(AdvancedViewComponent v) {
		viewer = v;
	}

	/* (非 Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_U:
				// [U]ndo
				viewer.resetZoom();
				break;
			case KeyEvent.VK_I:
				// Zoom[I]n
				viewer.zoomIn();
				break;
			case KeyEvent.VK_O:
				// Zoom[O]ut
				viewer.zoomOut();
				break;
			default:
				return;
		}
		viewer.repaint();
	}

	/* (非 Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/* (非 Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
