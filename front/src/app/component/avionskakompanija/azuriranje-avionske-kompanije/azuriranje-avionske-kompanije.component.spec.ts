import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeAvionskeKompanijeComponent } from './azuriranje-avionske-kompanije.component';

describe('AzuriranjeAvionskeKompanijeComponent', () => {
  let component: AzuriranjeAvionskeKompanijeComponent;
  let fixture: ComponentFixture<AzuriranjeAvionskeKompanijeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeAvionskeKompanijeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeAvionskeKompanijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
