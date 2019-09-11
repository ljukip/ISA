import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazAvionskihKompanijaComponent } from './prikaz-avionskih-kompanija.component';

describe('PrikazAvionskihKompanijaComponent', () => {
  let component: PrikazAvionskihKompanijaComponent;
  let fixture: ComponentFixture<PrikazAvionskihKompanijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazAvionskihKompanijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazAvionskihKompanijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
