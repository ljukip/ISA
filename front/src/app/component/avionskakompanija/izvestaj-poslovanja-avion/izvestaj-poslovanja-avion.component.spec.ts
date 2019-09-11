import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IzvestajPoslovanjaAvionComponent } from './izvestaj-poslovanja-avion.component';

describe('IzvestajPoslovanjaAvionComponent', () => {
  let component: IzvestajPoslovanjaAvionComponent;
  let fixture: ComponentFixture<IzvestajPoslovanjaAvionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IzvestajPoslovanjaAvionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IzvestajPoslovanjaAvionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
