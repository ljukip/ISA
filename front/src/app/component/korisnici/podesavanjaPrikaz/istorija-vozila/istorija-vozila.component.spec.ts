import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaVozilaComponent } from './istorija-vozila.component';

describe('IstorijaVozilaComponent', () => {
  let component: IstorijaVozilaComponent;
  let fixture: ComponentFixture<IstorijaVozilaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IstorijaVozilaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IstorijaVozilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
