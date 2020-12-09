export class NewsContent {
    title: string;
    author: string;
    datePosted: string;
    retrievedImageUrl: string;





    constructor(title: string,
        author: string,
        datePosted: string,
        retrievedImageUrl: string){
            this.title = title;
            this.author = author;
            this.datePosted = datePosted;
            this.retrievedImageUrl = retrievedImageUrl;
        }
}