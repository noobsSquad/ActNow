
import { Component, OnInit, ViewChild } from '@angular/core';
import { IonInfiniteScroll } from '@ionic/angular';
import { NewsContent} from './news-content.payload'; 

import { NewsService } from './news.service';


@Component({
  selector: 'app-news',
  templateUrl: './news.page.html',
  styleUrls: ['./news.page.scss'],
})

export class NewsPage implements OnInit {



  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  // news: NewsContent={author:"John Smith", title:"Testing Title",datePosted:"12/12/2020",retrievedImageUrl:"https://images.unsplash.com/photo-1553576368-05915e96ca1c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"};
  news: NewsContent;
  // listNews: NewsContent[] = [];
  listNews: NewsContent[] = [];
  item: NewsContent = {
    author: "", retrievedImageUrl: "", datePosted: "", title: ""
  };
  holder: any;
  constructor(private newsService: NewsService) {
  }


  ngOnInit() {
    this.getFakeData();
  }

  loadData(event) {
    setTimeout(() => {
      console.log('Done');
      event.target.complete();
    }, 500);
  }



  getFakeData() {
    this.newsService.getTestData().subscribe(data => {
      for(var _i = 0; _i< 10; _i++){
        this.holder = data.value[_i];
        this.listNews.push(new NewsContent(
          this.holder.name,
          this.holder.provider[0].name,
          this.holder.datePublished,
          this.holder.image.thumbnail.contentUrl));
        // console.log(this.listNews);
      }
      console.log(this.listNews)
    }
    );
  }
}


// interface NewsContent {
//   title: string;
//   author: string;
//   datePosted: string;
//   retrievedImageUrl: string;
// }
