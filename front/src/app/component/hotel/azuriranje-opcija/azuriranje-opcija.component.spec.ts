import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeOpcijaComponent } from './azuriranje-opcija.component';

describe('AzuriranjeOpcijaComponent', () => {
  let component: AzuriranjeOpcijaComponent;
  let fixture: ComponentFixture<AzuriranjeOpcijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeOpcijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeOpcijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
