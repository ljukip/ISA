import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IzvestajPoslovanjaVoziloComponent } from './izvestaj-poslovanja-vozilo.component';

describe('IzvestajPoslovanjaVoziloComponent', () => {
  let component: IzvestajPoslovanjaVoziloComponent;
  let fixture: ComponentFixture<IzvestajPoslovanjaVoziloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IzvestajPoslovanjaVoziloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IzvestajPoslovanjaVoziloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
