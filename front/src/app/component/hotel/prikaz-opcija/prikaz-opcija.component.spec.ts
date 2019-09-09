import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazOpcijaComponent } from './prikaz-opcija.component';

describe('PrikazOpcijaComponent', () => {
  let component: PrikazOpcijaComponent;
  let fixture: ComponentFixture<PrikazOpcijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrikazOpcijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazOpcijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
