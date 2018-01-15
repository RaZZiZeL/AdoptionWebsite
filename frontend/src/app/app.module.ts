import { HomeComponent } from './components/pages/home/home.component';
import { RouterModule, Routes } from '@angular/router';
// CORE
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// UI
import { SuiModule } from 'ng2-semantic-ui';

// Services
import { ApiService } from './service';
import { AppRoutingModule } from './app-routing.module';

// Components
import { AppComponent } from './app.component';
// used to create fake backend
import { fakeBackendProvider } from './service';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';
import { NavigationbarComponent } from './components/navigationbar/navigationbar.component';
import { LoginComponent } from './components/pages/login/login.component';
import { LoginFormComponent } from './components/pages/login/login-form/login-form.component';
import { FaqComponent } from './components/pages/faq/faq.component';
import { AboutComponent } from './components/pages/about/about.component';
import { ContactusFormComponent } from './components/pages/contactus/contactus-form/contactus-form.component';
import { ContactusComponent } from './components/pages/contactus/contactus.component';
import { UserService } from './service/user.service';



const appRoutes:Routes=[
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'home',
    component:HomeComponent
  },
 
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'FAQ',
    component:FaqComponent
  },{

    path:'about',
    component:AboutComponent
  }
  ,
  {
    path:'contactus',
    component:ContactusComponent
  },
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationbarComponent,
    LoginComponent,
    LoginFormComponent,
    FaqComponent,
    AboutComponent,
    ContactusComponent,
    ContactusFormComponent,
  

  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    SuiModule,
  ],
  providers: [
    AppRoutingModule,
    ApiService,
    UserService
    // providers used to create fake backend
    // fakeBackendProvider,
    // MockBackend,
    // BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
