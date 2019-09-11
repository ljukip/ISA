import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PozivniceComponent } from './pozivnice.component';

describe('PozivniceComponent', () => {
  let component: PozivniceComponent;
  let fixture: ComponentFixture<PozivniceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PozivniceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PozivniceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
