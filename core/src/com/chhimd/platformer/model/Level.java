package com.chhimd.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath) {
        map = new TmxMapLoader().load(mapPath);// loading the map

    }

    public MapLayer getMapLayer (String layername) {
        return map.getLayers().get(layername); // gets layer
    }

    public MapObjects getLayerObjects(MapLayer mapLayer) {
        return mapLayer.getObjects(); //returns array
    }
}
