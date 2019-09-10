import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeVozilaComponent } from './azuriranje-vozila.component';

describe('AzuriranjeVozilaComponent', () => {
  let component: AzuriranjeVozilaComponent;
  let fixture: ComponentFixture<AzuriranjeVozilaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeVozilaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeVozilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
