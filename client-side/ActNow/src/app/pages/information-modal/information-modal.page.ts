import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-information-modal',
  templateUrl: './information-modal.page.html',
  styleUrls: ['./information-modal.page.scss'],
})
export class InformationModalPage implements OnInit {
  @Input() title: string;
  @Input() information: string;
  @Input() lastUpdated: string;
    constructor(private modalController: ModalController) { }
    ngOnInit() {
    }
  
  
    dismiss(){
      this.modalController.dismiss();
    }
  
    getContent(){
      return document.querySelector('ion-card-content');
    }
    scrollToBottom(){
      this.getContent().scrollTo;
    }
  
}
