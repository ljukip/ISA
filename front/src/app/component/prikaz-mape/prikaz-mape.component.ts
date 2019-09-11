import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import OlMap from 'ol/Map';
import Feature from 'ol/Feature.js';
import Point from 'ol/geom/Point.js';
import OlXYZ from 'ol/source/XYZ';
import OlTileLayer from 'ol/layer/Tile';
import OlView from 'ol/View';
import { fromLonLat } from 'ol/proj';
import VectorSource from 'ol/source/Vector.js';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer.js';
import {Icon, Style} from 'ol/style.js';

@Component({
  selector: 'app-prikaz-mape',
  templateUrl: './prikaz-mape.component.html',
  styleUrls: ['./prikaz-mape.component.css']
})
export class PrikazMapeComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute)
  {
    
  }

  private sub: any;
  map: OlMap;
  source: OlXYZ;
  layer: OlTileLayer;
  view: OlView;
  private longitude : number ;
  private latitude : number ;

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      if(params['longitude'] != null && params['longitude'] != undefined){
        this.longitude = +params['longitude'];
      }
      // else{
      //   this.longitude = 44.9;
      // }

      if(params['latitude'] != null && params['latitude'] != undefined){
        this.latitude = +params['latitude'];
      }
      // else{
      //   this.latitude = 18.8;
      // }
    });

    var placemark = new Feature({
      geometry: new Point(fromLonLat([this.longitude, this.latitude]))
    });

    placemark.setStyle(new Style({
      image: new Icon(/** @type {module:ol/style/Icon~Options} */ ({
        crossOrigin: 'anonymous',
        src: 'assets/placemark.png'
      }))
    }));

    var vectorSource = new VectorSource({
      features: [placemark]
    });

    var vectorLayer = new VectorLayer({
      source: vectorSource
    });

    this.source = new OlXYZ({
      url: 'http://tile.osm.org/{z}/{x}/{y}.png'
    });

    this.layer = new OlTileLayer({
      source: this.source
    });

    this.view = new OlView({
      center: fromLonLat([this.longitude, this.latitude]),
      zoom: 18
    });

    this.map = new OlMap({
      target: 'map',
      layers: [this.layer, vectorLayer],
      view: this.view
    });
  }
}