import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YourOrderPageComponent } from './your-order-page.component';

describe('YourOrderPageComponent', () => {
  let component: YourOrderPageComponent;
  let fixture: ComponentFixture<YourOrderPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YourOrderPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(YourOrderPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
