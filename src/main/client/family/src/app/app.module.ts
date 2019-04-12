import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AlertComponent} from "./alert/alert.component";
import {FamilyComponent} from "./family/family.component";
import {HttpService} from "./http.service";
import {AlertService} from "./alert/alert.service";
import {FamilyService} from "./family/family.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    FamilyComponent,
    AlertComponent
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],

  providers: [
    HttpService,
    AlertService,
    FamilyService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
