import { TestBed } from '@angular/core/testing';

import { JwtInterInterceptor } from './jwt-inter.interceptor';

describe('JwtInterInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      JwtInterInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: JwtInterInterceptor = TestBed.inject(JwtInterInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
