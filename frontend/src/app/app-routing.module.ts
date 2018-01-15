import { LoginComponent } from './components/pages/login/login.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components';
import { AppComponent } from './app.component';

const routes: Routes = [
 
  {
    path: 'app', component: AppComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
