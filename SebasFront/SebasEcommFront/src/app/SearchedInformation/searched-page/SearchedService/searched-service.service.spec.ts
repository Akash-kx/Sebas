import { TestBed } from '@angular/core/testing';

import { SearchedServiceService } from './searched-service.service';

describe('SearchedServiceService', () => {
  let service: SearchedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
