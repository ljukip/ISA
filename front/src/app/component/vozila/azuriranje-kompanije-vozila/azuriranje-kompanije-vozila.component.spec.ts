import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeKompanijeVozilaComponent } from './azuriranje-kompanije-vozila.component';

describe('AzuriranjeKompanijeVozilaComponent', () => {
  let component: AzuriranjeKompanijeVozilaComponent;
  let fixture: ComponentFixture<AzuriranjeKompanijeVozilaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeKompanijeVozilaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeKompanijeVozilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
