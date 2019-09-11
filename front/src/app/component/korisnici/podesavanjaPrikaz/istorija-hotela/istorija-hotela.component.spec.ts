import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaHotelaComponent } from './istorija-hotela.component';

describe('IstorijaHotelaComponent', () => {
  let component: IstorijaHotelaComponent;
  let fixture: ComponentFixture<IstorijaHotelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IstorijaHotelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IstorijaHotelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
