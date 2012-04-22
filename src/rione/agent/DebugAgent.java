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
package rione.agent;

import java.awt.Graphics2D;
import java.util.Set;

import rescuecore2.misc.gui.ScreenTransform;
import rescuecore2.standard.entities.StandardWorldModel;
import rescuecore2.worldmodel.EntityID;
import rione.viewer.component.extension.ExtensionMap;


/**
 * デバッガが各エージェントを統一的に処理するためのインターフェイス
 * 要するに密告用
 * @author utisam
 *
 */
public interface DebugAgent {

	/** そのAgentのWorld */
	StandardWorldModel getWorld();

	/** そのAgentのID */
	EntityID getID();

	/** 視界内のEntityID */
	Set<EntityID> getVisibleEntities();

	/** 自由に装飾を設定できるExtensionマップを返す */
	ExtensionMap customExtension();
	
	/** 自由に描画を行う */
	void customRender(Graphics2D g, ScreenTransform t, int width, int height);

	/**
	 * メソッド呼び出しの文字列を返す．<br>
	 * コマンドの送信に関わるメソッドをオーバーライドすることにより，StringBuilderに文字列を追加し，
	 * その結果を返してください．
	 */
	String getCommandsCall();
}
