import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.page.html',
  styleUrls: ['./modal.page.scss'],
})
export class ModalPage implements OnInit {
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
