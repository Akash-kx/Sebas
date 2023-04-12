import { TestBed } from '@angular/core/testing';

import { AddToBagServiceService } from './add-to-bag-service.service';

describe('AddToBagServiceService', () => {
  let service: AddToBagServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddToBagServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
