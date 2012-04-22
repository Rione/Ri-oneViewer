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
package rione.viewer.component.controller;

import java.awt.Color;
import java.awt.Dimension;

import rescuecore2.worldmodel.EntityID;
import rione.viewer.component.AdvancedViewComponent;

/**
 * ビューア全体に必要なデータを管理するインタフェース<br>
 * コントローラだけど参照される感じ<br>
 * 真の意味でコントロールしてるのはViewerEventProcessorかも
 * これに沿って作れば新しいコントローラを作ることができる<br>
 * コンストラクタでこれを引数にしたコントローラ(コピーコンストラクタ)を作れば引継ぎができる<br>
 * 新しい表示を作りたいときはココにオプションを作ってから，
 * 全部のコントローラにCtrl+1でメソッドを自動生成させると速い
 * 
 * @author utisam
 *
 */
public interface Controller {
	
	/** コントロールしているAdvancedViewComponent */
	AdvancedViewComponent getViewComponent();
	/** フォーカスされたEntityID */
	EntityID getFocus();
	/**
	 * フォーカスのsetter<br>
	 * 主にEntityをクリックした時の呼び出し用
	 */
	void setFocus(EntityID id);
	/**
	 * 毎サイクル呼び出される
	 * @param time
	 * @return 次のサイクルからのコントローラ(通常はthis)
	 */
	Controller update(int time);
	/** 視界内のEntityの表示をするか */
	boolean visibleEntity();
	/** 自由設定装飾を表示するか */
	boolean costomExtention();
	/** 自由描画を表示するか */
	boolean customRender();
	/** 呼び出された命令を表示するか */
	boolean lastCommand();
	/** worldmodelの座標をプロットする */
	boolean plotLocation();
	/** 追従 */
	boolean followFocus();
	/** 終了するか */
	boolean killAgents();
	/**
	 * 保存するフォルダ
	 * @return 保存しないならnull
	 */
	String getSaveFolderName();
	/** フォルダに画像を保存するか */
	boolean saveImage();
	/** 独自ログを保存するか */
	boolean saveLog();
	/** 市民の色(nullならデフォルト) */
	Color getCivilianColor();
	/** ATの色(nullならデフォルト) */
	Color getAmbulanceTeamColor();
	/** FBの色(nullならデフォルト) */
	Color getFireBrigadeColor();
	/** PFの色(nullならデフォルト) */
	Color getPoliceForceColor();
	Dimension getFrameSize();
}
