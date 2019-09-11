import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaLetovaComponent } from './istorija-letova.component';

describe('IstorijaLetovaComponent', () => {
  let component: IstorijaLetovaComponent;
  let fixture: ComponentFixture<IstorijaLetovaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IstorijaLetovaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IstorijaLetovaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
