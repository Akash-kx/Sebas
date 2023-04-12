import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchedPageComponent } from './searched-page.component';

describe('SearchedPageComponent', () => {
  let component: SearchedPageComponent;
  let fixture: ComponentFixture<SearchedPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchedPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
