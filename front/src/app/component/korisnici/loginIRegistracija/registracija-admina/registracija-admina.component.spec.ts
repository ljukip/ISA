import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistracijaAdminaComponent } from './registracija-admina.component';

describe('RegistracijaAdminaComponent', () => {
  let component: RegistracijaAdminaComponent;
  let fixture: ComponentFixture<RegistracijaAdminaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistracijaAdminaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistracijaAdminaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
