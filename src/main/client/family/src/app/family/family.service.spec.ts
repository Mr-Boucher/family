import { TestBed, inject } from '@angular/core/testing';

import { DataEditorService } from './families-editor.service';

describe('DataEditorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataEditorService]
    });
  });

  it('should be created', inject([DataEditorService], (service: DataEditorService) => {
    expect(service).toBeTruthy();
  }));
});
