import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'home',
        loadChildren: () => import('../pages/home/home.module').then(m => m.HomePageModule)
      },
      {
        path: 'news',
        loadChildren: () => import('../pages/news/news.module').then(m => m.NewsPageModule)
      },
      {
        path: 'location',
        loadChildren: () => import('../pages/location/location.module').then(m => m.LocationPageModule)
      },
      {
        path: 'about-us',
        loadChildren: () => import('../pages/about-us/about-us.module').then(m => m.AboutUsPageModule)
      },
      {
        path: '',
        redirectTo: '/tabs/home',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
