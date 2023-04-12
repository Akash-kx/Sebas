import { TestBed } from '@angular/core/testing';

import { MensServiceService } from './mens-service.service';

describe('MensServiceService', () => {
  let service: MensServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MensServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
