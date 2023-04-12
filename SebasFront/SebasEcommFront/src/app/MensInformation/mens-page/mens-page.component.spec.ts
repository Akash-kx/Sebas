import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensPageComponent } from './mens-page.component';

describe('MensPageComponent', () => {
  let component: MensPageComponent;
  let fixture: ComponentFixture<MensPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MensPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MensPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
