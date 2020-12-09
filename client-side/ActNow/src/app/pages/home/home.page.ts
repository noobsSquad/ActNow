import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { InformationModalPage } from '../information-modal/information-modal.page';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {

  emergencyInfoList: string[] = ["Avalanche", "Earthquake", "Extreme Heat", "Flood", 
  "Hurricane", "Landslide", "Novel Pandemic", "Nuclear Explosion","Power Outage",
  "Thunderstorm, Lighting, Hail","Tornado","Tsunami","Volcano","Wildfire","Winter Storm"];
  danger: boolean = false;
  selectedInfo: string;
  constructor( private modalController: ModalController) 
  {
  }

  ngOnInit() {
  }
  async presentModal(value){
    const title = await value;
    console.log(title);
    const modal = await this.modalController.create({
      component: InformationModalPage,
      componentProps:{
        'title': title,
        "information": "Hurricanes are not just a coastal problem. Find out how rain, wind, water could happen where you live so you can start preparing now. ",
        "lastUpdated": "2020/10/3"
      }
    }).then(elementModal => elementModal.present());
  }

}
