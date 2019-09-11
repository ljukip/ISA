import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopuniSedistePutnikaComponent } from './popuni-sediste-putnika.component';

describe('PopuniSedistePutnikaComponent', () => {
  let component: PopuniSedistePutnikaComponent;
  let fixture: ComponentFixture<PopuniSedistePutnikaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopuniSedistePutnikaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopuniSedistePutnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
