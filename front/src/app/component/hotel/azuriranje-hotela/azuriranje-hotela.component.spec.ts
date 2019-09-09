import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeHotelaComponent } from './azuriranje-hotela.component';

describe('AzuriranjeHotelaComponent', () => {
  let component: AzuriranjeHotelaComponent;
  let fixture: ComponentFixture<AzuriranjeHotelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AzuriranjeHotelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeHotelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
