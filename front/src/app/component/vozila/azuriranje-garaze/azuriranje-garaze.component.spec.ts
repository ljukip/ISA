import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeGarazeComponent } from './azuriranje-garaze.component';

describe('AzuriranjeGarazeComponent', () => {
  let component: AzuriranjeGarazeComponent;
  let fixture: ComponentFixture<AzuriranjeGarazeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeGarazeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeGarazeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
