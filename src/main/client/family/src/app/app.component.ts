import { Component } from '@angular/core';
import {AlertService} from "./alert/alert.service";
import {AlertComponent} from "./alert/alert.component";
import {FamilyComponent} from "./family/family.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'My Playground';

  constructor(private _alertService:AlertService) {
  }

  hasErrors(): boolean  {
    return this._alertService.hasErrors();
  }
}
