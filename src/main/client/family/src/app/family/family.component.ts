import {Component, OnInit, Input, ChangeDetectionStrategy} from '@angular/core';

import {Page, Family, FamilyService} from "./family.service";
import {AlertService} from "../alert/alert.service";
import {Observable} from "rxjs";

@Component({
  selector: 'family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css'],
  providers: [],
  changeDetection: ChangeDetectionStrategy.Default
})
export class FamilyComponent implements OnInit {

  data:Page = new Page();
  private error;
  private loading:boolean;

  constructor(private _familyService:FamilyService, private _alertService:AlertService) {
  }

  ngOnInit() {
    console.log("DataEditorComponent::ngOnInit");
    this._familyService.family.subscribe(
      data => {
        this.data = data;
        console.log("DataEditorComponent::result" + data.families);
      },
      err => {
        this.error = err;
        console.error("DataEditorComponent::error " + err);
      },
      () => {
        console.log('DataEditorComponent::done loading');
      }
    );

    this.getPage(this.data);
  }

  getFamily():Family[] {
    return this.data.families;
  }

  pageChanged(event):number {
    console.log('DataEditorComponent::pageChanged to ' + event);
    this.data.families = [];
    this.data.pageNumber = event;
    this.getPage(this.data);
    return event;
  }

  getPage(page:Page):void {
    this.loading = true;
    this._familyService.search(this.data);
  }

  search(searchCriteria:string, page:number, event):Observable<Page> {
    this.data.filter = searchCriteria;
    this.data.pageNumber = page;
    return this._familyService.search(this.data);
  }

  add(data, $event):void {
    this._familyService.add(data)
  }

  remove(id:string, $event):void {
    this._familyService.remove(id);
  }
}
