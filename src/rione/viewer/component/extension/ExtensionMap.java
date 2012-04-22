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

import java.util.Collection;
import java.util.HashMap;

import rescuecore2.standard.entities.StandardEntity;
import rescuecore2.worldmodel.EntityID;

/**
 * EntityIDにEntityExtensionを対応付けます．
 * 
 * @author utisam
 *
 */
@SuppressWarnings("serial")
public class ExtensionMap extends HashMap<EntityID, EntityExtension> {
	
	/**
	 * idに割り当てられた EntityExtension を取得する．
	 * MapのgetがObjectになっているのでバグ対策．
	 * @param id
	 * @return idに割り当てられた EntityExtension
	 */
	public EntityExtension get(EntityID id) {
		return super.get(id);
	}
	/**
	 * StandardEntity に割り当てられた EntityExtension を取得する．
	 * MapのgetがObjectになっているのでバグ対策．
	 * @param se
	 * @return idに割り当てられた EntityExtension
	 */
	public EntityExtension get(StandardEntity se) {
		return super.get(se.getID());
	}
	
	/**
	 * StandardEntity に EntityExtension を割り当てます．
	 * @param se
	 * @param v
	 * @return 関連付けられていた過去の値
	 */
	public EntityExtension put(StandardEntity se, EntityExtension v) {
		return super.put(se.getID(), v);
	}
	
	/**
	 * entities全てにextensionを設定します．
	 * @param entities
	 * @param extension
	 */
	public void putExtensionToAll(Collection<? extends StandardEntity> entities,
			EntityExtension extension) {
		if (entities == null) return;
		for (StandardEntity se : entities) {
			this.put(se.getID(), extension);
		}
	}
	
	/**
	 * entities全てに装飾を追加します．
	 * @param entities
	 * @param dFunc 装飾生成関数
	 */
	public void putExtensionToAll(Collection<? extends StandardEntity> entities,
			DecoratorFunction dFunc) {
		if (entities == null) return;
		for (StandardEntity se : entities) {
			this.put(se.getID(), dFunc.create(this.get(se.getID())));
		}
	}
	
	public void putExtensionToAllID(Collection<EntityID> ids,
			EntityExtension extension) {
		if (ids == null) return;
		for (EntityID id : ids) {
			this.put(id, extension);
		}
	}
	
	public void putExtensionToAllID(Collection<EntityID> ids,
			DecoratorFunction dFunc) {
		if (ids == null) return;
		for (EntityID id : ids) {
			this.put(id, dFunc.create(this.get(id)));
		}
	}
	
}
