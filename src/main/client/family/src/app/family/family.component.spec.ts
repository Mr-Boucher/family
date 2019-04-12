import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataEditorComponent } from './family.component';

describe('DataEditorComponent', () => {
  let component: DataEditorComponent;
  let fixture: ComponentFixture<DataEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
