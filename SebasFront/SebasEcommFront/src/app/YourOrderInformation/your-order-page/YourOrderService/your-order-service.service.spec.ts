import { TestBed } from '@angular/core/testing';

import { YourOrderServiceService } from './your-order-service.service';

describe('YourOrderServiceService', () => {
  let service: YourOrderServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(YourOrderServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
