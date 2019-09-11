import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazGarazaComponent } from './prikaz-garaza.component';

describe('PrikazGarazaComponent', () => {
  let component: PrikazGarazaComponent;
  let fixture: ComponentFixture<PrikazGarazaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazGarazaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazGarazaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
