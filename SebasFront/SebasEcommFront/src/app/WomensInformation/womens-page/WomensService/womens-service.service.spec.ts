import { TestBed } from '@angular/core/testing';

import { WomensServiceService } from './womens-service.service';

describe('WomensServiceService', () => {
  let service: WomensServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WomensServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
