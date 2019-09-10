import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazKompanijaVozilaComponent } from './prikaz-kompanija-vozila.component';

describe('PrikazKompanijaVozilaComponent', () => {
  let component: PrikazKompanijaVozilaComponent;
  let fixture: ComponentFixture<PrikazKompanijaVozilaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazKompanijaVozilaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazKompanijaVozilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
