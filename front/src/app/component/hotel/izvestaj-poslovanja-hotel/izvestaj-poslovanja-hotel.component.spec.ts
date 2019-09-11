import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IzvestajPoslovanjaHotelComponent } from './izvestaj-poslovanja-hotel.component';

describe('IzvestajPoslovanjaHotelComponent', () => {
  let component: IzvestajPoslovanjaHotelComponent;
  let fixture: ComponentFixture<IzvestajPoslovanjaHotelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IzvestajPoslovanjaHotelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IzvestajPoslovanjaHotelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
