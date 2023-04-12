import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddToBagInformationComponent } from './add-to-bag-information.component';

describe('AddToBagInformationComponent', () => {
  let component: AddToBagInformationComponent;
  let fixture: ComponentFixture<AddToBagInformationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddToBagInformationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddToBagInformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
