import { Component, OnInit } from '@angular/core';
import { LocationService } from './location.service';
import * as mapboxgl from 'mapbox-gl';
import { GeoJson, FeatureCollection } from './map';

@Component({
  selector: 'app-location',
  templateUrl: './location.page.html',
  styleUrls: ['./location.page.scss'],
})
export class LocationPage implements OnInit {
  map: mapboxgl.Map;
  // mapboxgl = require('mapbox-gl/dist/mapbox-gl.js');
  style = 'mapbox://styles/mapbox/streets-v11';

 
  lat = 37.75;
  lng = -122.41;
  source: any;
  constructor(private mapService: LocationService) {
   }


  ngOnInit() {
    this.initializeMap();
  }

  private initializeMap() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(pos => {
        this.lat = pos.coords.latitude;
        this.lng = pos.coords.longitude;
        this.map.flyTo({
          center: [this.lng, this.lat]
        })
      });
    }
    this.buildMap();
  }

  buildMap() {
    mapboxgl.accessToken ="pk.eyJ1IjoidG9tYXNjNjkxIiwiYSI6ImNraWdmNWU1aDB2bTgyd3F3MzA4ZnJyenMifQ.X4Pb0LVLSkDJOqc8lOhGKA";
    console.log("build map");
    this.map = new mapboxgl.Map({
      container: 'map',
      style: 'mapbox://styles/mapbox/streets-v11',
      center: [this.lng, this.lat],
      zoom: 13
    });

  }
  flyTo(data: GeoJson){
    this.map.flyTo({
      center: data.geometry.coordinates
    })
  }
}
