import { Component, OnInit,ViewChild } from '@angular/core';
import { IonInfiniteScroll } from '@ionic/angular';

@Component({
  selector: 'app-news',
  templateUrl: './news.page.html',
  styleUrls: ['./news.page.scss'],
})

export class NewsPage implements OnInit {
@ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  // author: string ="John Smith";
  // title: string ="Testing title";
  // postDate: string="12/12/2020";
  news: NewsContent={author:"John Smith", title:"Testing Title",datePosted:"12/12/2020",retrievedImageUrl:"https://images.unsplash.com/photo-1553576368-05915e96ca1c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"};
  testcount=2;
  listNews: NewsContent[] = [];
  constructor() { 
    this.addMoreItems();
  }

  ngOnInit() {
  }

  loadData(event){
    setTimeout(() => {
      console.log('Done');
      this.addMoreItems();
      this.testcount -= 1;
      event.target.complete();
    }, 500);
  }

  addMoreItems(){
    for(let i=0; i<2; i++){
      this.listNews.push(this.news)
    }
  }
}

interface NewsContent {
  title: string;
  author: string;
  datePosted: string;
  retrievedImageUrl:string;
}
 