import {Injectable} from '@angular/core';

import {Observable, Subject} from "rxjs";
import {HttpService} from "../http.service";
import {AlertService} from "../alert/alert.service";

/**
 * The object the service and component handle
 */
export class Family {
  firstName:String;
  mothersName:String;
  fathersName:String;
  phoneNumber:String;
  emailAddress:String;
}

export class Page {
  families:Family[] = [];
  state:String = "initial";
  totalCount:number = 0;
  pageNumber:number = 1;
  pageSize:number = 10;
  filter:string = null;
}

/**
 * Supports the CRUD of families objects
 */
@Injectable()
export class FamilyService {

  objectUrl = "readChildrenOfFather";
  deleteUrl = this.objectUrl + "/";

  subject:Subject<Page> = new Subject();
  _data:Page = new Page(); //Make sure it is defaulted to an empty array else it will be undefined causing errors

  /**
   *
   * @param _httpService
   * @param _alertService
   */
  constructor(private _httpService:HttpService, private _alertService:AlertService) {
    console.log("FamilyService Constructor:" );
  }

  /**
   * getter that converts the families into an observable
   *
   * @returns {Observable<Data[]>}
   */
  get family():Observable<Page> {
    return this.subject.asObservable();
  }

  /**
   *
   */
  search( searchCriteria:Page ):Observable<Page> {
    console.log("Search filter:" + searchCriteria.filter );
    console.log("Search pageNumber:" + searchCriteria.pageNumber );
    console.log("Search pageSize:" + searchCriteria.pageSize );
    console.log("Search state:" + searchCriteria.state );
    let url:string = this.objectUrl;// + "?pageNumber=" + searchCriteria.pageNumber + "&pageSize=" + searchCriteria.pageSize + "&search=";

    //empty search filter is valid so make sure that it does not end up with null as the filter
    if( searchCriteria.filter != null )
      url += searchCriteria.filter;
    this._httpService.load( url, this.searchResult.bind( this ) );

    //
    searchCriteria.state = "Loading";

    //
    return this.subject.asObservable();
  }

  /**
   *
   * @param result
   */
  searchResult( result:any ):void {
    console.log("FamilyService handleResult total_count:" + result['total_count'] + result['page_size'] );
    this._data.totalCount = result['totalCount'];
    this._data.pageSize = result['pageSize'];
    this._data.families = [];
    for( let obj of result["resultSet"] )
    {
      console.log("FamilyService handleResult families:" + obj['id'] + "," + obj['value'] + "" );
      let newObj:Family = new Family();
      newObj.firstName = obj['firstName'];
      newObj.mothersName = obj['mothersName'];
      newObj.fathersName = obj['fathersName'];
      newObj.phoneNumber = obj['phoneNumber'];
      newObj.emailAddress = obj['emailAddress'];

      this._data.families.push( newObj );
    }

    //Emit the families to the subject so the families will refresh with the new value set
    this.subject.next(this._data);

    //
    this._data.state = "Loaded";
  }

  /**
   *
   * @param value
   */
  add(value:String):void {

  //   //create the families object
  //   let newData = new Family();
  //   newData.value = value; //only set the value because the Id is created on the server
  //   this._httpService.add(newData, this.objectUrl, this.refreshSearch.bind( this ), this._data.families);
  }

  /**
   *
   * @param id
   */
  remove(id:string):void {
    this._httpService.remove(id, this.deleteUrl, this.refreshSearch.bind( this ), this._data.families);
  }

  /**
   *
   * @param data
   */
  refreshSearch( result:any ): void {
    this.search( this._data );
  }
}

